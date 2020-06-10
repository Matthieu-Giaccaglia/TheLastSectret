package fr.umontpellier.iut.groupe1.view;

import fr.umontpellier.iut.commun.data.LayoutLoader;
import fr.umontpellier.iut.commun.exceptions.LayoutNotFoundException;
import fr.umontpellier.iut.groupe2.inventaire.Inventaire;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class StepManager {
    private final Inventaire inventaire;
    private final Map<StepID, Step<? extends Parent>> stepMap;
    private final List<Node> hud;
    private StackPane root;
    private Parent gameNode;
    private final Map<StepID, Boolean> passageSalle;

    public StepManager(Stage stage, Inventaire inventaire){
        this.inventaire = inventaire;

        stepMap = new HashMap<>();
        passageSalle = new HashMap<>();

        hud = new LinkedList<>();

        try {
            root = (StackPane) LayoutLoader.getLayout("groupe1/layout_main.fxml");
            hud.add(root.lookup("#timer"));
        } catch (LayoutNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }

        assert root != null;
        stage.setScene(new Scene(root, 800, 480));
    }

    public Inventaire getInventaire() {
        return inventaire;
    }

    public void addHudElement(Node parent){
        hud.add(parent);
    }

    public void putHudOnTop(){
        hud.forEach(Node::toFront);
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
            passageSalle.put(stepID, true);
            putHudOnTop();
        } else {
            System.err.println("Ajoutez votre Step au StepManager avant de l'ouvrir !\n" +
                    "Voir StepManager.addStep(Step step)");
        }
    }

    public boolean passageDansSalle(StepID stepID){
        return passageSalle.get(stepID);
    }

}
