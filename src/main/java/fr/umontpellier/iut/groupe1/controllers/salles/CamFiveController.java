package fr.umontpellier.iut.groupe1.controllers.salles;

import fr.umontpellier.iut.groupe1.Main;
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

public class CamFiveController implements Initializable {
    @FXML
    private ImageView background;
    @FXML
    private ImageView arrowBack;
    @FXML
    private ImageView goto1;
    @FXML
    private ImageView goto3;
    @FXML
    private ImageView goto4;
    @FXML
    private ImageView goto9;
    @FXML
    private ImageView indiceAutre, indice3, indice33, black;

    @FXML
    void handleButton(MouseEvent mouseEvent){
        if (!(indice33.isVisible() && black.isVisible())){
            indice33.setVisible(true);
            black.setVisible(true);
            indice3.setVisible(false);
            indiceAutre.setVisible(false);
            fr.umontpellier.iut.groupe1.Main.stepManager.dialogue("Une note ! Elle est collée... Je devrais la retenir pour pas l'oublier.");
        }else if (!(indice3.isVisible() && indiceAutre.isVisible())){
            indice33.setVisible(false);
            black.setVisible(false);
            indice3.setVisible(true);
            indiceAutre.setVisible(true);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        background.fitWidthProperty().bind(Main.stage.widthProperty());
        background.fitHeightProperty().bind(Main.stage.heightProperty());
        black.fitWidthProperty().bind(Main.stage.widthProperty());
        black.fitHeightProperty().bind(Main.stage.heightProperty());
    }

    public void handleMouseClicked(MouseEvent mouseEvent) {
        if(mouseEvent.getSource().equals(goto1))
            Main.stepManager.openStep(StepID.CAM1);
        else if(mouseEvent.getSource().equals(goto3)) {
            Main.stepManager.openStep(StepID.CAM3);
            fr.umontpellier.iut.groupe1.Main.stepManager.dialogue("Ca doit être la porte. Mais comment l'ouvrir ?");
        }
        else if(mouseEvent.getSource().equals(goto4)) {
            Main.stepManager.openStep(StepID.CAM4);
            fr.umontpellier.iut.groupe1.Main.stepManager.dialogue("Ca peut se tourner ? hum... Je suppose que je dois trouver la bonne combinaison.");
        }
        else if(mouseEvent.getSource().equals(arrowBack)) {
            Main.stepManager.openStep(StepID.CAM6);
            MediaPlayer sonHeart = new MediaPlayer(new Media(Paths.get("src/main/resources/sound/groupe1/heartbeat.mp3").toUri().toString()));
            sonHeart.setVolume(1.5);
            sonHeart.play();
        }
        else if(mouseEvent.getSource().equals(goto9)) {
            Main.stepManager.openStep(StepID.CAM9);
            fr.umontpellier.iut.groupe1.Main.stepManager.dialogue("Hum... A quoi ça peut servir ? Ca doit être l'ordre de quelque chose...\nMais quoi ?");
        }
    }
}
