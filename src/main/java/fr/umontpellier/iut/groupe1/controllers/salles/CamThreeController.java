package fr.umontpellier.iut.groupe1.controllers.salles;

import fr.umontpellier.iut.groupe1.Main;
import fr.umontpellier.iut.groupe1.data.Openable;
import fr.umontpellier.iut.groupe1.view.StepID;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class CamThreeController implements Initializable, Openable {
    @FXML
    public ImageView arrowBack;
    @FXML
    public ImageView noir;
    @FXML
    public ImageView serrureCle;
    @FXML
    public Rectangle rectangle;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        cadrePorte.fitWidthProperty().bind(Main.stage.widthProperty());
        cadrePorte.fitHeightProperty().bind(Main.stage.heightProperty());

        serrureCle.setOnMouseClicked(mouseEvent -> {
            cle.setVisible(true);

            insertionCle = new AnimationTimer() {
                @Override
                public void handle(long l) {
                    if(cle.getFitWidth() > 84 && cle.getFitHeight() > 84){
                        cle.setFitWidth(cle.getFitWidth() - 0.6);
                        cle.setFitHeight(cle.getFitHeight() - 0.6);
                        cle.setTranslateX(cle.getTranslateX() - 0.3);
                        cle.setTranslateY(cle.getTranslateY() - 0.3);
                    }else {
                        if(attente){
                            try {
                                Thread.sleep(2000);
                                attente = false;
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }else if(!(porte.getBoundsInParent().getMaxY() <= cadrePorte.getBoundsInParent().getMinY())){
                            porte.setTranslateY(porte.getTranslateY() - 1.5);
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
