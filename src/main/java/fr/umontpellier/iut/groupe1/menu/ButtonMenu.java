package fr.umontpellier.iut.groupe1.menu;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class ButtonMenu extends Label {

    public ButtonMenu(String text, double sizeStageX, double translateY){

        this.setText(text);
        this.setAlignment(Pos.CENTER);
        this.setTranslateX(sizeStageX/3);
        this.setTranslateY(translateY);
        this.setFont(Font.font(25));
        this.setPrefSize(sizeStageX/2, 25);

    }



}
