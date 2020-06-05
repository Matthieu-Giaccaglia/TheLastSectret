package fr.umontpellier.iut.groupe2;

import com.sun.javafx.menu.MenuItemBase;
import fr.umontpellier.iut.commun.data.LayoutLoader;
import fr.umontpellier.iut.commun.exceptions.LayoutNotFoundException;
import fr.umontpellier.iut.groupe2.handlers.StepChangeRequest;
import fr.umontpellier.iut.groupe2.view.StepID;
import fr.umontpellier.iut.groupe2.view.StepManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SalleController {
    @FXML
    private Button buttonBackTaquin;
    @FXML
    private Button taquinButton;
    @FXML
    private Button lightoutButton;



    public void handleButton(ActionEvent event) {

        if(event.getSource() == taquinButton){
            taquinButton.setOnAction(new StepChangeRequest(StepID.TAQUIN, null));
        } else if (event.getSource() == lightoutButton){
            lightoutButton.setOnAction(new StepChangeRequest(StepID.LIGHTSOUT, null));
        } else if (event.getSource() == buttonBackTaquin) {
            buttonBackTaquin.setOnAction(new StepChangeRequest(StepID.START, null));
        }
    }


    public Button getTaquinButton(){
        return taquinButton;
    }

}
