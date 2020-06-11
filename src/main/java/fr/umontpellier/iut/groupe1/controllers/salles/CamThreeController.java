package fr.umontpellier.iut.groupe1.controllers.salles;

import fr.umontpellier.iut.groupe1.Main;
import fr.umontpellier.iut.groupe1.data.Openable;
import fr.umontpellier.iut.groupe1.view.StepID;
import fr.umontpellier.iut.groupe2.inventaire.ItemId;
import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class CamThreeController implements Initializable, Openable {
    @FXML
    private ImageView arrowBack;
    @FXML
    private ImageView serrureCle;
    @FXML
    private ImageView cle;
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
            if (Main.stepManager.getInventaire().getItemIdSelection() == ItemId.CLE_LABY) {
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
                            ParallelTransition parallelPorte = new ParallelTransition(translateTransition(porte, 0,-900));
                            parallelPorte.playFromStart();
                            insertionCle.stop();
                        }
                    }
                }
            };

            if (Main.stepManager.getInventaire().getItemIdSelection() == ItemId.CLE_LABY && serrureCle.isVisible()) {
                cle.setVisible(true);
                insertionCle.start();
            }
        });
    }

    @Override
    public void open() {
        if(Main.stepManager.getEnigmeReussi(StepID.CAM4)) {
            serrureCle.setVisible(true);
            System.out.println("ici");
        }
    }

    public void handleMouseClicked(MouseEvent mouseEvent) {
        if(mouseEvent.getSource().equals(arrowBack)){
            Main.stepManager.openStep(StepID.CAM1);
        }
    }

    private TranslateTransition translateTransition(ImageView porte, double x, double y){
        TranslateTransition tranlateTransition = new TranslateTransition(Duration.seconds(8), porte);
        tranlateTransition.setByY(y);
        tranlateTransition.setByX(x);
        return tranlateTransition;
    }

}
