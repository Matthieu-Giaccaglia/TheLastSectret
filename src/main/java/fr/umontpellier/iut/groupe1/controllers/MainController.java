package fr.umontpellier.iut.groupe1.controllers;

import fr.umontpellier.iut.groupe1.Main;
import fr.umontpellier.iut.groupe1.view.StepID;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    public Label timerDuJeu;
    public ImageView parametre;

    //--module-path ${PATH_TO_FX} --add-modules javafx.controls,javafx.fxml,javafx.media

    @Override
    public synchronized void initialize(URL url, ResourceBundle resourceBundle) {

        /*ThreadTimer threadTimer = new ThreadTimer(timerDuJeu);
        threadTimer.start();
        threadTimer.setRunning(true);*/

        parametre.setOnMouseClicked(mouseEvent -> Main.stepManager.setPause(Main.stepManager.getThreadTimer().isRunning()));
        Main.stage.addEventHandler(KeyEvent.KEY_PRESSED, keyEvent -> {
            if(keyEvent.getCode() == KeyCode.ESCAPE && Main.stepManager.getCurrentStep() != StepID.LABYRINTHE) //TODO Voir pk ça quitte
                Main.stepManager.setPause(Main.stepManager.getThreadTimer().isRunning());
        });

        Main.stage.setOnCloseRequest(event -> {
            Main.stepManager.getThreadTimer().setRunning(false);
            Main.stepManager.getThreadTimer().setStopped(true);
        });

    }
}
