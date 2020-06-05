package fr.umontpellier.iut.groupe1.controllers;

import fr.umontpellier.iut.groupe1.thread.ThreadTimer;
import javafx.animation.AnimationTimer;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    public Label label_room;
    public Label timerJeu;


    @Override
    public synchronized void initialize(URL url, ResourceBundle resourceBundle) {

        Thread threadTimer = new Thread(new ThreadTimer(timerJeu));
        threadTimer.start();

    }
}
