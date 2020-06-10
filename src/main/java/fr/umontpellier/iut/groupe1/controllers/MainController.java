package fr.umontpellier.iut.groupe1.controllers;

import fr.umontpellier.iut.groupe1.thread.ThreadTimer;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    public Label label_room;
    public Label timerJeu;
    public Label timerDuJeu;


    //--module-path ${PATH_TO_FX} --add-modules javafx.controls,javafx.fxml

    @Override
    public synchronized void initialize(URL url, ResourceBundle resourceBundle) {

        Thread threadTimer = new Thread(new ThreadTimer(timerDuJeu));
        //threadTimer.start();
        //TODO arreter le thread quand le jeu se ferme

    }
}
