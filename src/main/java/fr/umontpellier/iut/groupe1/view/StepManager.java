package fr.umontpellier.iut.groupe1.view;

import fr.umontpellier.iut.commun.exceptions.LayoutNotFoundException;
import fr.umontpellier.iut.groupe1.Main;
import fr.umontpellier.iut.groupe1.data.Dialogue;
import fr.umontpellier.iut.groupe1.data.Layout;
import fr.umontpellier.iut.groupe1.data.LayoutLoader;
import fr.umontpellier.iut.groupe1.labyrinthe.BackgroundStackPane;
import fr.umontpellier.iut.groupe1.menu.MenuAccueil;
import fr.umontpellier.iut.groupe1.menu.MenuPause;
import fr.umontpellier.iut.groupe1.thread.ThreadTimer;
import fr.umontpellier.iut.groupe2.inventaire.Inventaire;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class StepManager {
    private Inventaire inventaire;
    private final Map<StepID, Step<? extends Parent>> stepMap;
    private final List<Node> hud;
    private AnchorPane root;
    private StackPane stepRoot, pauseMenu;
    private Parent gameNode;
    private StepID currentStep;
    private final Map<StepID, Boolean> passageSalle;
    private final Map<StepID, Boolean> enigmeReussi;

    private Layout<Parent> dialogueLayout;

    private ThreadTimer threadTimer;

    private boolean passeVersGroupe2;

    public StepManager(Stage stage){
        stepMap = new HashMap<>();
        passageSalle = new HashMap<>();
        enigmeReussi = new HashMap<>();

        hud = new LinkedList<>();

        try {
            root = (AnchorPane) LayoutLoader.getLayout("groupe1/layout_main.fxml");
            stepRoot = (StackPane) root.lookup("#stack");
            HBox timer = (HBox) root.lookup("#timer");

            //INVENTAIRE
            Layout<Parent> inventaireDisplay = LayoutLoader.getLayout2("groupe2/inventaire.fxml");
            setInventaire(new Inventaire(inventaireDisplay.getControllerInventaire().getInventaire()));
            root.getChildren().add(inventaireDisplay.getRoot());

            AnchorPane.setBottomAnchor(inventaireDisplay.getRoot(), 0d);
            inventaireDisplay.getRoot().setLayoutX(700);

            //DIALOGUE BOX
            dialogueLayout = LayoutLoader.getLayoutWithController("groupe1/dialogue.fxml");
            Pane dialogueBox = (Pane) dialogueLayout.getRoot();
            dialogueBox.setVisible(false);
            dialogueBox.setLayoutX(500);

            root.getChildren().add(dialogueBox);

            AnchorPane.setBottomAnchor(dialogueBox, 128d);

            hud.add(timer);
            hud.add(inventaireDisplay.getRoot());
            hud.add(dialogueBox);

            pauseMenu = new BackgroundStackPane(new MenuPause(300), 300, 400, 1950, 1080);
            root.getChildren().add(pauseMenu);

            pauseMenu.toBack();

            AnchorPane.setTopAnchor(pauseMenu, 0d);
            AnchorPane.setBottomAnchor(pauseMenu, 0d);
            AnchorPane.setRightAnchor(pauseMenu, 0d);
            AnchorPane.setLeftAnchor(pauseMenu, 0d);

            putHudOnBottom();

            threadTimer = new ThreadTimer((Label) timer.lookup("#timerDuJeu"), 1200);
            threadTimer.start();
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

    public void setInventaire(Inventaire inventaire) {
        this.inventaire = inventaire;
    }

    public void dialogue(String text){
        ((Dialogue) dialogueLayout.getController()).open(text);
    }

    public void putHudOnTop(){
        hud.forEach(Node::toFront);
    }

    public void putHudOnBottom(){
        hud.forEach(Node::toBack);
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

    public void removeSallesGroupe1(){
        if(!passeVersGroupe2){
            passeVersGroupe2 = true;

            Main.mediaPlayer.stop();

            Main.mediaPlayer = new MediaPlayer(new Media(Paths.get("src/main/resources/sound/groupe2/musique/silenceRoom.mp3").toUri().toString()));
            Main.mediaPlayer.setVolume(0.2);
            Main.mediaPlayer.play();

            stepRoot.getChildren().clear();
            stepMap.clear();

            addStep(new Step<>(StepID.ACCUEIL, new Layout<>(new BackgroundStackPane(new MenuAccueil(350)), null)));

            try {
                addStep(new Step<>(StepID.GAMEOVER, LayoutLoader.getLayout2("groupe1/gameOver.fxml")));
                addStep(new Step<>(StepID.START, LayoutLoader.getLayout2("groupe2/layout_game.fxml")));
                addStep(new Step<>(StepID.TAQUIN, LayoutLoader.getLayout2("groupe2/taquin/taquin.fxml")));

                addStep(new Step<>(StepID.LIGHTSOUT, LayoutLoader.getLayout2("groupe2/lightsout/lightsout.fxml")));
            } catch (LayoutNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void openStep(StepID stepID) {
        if (gameNode != null) gameNode.setVisible(false);
        if (stepMap.containsKey(stepID)) {
            gameNode = stepMap.get(stepID).open();
            gameNode.setVisible(true);
            passageSalle.put(stepID, true);
            currentStep = stepID;
            if(stepID != StepID.ACCUEIL) putHudOnTop();
        } else {
            System.err.println("Ajoutez votre Step au StepManager avant de l'ouvrir !\n" +
                    "Voir StepManager.addStep(Step step)");
        }
    }

    public StepID getCurrentStep() {
        return currentStep;
    }

    public boolean passageDansSalle(StepID stepID){
        return (passageSalle.get((stepID)) != null) ? passageSalle.get(stepID) : false;
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
