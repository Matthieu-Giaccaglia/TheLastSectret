package fr.umontpellier.iut.groupe1.controllers;

import fr.umontpellier.iut.groupe1.Main;
import fr.umontpellier.iut.groupe1.thread.ThreadTimer;
import fr.umontpellier.iut.groupe1.view.StepID;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    public Label label_room;
    public Label timerJeu;
    public Label timerDuJeu;
    public ImageView parametre;

    //--module-path ${PATH_TO_FX} --add-modules javafx.controls,javafx.fxml,javafx.media

    @Override
    public synchronized void initialize(URL url, ResourceBundle resourceBundle) {

        ThreadTimer threadTimer = new ThreadTimer(timerDuJeu);
        threadTimer.start();
        threadTimer.setRunning(true);
        //TODO arreter le thread quand le jeu se ferme

        parametre.setOnMouseClicked(mouseEvent -> {
            Main.stepManager.openStep(StepID.PAUSE);
            threadTimer.setRunning(false);
        });

    }
}
