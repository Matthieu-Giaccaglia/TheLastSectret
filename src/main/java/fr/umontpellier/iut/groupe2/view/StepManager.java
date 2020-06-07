package fr.umontpellier.iut.groupe2.view;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import fr.umontpellier.iut.commun.data.LayoutLoader;
import fr.umontpellier.iut.commun.exceptions.LayoutNotFoundException;
import fr.umontpellier.iut.groupe2.SalleController;
import fr.umontpellier.iut.groupe2.inventaire.Inventaire;
import fr.umontpellier.iut.groupe2.lightsout.LightsOutController;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class StepManager {
    private Inventaire inventaire;
    private final Map<StepID, Step<? extends Parent>> stepMap;
    private StackPane root;
    private final AnchorPane anchorPane = new AnchorPane();
    private Parent gameNode;


    public StepManager(Stage stage){
        stepMap = new HashMap<>();

        try {
            root = (StackPane) LayoutLoader.getLayout("groupe2/layout_main.fxml");
        } catch (LayoutNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }

        assert root != null;

        stage.setScene(new Scene(root, 1920, 1017));
    }

    public void setInventaire(Inventaire inventaire) {
        this.inventaire = inventaire;
    }

    public Inventaire getInventaire() {
        return inventaire;
    }

    public void addStep(Step<? extends Parent> step){
        if(stepMap.containsKey(step.getId())){
            System.err.println("Attention vous avez essayé d'ajouter une Step déjà présente dans la liste !\n" +
                    "StepID : " + step.getId());
        } else {
            stepMap.put(step.getId(), step);
            anchorPane.getChildren().add(step.open());
            //root.getChildren().add(anchorPane);
            step.setVisible(false);
        }
    }

    public void addAnchorPane(){
        root.getChildren().add(anchorPane);
    }

    public void openStep(StepID stepID) {
        if (gameNode != null) gameNode.setVisible(false);
        if (stepMap.containsKey(stepID)) {
            gameNode = stepMap.get(stepID).open();
            gameNode.setVisible(true);
            openStepInventaire();
            //new MediaPlayer(new Media(Paths.get("src/main/resources/raw/groupe2/silenceRoom.mp3").toUri().toString())).play();
        } else {
            System.err.println("Ajoutez votre Step au StepManager avant de l'ouvrir !\n" +
                    "Voir StepManager.addStep(Step step)");
        }
    }

    public void openStepInventaire() {
        if (stepMap.containsKey(StepID.INVENTAIRE)) {
            Parent parent = stepMap.get(StepID.INVENTAIRE).open();
            parent.setLayoutX(710.0);
            parent.setLayoutY(915.0);
            parent.setVisible(true);
        } else {
            System.err.println("Ajoutez votre Step au StepManager avant de l'ouvrir !\n" +
                    "Voir StepManager.addStep(Step step)");
        }
    }
}
