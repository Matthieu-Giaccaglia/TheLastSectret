package fr.umontpellier.iut.groupe2;

import fr.umontpellier.iut.groupe2.handlers.StepChangeRequest;
import fr.umontpellier.iut.groupe2.lightsout.LightsOutController;
import fr.umontpellier.iut.groupe2.view.Step;
import fr.umontpellier.iut.groupe2.view.StepID;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;


public class SalleController {

    @FXML
    public ImageView dark_Id;
    @FXML
    private Button buttonBackTaquin;
    @FXML
    private Button taquinButton;
    @FXML
    private Button lightoutButton;
    @FXML
    private Button Gvh;
    @FXML
    private TextField textfield;


    public void handleButton(ActionEvent event) {

        if (event.getSource() == taquinButton) {
            taquinButton.setOnAction(new StepChangeRequest(StepID.TAQUIN, null));
        } else if (event.getSource() == lightoutButton) {
            lightoutButton.setOnAction(new StepChangeRequest(StepID.LIGHTSOUT, null));
        } else if (event.getSource() == buttonBackTaquin) {
            buttonBackTaquin.setOnAction(new StepChangeRequest(StepID.START, null));
        }
        /*
        if(LightsOutController.gagne) {//il faut faire un getstep == Start
            dark_Id.setVisible(false); // Pour l'instant, renvoie nullpointerexception, peut etre pck on clique deux fois dessus mais marche
        }
        */
        if(dark_Id.isVisible()){
            dark_Id.setVisible(false);
        }
    }

    @FXML
    public void onClick(){
        textfield.setOpacity(1.0);
    }

    public Button getTaquinButton(){
        return taquinButton;
    }

}
