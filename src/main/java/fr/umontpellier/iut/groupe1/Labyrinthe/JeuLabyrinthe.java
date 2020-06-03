package fr.umontpellier.iut.groupe1.Labyrinthe;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JeuLabyrinthe extends Scene {

    public JeuLabyrinthe(double width, double height, Stage stage) {
        super(new StructureLabyrinthe(width, height, stage), width, height, true);
    }
}
