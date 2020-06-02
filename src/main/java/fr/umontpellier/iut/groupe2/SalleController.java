package fr.umontpellier.iut.groupe2;

import fr.umontpellier.iut.commun.data.LayoutLoader;
import fr.umontpellier.iut.commun.exceptions.LayoutNotFoundException;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SalleController {
    @FXML
    private Button taquinButton;
    @FXML
    private Button lightoutButton;

    public void goEnigme(MouseEvent actionEvent) {
        System.out.println("ok");
    }

    public void setScene(Stage primaryStage){

    }

    public Button getTaquinButton(){
        return taquinButton;
    }
}
