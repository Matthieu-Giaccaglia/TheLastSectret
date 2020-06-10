package fr.umontpellier.iut.groupe1.enigmesymbole;

import fr.umontpellier.iut.groupe1.view.StepID;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import static fr.umontpellier.iut.groupe1.Main.*;


public class TrapezeController implements Initializable {

    //@FXML
    //private ImageView buttonValideur;

    private MediaPlayer mauvaiseCombiSon;


    public void gagne(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Mouais...");
        alert.setHeaderText(null);
        alert.setContentText("Ntm t'as win PD va");
        alert.show();
    }

    public void mauvaiseCombi(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Et c'est dommage !");
        alert.setHeaderText(null);
        alert.setContentText("Tu devrais te remettre en question...\nC'est la mauvaise combinaison !\nDépêche-toi ou elle t'attrapera !");
        alert.show();
    }

    public void sonOOF(){
        mauvaiseCombiSon = new MediaPlayer(new Media(Paths.get("src/main/resources/sound/groupe1/roblox-death-sound-loud.mp3").toUri().toString()));
        mauvaiseCombiSon.play();
    }

    public void handleButtonValide(MouseEvent actionEvent) {
        if (aigle0.isVisible() && aigle1.isVisible() && serpent2.isVisible() && !stepManager.passageDansSalle(StepID.CAM8)) {
            mauvaiseCombi();
            sonOOF();
        }else if(aigle0.isVisible() && aigle1.isVisible() && serpent2.isVisible() && stepManager.passageDansSalle(StepID.CAM8)){
            gagne();
        }else {
            mauvaiseCombi();
            sonOOF();
        }
    }


    /*------------------- 1er -------------------*/
    @FXML
    private ImageView flecheGauche0;

    @FXML
    private ImageView flecheDroite0;

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

    @FXML
    private ImageView aigleCote0;

    @FXML
    private ImageView serpentCote0;

    @FXML
    private ImageView dauphinCote0;

    @FXML
    private ImageView videCote0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        background.fitWidthProperty().bind(stage.widthProperty());
    }

    @FXML
    void handleButtonAction0(MouseEvent actionEvent) {
        if (actionEvent.getSource() == flecheGauche0 && aigle0.isVisible()) {
            aigle0.setVisible(false);
            serpent0.setVisible(true);
            serpentCote0.setVisible(false);
            videCote0.setVisible(true);
        }else if (actionEvent.getSource() == flecheDroite0 && aigle0.isVisible()){
            aigle0.setVisible(false);
            dauphin0.setVisible(true);
            serpentCote0.setVisible(false);
            aigleCote0.setVisible(true);
        }

        else if (actionEvent.getSource() == flecheGauche0 && serpent0.isVisible()){
            serpent0.setVisible(false);
            vide0.setVisible(true);
            videCote0.setVisible(false);
            dauphinCote0.setVisible(true);
        }else if (actionEvent.getSource() == flecheDroite0 && serpent0.isVisible()){
            serpent0.setVisible(false);
            aigle0.setVisible(true);
            videCote0.setVisible(false);
            serpentCote0.setVisible(true);
        }

        else if (actionEvent.getSource() == flecheGauche0 && vide0.isVisible()){
            vide0.setVisible(false);
            dauphin0.setVisible(true);
            dauphinCote0.setVisible(false);
            aigleCote0.setVisible(true);
        }else if (actionEvent.getSource() == flecheDroite0 && vide0.isVisible()){
            vide0.setVisible(false);
            serpent0.setVisible(true);
            dauphinCote0.setVisible(false);
            videCote0.setVisible(true);
        }

        else if (actionEvent.getSource() == flecheGauche0 && dauphin0.isVisible()){
            dauphin0.setVisible(false);
            aigle0.setVisible(true);
            aigleCote0.setVisible(false);
            serpentCote0.setVisible(true);
        }else if (actionEvent.getSource() == flecheDroite0 && dauphin0.isVisible()){
            dauphin0.setVisible(false);
            vide0.setVisible(true);
            aigleCote0.setVisible(false);
            dauphinCote0.setVisible(true);
        }

    }


    /*------------------- 2eme -------------------*/

    @FXML
    private ImageView flecheGauche1;

    @FXML
    private ImageView flecheDroite1;

    @FXML
    private ImageView aigle1;

    @FXML
    private ImageView serpent1;

    @FXML
    private ImageView dauphin1;

    @FXML
    private ImageView vide1;

    @FXML
    void handleButtonAction1(MouseEvent actionEvent) {
        if (actionEvent.getSource() == flecheGauche1 && aigle1.isVisible()) {
            aigle1.setVisible(false);
            serpent1.setVisible(true);
        }else if (actionEvent.getSource() == flecheDroite1 && aigle1.isVisible()){
            aigle1.setVisible(false);
            dauphin1.setVisible(true);
        }

        else if (actionEvent.getSource() == flecheGauche1 && serpent1.isVisible()){
            serpent1.setVisible(false);
            vide1.setVisible(true);
        }else if (actionEvent.getSource() == flecheDroite1 && serpent1.isVisible()){
            serpent1.setVisible(false);
            aigle1.setVisible(true);
        }

        else if (actionEvent.getSource() == flecheGauche1 && vide1.isVisible()){
            vide1.setVisible(false);
            dauphin1.setVisible(true);
        }else if (actionEvent.getSource() == flecheDroite1 && vide1.isVisible()){
            vide1.setVisible(false);
            serpent1.setVisible(true);
        }

        else if (actionEvent.getSource() == flecheGauche1 && dauphin1.isVisible()){
            dauphin1.setVisible(false);
            aigle1.setVisible(true);
        }else if (actionEvent.getSource() == flecheDroite1 && dauphin1.isVisible()){
            dauphin1.setVisible(false);
            vide1.setVisible(true);
        }

    }


    /*------------------- 3eme -------------------*/

    @FXML
    private ImageView flecheGauche2;

    @FXML
    private ImageView flecheDroite2;

    @FXML
    private ImageView aigle2;

    @FXML
    private ImageView serpent2;

    @FXML
    private ImageView dauphin2;

    @FXML
    private ImageView vide2;

    @FXML
    private ImageView aigleCote2;

    @FXML
    private ImageView serpentCote2;

    @FXML
    private ImageView dauphinCote2;

    @FXML
    private ImageView videCote2;

    @FXML
    void handleButtonAction2(MouseEvent actionEvent) {
        if (actionEvent.getSource() == flecheGauche2 && aigle2.isVisible()) {
            aigle2.setVisible(false);
            serpent2.setVisible(true);
            dauphinCote2.setVisible(false);
            aigleCote2.setVisible(true);
        }else if (actionEvent.getSource() == flecheDroite2 && aigle2.isVisible()){
            aigle2.setVisible(false);
            dauphin2.setVisible(true);
            dauphinCote2.setVisible(false);
            videCote2.setVisible(true);
        }

        else if (actionEvent.getSource() == flecheGauche2 && serpent2.isVisible()){
            serpent2.setVisible(false);
            vide2.setVisible(true);
            aigleCote2.setVisible(false);
            serpentCote2.setVisible(true);
        }else if (actionEvent.getSource() == flecheDroite2 && serpent2.isVisible()){
            serpent2.setVisible(false);
            aigle2.setVisible(true);
            aigleCote2.setVisible(false);
            dauphinCote2.setVisible(true);
        }

        else if (actionEvent.getSource() == flecheGauche2 && vide2.isVisible()){
            vide2.setVisible(false);
            dauphin2.setVisible(true);
            serpentCote2.setVisible(false);
            videCote2.setVisible(true);
        }else if (actionEvent.getSource() == flecheDroite2 && vide2.isVisible()){
            vide2.setVisible(false);
            serpent2.setVisible(true);
            serpentCote2.setVisible(false);
            aigleCote2.setVisible(true);
        }

        else if (actionEvent.getSource() == flecheGauche2 && dauphin2.isVisible()){
            dauphin2.setVisible(false);
            aigle2.setVisible(true);
            videCote2.setVisible(false);
            dauphinCote2.setVisible(true);
        }else if (actionEvent.getSource() == flecheDroite2 && dauphin2.isVisible()){
            dauphin2.setVisible(false);
            vide2.setVisible(true);
            videCote2.setVisible(false);
            serpentCote2.setVisible(true);
        }

    }

    @FXML
    private ImageView arrowBack;

    @FXML
    void handleMouseClicked(MouseEvent mouseEvent){
        if(mouseEvent.getSource().equals(arrowBack))
            stepManager.openStep(StepID.CAM1);
    }

}
