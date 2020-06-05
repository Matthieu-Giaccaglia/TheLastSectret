package fr.umontpellier.iut.groupe2;

import fr.umontpellier.iut.groupe2.handlers.StepChangeRequest;
import fr.umontpellier.iut.groupe2.view.StepID;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class SalleController {


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

    private boolean etape1 = false;


    public void handleButton(ActionEvent event) {

        if(event.getSource() == taquinButton){
            taquinButton.setOnAction(new StepChangeRequest(StepID.TAQUIN, null));
        } else if (event.getSource() == lightoutButton){
            lightoutButton.setOnAction(new StepChangeRequest(StepID.LIGHTSOUT, null));
        } else if (event.getSource() == buttonBackTaquin) {
            if(!etape1){
                etape1();
            }
            buttonBackTaquin.setOnAction(new StepChangeRequest(StepID.START, null));
        }
    }

    public void etape1(){
        //if() {//lightout fini,
            etape1=true;
        //}
    }

    @FXML
    public void onClick(){
        textfield.setOpacity(1.0);
    }

    public Button getTaquinButton(){
        return taquinButton;
    }

}
