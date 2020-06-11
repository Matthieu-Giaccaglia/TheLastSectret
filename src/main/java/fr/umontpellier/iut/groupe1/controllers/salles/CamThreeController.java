package fr.umontpellier.iut.groupe1.controllers.salles;

import fr.umontpellier.iut.groupe1.Main;
import fr.umontpellier.iut.groupe1.data.Openable;
import fr.umontpellier.iut.groupe1.view.StepID;
import fr.umontpellier.iut.groupe2.inventaire.ItemId;
import javafx.animation.*;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class CamThreeController implements Initializable, Openable {
    @FXML
    private ImageView arrowBack;
    @FXML
    private ImageView noir;
    @FXML
    private ImageView serrureCle;
    @FXML
    private Rectangle rectangle;
    @FXML
    private ImageView cle;
    @FXML
    private StackPane stackpanePorte;
    @FXML
    private ImageView cadrePorte;
    @FXML
    private ImageView porte;

    private AnimationTimer insertionCle;
    private boolean attente = true;
    MediaPlayer cleInsertion = new MediaPlayer(new Media(Paths.get("src/main/resources/sound/groupe2/taquin/soundTaquinMove.mp3").toUri().toString()));
    MediaPlayer ouverturePorte = new MediaPlayer(new Media(Paths.get("src/main/resources/sound/groupe2/salle/soundOpenDoor.mp3").toUri().toString()));

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        cadrePorte.fitWidthProperty().bind(Main.stage.widthProperty());
        cadrePorte.fitHeightProperty().bind(Main.stage.heightProperty());

        serrureCle.setOnMouseClicked(mouseEvent -> {
            if(Main.stepManager.getInventaire().getItemIdSelection() == ItemId.CLE_LABY) {
                cle.setVisible(true);
            }

            insertionCle = new AnimationTimer() {
                @Override
                public void handle(long l) {
                    if(cle.getFitWidth() > 82 && cle.getFitHeight() > 82){
                        cleInsertion.play();
                        cleInsertion.setVolume(0.30);
                        cle.setFitWidth(cle.getFitWidth() - 0.2);
                        cle.setFitHeight(cle.getFitHeight() - 0.2);
                        cle.setTranslateX(cle.getTranslateX() - 0.1);
                        cle.setTranslateY(cle.getTranslateY() - 0.1);
                    }else {
                        cleInsertion.stop();
                        if(attente){
                            try {
                                Thread.sleep(3000);
                                attente = false;
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }else if(!(porte.getBoundsInParent().getMaxY() <= cadrePorte.getBoundsInParent().getMinY())){
                            ouverturePorte.play();
                            /*TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(6), porte);
                            translateTransition.setByY(-1000);
                            translateTransition.setInterpolator(Interpolator.LINEAR);
                            translateTransition.setOnFinished(event -> {

                            });
                            translateTransition.play();*/

                            Timeline timeline = new Timeline();
                            KeyFrame keyFrame = new KeyFrame(
                                    Duration.seconds(0.8),
                                    event -> {
                                        porte.setTranslateY(porte.getTranslateY() - 2);
                                    });
                            timeline.getKeyFrames().add(keyFrame);
                            timeline.setCycleCount(Animation.INDEFINITE);
                            timeline.play();
                        }
                    }
                }
            };insertionCle.start();
        });
    }

    @Override
    public void open() {
        if(Main.stepManager.getEnigmeReussi(StepID.CAM4)) {
            //setBackgrounds();
        }
    }

    public void handleMouseClicked(MouseEvent mouseEvent) {
        if(mouseEvent.getSource().equals(arrowBack)){
            Main.stepManager.openStep(StepID.CAM1);
        }
    }

    /*public void setBackgrounds() {
        backgroundSansCarre.setVisible(false);
        backgroundAvecCarre.setVisible(true);
    }*/
}
