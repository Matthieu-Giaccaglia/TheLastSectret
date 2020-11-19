package fr.umontpellier.iut.groupe1.controllers.salles;

import fr.umontpellier.iut.Main;
import fr.umontpellier.iut.groupe1.view.StepID;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class CamOneController implements Initializable {
    @FXML
    private ImageView background;
    @FXML
    private ImageView arrowBack;
    @FXML
    private ImageView goto3;
    @FXML
    private ImageView goto4;
    @FXML
    private ImageView goto6;
    @FXML
    private ImageView goto9;
    @FXML
    private Label buttonLabyrinthe;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        background.fitWidthProperty().bind(Main.stage.widthProperty());
        background.fitHeightProperty().bind(Main.stage.heightProperty());

        buttonLabyrinthe.setPrefWidth(buttonLabyrinthe.getPrefWidth() * 2);
        buttonLabyrinthe.setPrefHeight(buttonLabyrinthe.getPrefHeight() * 2 -65);
    }

    public void handleMouseClicked(MouseEvent mouseEvent) {
        if (mouseEvent.getSource().equals(arrowBack))
            Main.stepManager.openStep(StepID.CAM2);
        else if (mouseEvent.getSource().equals(goto3)) {
            Main.stepManager.openStep(StepID.CAM3);
            Main.stepManager.dialogue("Ca doit être la porte. Mais comment l'ouvrir ?");
        }
        else if (mouseEvent.getSource().equals(goto4)) {
            Main.stepManager.openStep(StepID.CAM4);
            Main.stepManager.dialogue("Ca peut se tourner ? hum... Je suppose que je dois trouver la bonne combinaison.");
        }
        else if (mouseEvent.getSource().equals(goto6)) {
            Main.stepManager.openStep(StepID.CAM6);
            MediaPlayer sonHeart = new MediaPlayer(new Media(Paths.get("src/main/resources/sound/groupe1/heartbeat.mp3").toUri().toString()));
            sonHeart.setVolume(1.5);
            sonHeart.play();
            sonHeart.setCycleCount(2);
            Main.stepManager.dialogue("Je crois l'entendre.. Il va sortir ? Pitié non ! Je devrais me dépêcher.");
        } else if (mouseEvent.getSource().equals(goto9)){
            Main.stepManager.openStep(StepID.CAM9);
            Main.stepManager.dialogue("Hum... A quoi ça peut servir ? Ca doit être l'ordre de quelque chose...\nMais quoi ?");
        }
        else if(mouseEvent.getSource().equals(buttonLabyrinthe)) {
            Main.stepManager.openStep(StepID.LABYRINTHE);
        }
    }
}
