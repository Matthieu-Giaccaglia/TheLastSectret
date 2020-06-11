package fr.umontpellier.iut.groupe1.view;

import fr.umontpellier.iut.commun.data.LayoutLoader;
import fr.umontpellier.iut.commun.exceptions.LayoutNotFoundException;
import fr.umontpellier.iut.groupe1.labyrinthe.BackgroundStackPane;
import fr.umontpellier.iut.groupe1.menu.MenuPause;
import fr.umontpellier.iut.groupe1.thread.ThreadTimer;
import fr.umontpellier.iut.groupe2.inventaire.Inventaire;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
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
    private AnchorPane root;
    private StackPane stepRoot, pauseMenu;
    private Parent gameNode;
    private StepID currentStep;
    private final Map<StepID, Boolean> passageSalle;
    private final Map<StepID, Boolean> enigmeReussi;

    private ThreadTimer threadTimer;

    public StepManager(Stage stage, Inventaire inventaire){
        this.inventaire = inventaire;

        stepMap = new HashMap<>();
        passageSalle = new HashMap<>();
        enigmeReussi = new HashMap<>();

        hud = new LinkedList<>();

        try {
            root = (AnchorPane) LayoutLoader.getLayout("groupe1/layout_main.fxml");
            stepRoot = (StackPane) root.lookup("#stack");
            HBox timer = (HBox) root.lookup("#timer");
            hud.add(timer);

            pauseMenu = new BackgroundStackPane(new MenuPause(300), 300, 400, 1950, 1080);
            root.getChildren().add(pauseMenu);

            pauseMenu.toBack();

            AnchorPane.setTopAnchor(pauseMenu, 0d);
            AnchorPane.setBottomAnchor(pauseMenu, 0d);
            AnchorPane.setRightAnchor(pauseMenu, 0d);
            AnchorPane.setLeftAnchor(pauseMenu, 0d);

            threadTimer = new ThreadTimer((Label) timer.lookup("#timerDuJeu"));
            threadTimer.start(); //todo seulement quand on lance la partie !
            threadTimer.setRunning(true);
        } catch (LayoutNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }

        assert root != null;
        stage.setScene(new Scene(root, 800, 480, true));
    }

    public Inventaire getInventaire() {
        return inventaire;
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
            stepRoot.getChildren().add(step.open());
            step.setVisible(false);
        }
    }

    public void openStep(StepID stepID) {
        if (gameNode != null) gameNode.setVisible(false);
        if (stepMap.containsKey(stepID)) {
            gameNode = stepMap.get(stepID).open();
            gameNode.setVisible(true);
            passageSalle.put(stepID, true);
            currentStep = stepID;
            putHudOnTop();
        } else {
            System.err.println("Ajoutez votre Step au StepManager avant de l'ouvrir !\n" +
                    "Voir StepManager.addStep(Step step)");
        }
    }

    public StepID getCurrentStep() {
        return currentStep;
    }

    public boolean passageDansSalle(StepID stepID){
        return passageSalle.get(stepID);
    }

    public boolean getEnigmeReussi(StepID stepID){
        return (enigmeReussi.get(stepID) != null) ? enigmeReussi.get(stepID) : false;
    }

    public void setEnigmeReussi(StepID stepID) {
        enigmeReussi.put(stepID, true);
    }

    public void setPause(boolean paused) {
        threadTimer.setRunning(!paused);

        if(paused)
            pauseMenu.toFront();
        else
            pauseMenu.toBack();
    }

    public ThreadTimer getThreadTimer() {
        return threadTimer;
    }
}
