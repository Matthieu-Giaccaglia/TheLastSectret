package fr.umontpellier.iut.groupe2;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

import java.awt.*;
import java.awt.event.MouseEvent;

public class TestController {
    @FXML
    private StackPane stack;
    @FXML
    private BorderPane HUD;
    @FXML
    private AnchorPane game;
    @FXML
    private SalleController salleController;


    public void goEnigme(MouseEvent mouseEvent){
        if (mouseEvent.getSource() == salleController.getTaquinButton()){
            System.out.println("bien ouj");
        }

    }
}
