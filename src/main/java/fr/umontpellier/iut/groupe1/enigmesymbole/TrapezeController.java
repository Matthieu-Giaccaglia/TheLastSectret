package fr.umontpellier.iut.groupe1.enigmesymbole;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;


public class TrapezeController implements Initializable {

    /*------------------- 1er -------------------*/
    @FXML
    private Button flecheDroite0;

    @FXML
    private Button flecheGauche0;

    @FXML
    private ImageView aigle0;

    @FXML
    private ImageView serpent0;

    @FXML
    private ImageView dauphin0;

    @FXML
    private ImageView vide0;

    @FXML
    private ImageView background;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        background.fitWidthProperty().bind(Main.stage.widthProperty());
    }

    @FXML
    void handleButtonAction0(ActionEvent actionEvent) {
        if (actionEvent.getSource() == flecheDroite0 && aigle0.isVisible()) {
            aigle0.setVisible(false);
            serpent0.setVisible(true);
        }else if (actionEvent.getSource() == flecheGauche0 && aigle0.isVisible()){
            aigle0.setVisible(false);
            dauphin0.setVisible(true);
        }

        else if (actionEvent.getSource() == flecheDroite0 && serpent0.isVisible()){
            serpent0.setVisible(false);
            vide0.setVisible(true);
        }else if (actionEvent.getSource() == flecheGauche0 && serpent0.isVisible()){
            serpent0.setVisible(false);
            aigle0.setVisible(true);
        }

        else if (actionEvent.getSource() == flecheDroite0 && vide0.isVisible()){
            vide0.setVisible(false);
            dauphin0.setVisible(true);
        }else if (actionEvent.getSource() == flecheGauche0 && vide0.isVisible()){
            vide0.setVisible(false);
            serpent0.setVisible(true);
        }

        else if (actionEvent.getSource() == flecheDroite0 && dauphin0.isVisible()){
            dauphin0.setVisible(false);
            aigle0.setVisible(true);
        }else if (actionEvent.getSource() == flecheGauche0 && dauphin0.isVisible()){
            dauphin0.setVisible(false);
            vide0.setVisible(true);
        }

    }


    /*------------------- 2eme -------------------*/

    @FXML
    private Button flecheDroite1;

    @FXML
    private Button flecheGauche1;

    @FXML
    private ImageView aigle1;

    @FXML
    private ImageView serpent1;

    @FXML
    private ImageView dauphin1;

    @FXML
    private ImageView vide1;

    @FXML
    void handleButtonAction1(ActionEvent actionEvent) {
        if (actionEvent.getSource() == flecheDroite1 && aigle1.isVisible()) {
            aigle1.setVisible(false);
            serpent1.setVisible(true);
        }else if (actionEvent.getSource() == flecheGauche1 && aigle1.isVisible()){
            aigle1.setVisible(false);
            dauphin1.setVisible(true);
        }

        else if (actionEvent.getSource() == flecheDroite1 && serpent1.isVisible()){
            serpent1.setVisible(false);
            vide1.setVisible(true);
        }else if (actionEvent.getSource() == flecheGauche1 && serpent1.isVisible()){
            serpent1.setVisible(false);
            aigle1.setVisible(true);
        }

        else if (actionEvent.getSource() == flecheDroite1 && vide1.isVisible()){
            vide1.setVisible(false);
            dauphin1.setVisible(true);
        }else if (actionEvent.getSource() == flecheGauche1 && vide1.isVisible()){
            vide1.setVisible(false);
            serpent1.setVisible(true);
        }

        else if (actionEvent.getSource() == flecheDroite1 && dauphin1.isVisible()){
            dauphin1.setVisible(false);
            aigle1.setVisible(true);
        }else if (actionEvent.getSource() == flecheGauche1 && dauphin1.isVisible()){
            dauphin1.setVisible(false);
            vide1.setVisible(true);
        }

    }


    /*------------------- 3eme -------------------*/

    @FXML
    private Button flecheDroite2;

    @FXML
    private Button flecheGauche2;

    @FXML
    private ImageView aigle2;

    @FXML
    private ImageView serpent2;

    @FXML
    private ImageView dauphin2;

    @FXML
    private ImageView vide2;

    @FXML
    void handleButtonAction2(ActionEvent actionEvent) {
        if (actionEvent.getSource() == flecheDroite2 && aigle2.isVisible()) {
            aigle2.setVisible(false);
            serpent2.setVisible(true);
        }else if (actionEvent.getSource() == flecheGauche2 && aigle2.isVisible()){
            aigle2.setVisible(false);
            dauphin2.setVisible(true);
        }

        else if (actionEvent.getSource() == flecheDroite2 && serpent2.isVisible()){
            serpent2.setVisible(false);
            vide2.setVisible(true);
        }else if (actionEvent.getSource() == flecheGauche2 && serpent2.isVisible()){
            serpent2.setVisible(false);
            aigle2.setVisible(true);
        }

        else if (actionEvent.getSource() == flecheDroite2 && vide2.isVisible()){
            vide2.setVisible(false);
            dauphin2.setVisible(true);
        }else if (actionEvent.getSource() == flecheGauche2 && vide2.isVisible()){
            vide2.setVisible(false);
            serpent2.setVisible(true);
        }

        else if (actionEvent.getSource() == flecheDroite2 && dauphin2.isVisible()){
            dauphin2.setVisible(false);
            aigle2.setVisible(true);
        }else if (actionEvent.getSource() == flecheGauche2 && dauphin2.isVisible()){
            dauphin2.setVisible(false);
            vide2.setVisible(true);
        }

    }

}
