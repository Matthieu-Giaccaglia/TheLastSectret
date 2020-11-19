package fr.umontpellier.iut.groupe1.menu;

import fr.umontpellier.iut.Main;
import fr.umontpellier.iut.groupe1.view.StepID;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class MenuAccueil extends Group {


    public MenuAccueil(double sizeStageX){

        ButtonMenu buttonAccueil = new ButtonMenu("The Last Secret", sizeStageX, 0, sizeStageX + 100, 50);
        buttonAccueil.setFont(Font.font(null, FontWeight.EXTRA_BOLD, 50));

        ButtonMenu buttonJouer = new ButtonMenu("Jouer", sizeStageX, 100, sizeStageX + 100, 50);
        buttonJouer.setFont(Font.font(null,40));
        buttonJouer.setOnMouseClicked(mouseEvent -> {
            Main.stepManager.openStep(StepID.CAM1);
            Main.stepManager.getThreadTimer().setRunning(true);
            Main.stepManager.dialogue("Mince ! Je n'aurais pas dû venir dans le tombeau en cette période. Je devrais vite rebrousser chemin.\n" +
                    "(Pour le Labyrinthe, pensez à utiliser les flèches directionnelles pour se déplacer, et la touche ECHAP pour quitter !)");
        });
        buttonJouer.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> buttonJouer.setCursor(Cursor.HAND));

        ButtonMenu buttonQuitter = new ButtonMenu("Quitter", sizeStageX,160, sizeStageX + 100, 50);
        buttonQuitter.setFont(Font.font(null, 40));
        buttonQuitter.setOnMouseClicked(mouseEvent -> System.exit(0));
        buttonQuitter.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> buttonQuitter.setCursor(Cursor.HAND));

        this.getChildren().addAll(buttonAccueil, buttonJouer, buttonQuitter);

    }
}
