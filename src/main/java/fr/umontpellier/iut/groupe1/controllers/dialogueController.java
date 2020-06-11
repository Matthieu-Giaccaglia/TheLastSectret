package fr.umontpellier.iut.groupe1.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class dialogueController {

    @FXML
    public Pane boiteD;

    @FXML
    public Label dialogueText;

    @FXML
    public Button closeDialogue;

    public void setText(String s){
        dialogueText.setText(s);
    }

    public void closed(){
        boiteD.setVisible(false);
    }
}
