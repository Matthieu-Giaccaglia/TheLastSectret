package fr.umontpellier.iut.groupe1.controllers;

import fr.umontpellier.iut.groupe1.data.Dialogue;
import fr.umontpellier.iut.groupe1.data.Openable;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class dialogueController implements Openable, Dialogue {

    @FXML
    private Pane boiteD;
    @FXML
    private Label dialogueText;
    @FXML
    private Button closeDialogue;

    public void setText(String s){
        final IntegerProperty i = new SimpleIntegerProperty(0);

        Timeline timeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(
                Duration.seconds(0.0225),
                event -> {
                    if (i.get() > s.length()) {
                        timeline.stop();
                    } else {
                        dialogueText.setText(s.substring(0, i.get()));
                        i.set(i.get() + 1);
                    }
                });
        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void closed(){
        boiteD.setVisible(false);
        dialogueText.setText("");
    }

    @Override
    public void open(String text) {
        boiteD.setVisible(true);

        setText(text);
    }

    @Override
    public void open() {

    }
}
