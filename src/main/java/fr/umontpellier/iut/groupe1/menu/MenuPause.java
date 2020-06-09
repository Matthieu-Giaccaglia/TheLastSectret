package fr.umontpellier.iut.groupe1.menu;

import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class MenuPause extends Group {

    //TODO MENU PAUSE : mettre tout en inaccessible

    public MenuPause (double sizeStageX){

        ButtonMenu buttonPause = new ButtonMenu("PAUSE", sizeStageX, 75);
        buttonPause.setFont(Font.font(null, FontWeight.EXTRA_BOLD, 30));

        ButtonMenu buttonReprendre = new ButtonMenu("Reprendre", sizeStageX, 150);
        buttonReprendre.setOnMouseClicked(mouseEvent -> {
            System.out.println("button reprendre");
            //TODO renvoyer sur la fenetre actuelle
        });
        buttonReprendre.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> buttonReprendre.setCursor(Cursor.CLOSED_HAND));

        ButtonMenu buttonOption = new ButtonMenu("Option", sizeStageX, 200);
        buttonOption.setOnMouseClicked(mouseEvent -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("En développement");
            alert.setHeaderText(null);
            alert.setContentText("Cette option n'a pas encore été développé.");
            alert.show();
        });
        buttonOption.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> buttonOption.setCursor(Cursor.CLOSED_HAND));

        ButtonMenu buttonQuitter = new ButtonMenu("Quitter", sizeStageX,250);
        buttonQuitter.setOnMouseClicked(mouseEvent -> {
            System.out.println("button quitter");
            //TODO renvoyer sur le menu principal
        });
        buttonQuitter.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> buttonQuitter.setCursor(Cursor.CLOSED_HAND));

        this.getChildren().addAll(buttonPause, buttonReprendre, buttonOption, buttonQuitter);

    }


}
