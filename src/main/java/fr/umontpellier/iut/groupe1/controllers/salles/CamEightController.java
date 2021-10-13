package fr.umontpellier.iut.groupe1.controllers.salles;

import fr.umontpellier.iut.Main;
import fr.umontpellier.iut.groupe1.view.StepID;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class CamEightController implements Initializable {
    @FXML
    private ImageView background;
    @FXML
    private ImageView arrowBack;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        background.fitWidthProperty().bind(Main.stage.widthProperty());
        background.fitHeightProperty().bind(Main.stage.heightProperty());
    }

    public void handleMouseClicked(MouseEvent mouseEvent) {
        if(mouseEvent.getSource().equals(arrowBack)) {
            Main.stepManager.openStep(StepID.CAM6);
            MediaPlayer sonHeart = new MediaPlayer(new Media(getClass().getResource("/sound/groupe1/heartbeat.mp3").toString()));
            sonHeart.setVolume(1.5);
            sonHeart.play();
        }
    }
}
