package fr.umontpellier.iut.groupe1.controllers.salles;

import fr.umontpellier.iut.Main;
import fr.umontpellier.iut.groupe1.data.Openable;
import fr.umontpellier.iut.groupe1.view.StepID;
import fr.umontpellier.iut.inventaire.ItemId;
import javafx.animation.AnimationTimer;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class CamThreeController implements Initializable, Openable {
    @FXML
    public ImageView arrowBack;
    @FXML
    public ImageView noir;
    @FXML
    public ImageView serrureCle;
    @FXML
    public ImageView cle;
    @FXML
    public StackPane stackpanePorte;
    @FXML
    public ImageView cadrePorte;
    @FXML
    public ImageView porte;

    private AnimationTimer insertionCle;
    private boolean attente = true;
    MediaPlayer cleInsertion = new MediaPlayer(new Media(getClass().getResource("/sound/groupe2/taquin/soundTaquinMove.mp3").toString()));
    MediaPlayer ouverturePorte = new MediaPlayer(new Media(getClass().getResource("/sound/groupe2/salle/soundOpenDoor.mp3").toString()));

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        cadrePorte.fitWidthProperty().bind(Main.stage.widthProperty());
        cadrePorte.fitHeightProperty().bind(Main.stage.heightProperty());

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
                            ParallelTransition parallelPorte = new ParallelTransition(translateTransition(porte, -2200, 2));
                            parallelPorte.playFromStart();
                        }else {
                            Main.stepManager.removeSallesGroupe1();
                            Main.stepManager.openStep(StepID.START);
                            insertionCle.stop();
                        }
                    }
                }
            };

        serrureCle.setOnMouseClicked(mouseEvent -> {
            if(Main.stepManager.getInventaire().getItemIdSelection() == ItemId.CLE_LABY && serrureCle.isVisible()) {
                cle.setVisible(true);
                Main.stepManager.getInventaire().retirerItem(ItemId.CLE_LABY);
                insertionCle.start();
            }
        });

    }

    @Override
    public void open() {
        if(Main.stepManager.getEnigmeReussi(StepID.CAM4)) {
            serrureCle.setVisible(true);
        }
    }

    public void handleMouseClicked(MouseEvent mouseEvent) {
        if(mouseEvent.getSource().equals(arrowBack)){
            Main.stepManager.openStep(StepID.CAM1);
        }
    }

    private TranslateTransition translateTransition(ImageView porte, double y, double temps){
        TranslateTransition tranlateTransition = new TranslateTransition(Duration.seconds(temps), porte);
        tranlateTransition.setByY(y);
        return tranlateTransition;
    }
}
