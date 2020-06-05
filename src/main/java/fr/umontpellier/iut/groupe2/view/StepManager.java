package fr.umontpellier.iut.groupe2.view;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import fr.umontpellier.iut.commun.data.LayoutLoader;
import fr.umontpellier.iut.commun.exceptions.LayoutNotFoundException;
import fr.umontpellier.iut.groupe2.inventaire.Inventaire;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class StepManager {
    private final Inventaire inventaire;
    private final Map<StepID, Step<? extends Parent>> stepMap;
    private StackPane root;
    private Parent gameNode;

    public StepManager(Stage stage, Inventaire inventaire){
        this.inventaire = inventaire;

        stepMap = new HashMap<>();

        try {
            root = (StackPane) LayoutLoader.getLayout("groupe2/layout_main.fxml");
        } catch (LayoutNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }

        assert root != null;
        System.out.println(Screen.getPrimary().getBounds().getWidth());
        System.out.println(Screen.getPrimary().getBounds().getHeight());
        stage.setScene(new Scene(root, Screen.getPrimary().getBounds().getWidth(), Screen.getPrimary().getBounds().getHeight()));
        stage.setFullScreen(true);
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
            root.getChildren().add(step.open());
            step.setVisible(false);
        }
    }

    public void openStep(StepID stepID) {
        if (gameNode != null) gameNode.setVisible(false);
        if (stepMap.containsKey(stepID)) {
            gameNode = stepMap.get(stepID).open();
            gameNode.setVisible(true);
        } else {
            System.err.println("Ajoutez votre Step au StepManager avant de l'ouvrir !\n" +
                    "Voir StepManager.addStep(Step step)");
        }
    }
}