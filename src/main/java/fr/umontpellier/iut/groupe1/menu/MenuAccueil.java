package fr.umontpellier.iut.groupe1.menu;

import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class MenuAccueil extends Group {


    public MenuAccueil(double sizeStageX){

        ButtonMenu buttonAccueil = new ButtonMenu("Nom du jeu", sizeStageX, 0, sizeStageX, 50);
        buttonAccueil.setFont(Font.font(null, FontWeight.EXTRA_BOLD, 50));

        ButtonMenu buttonJouer = new ButtonMenu("Jouer", sizeStageX, 100, sizeStageX, 50);
        buttonJouer.setFont(Font.font(null,40));
        buttonJouer.setOnMouseClicked(mouseEvent -> {
            System.out.println("button reprendre");
            //TODO commencer le jeu
        });
        buttonJouer.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> buttonJouer.setCursor(Cursor.CLOSED_HAND));

        ButtonMenu buttonQuitter = new ButtonMenu("Quitter", sizeStageX,160, sizeStageX, 50);
        buttonQuitter.setFont(Font.font(null, 40));
        buttonQuitter.setOnMouseClicked(mouseEvent -> {
            System.exit(0);
        });
        buttonQuitter.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> buttonQuitter.setCursor(Cursor.CLOSED_HAND));

        this.getChildren().addAll(buttonAccueil, buttonJouer, buttonQuitter);

    }

}
