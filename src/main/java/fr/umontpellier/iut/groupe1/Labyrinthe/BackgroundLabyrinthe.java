package fr.umontpellier.iut.groupe1.Labyrinthe;


import fr.umontpellier.iut.groupe1.data.ImageLoader;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.StackPane;

public class BackgroundLabyrinthe extends StackPane {

    public BackgroundLabyrinthe(StructureLabyrinthe structureLabyrinthe){
        this.setBackground(new javafx.scene.layout.Background(new BackgroundImage(ImageLoader.getImage("groupe1/wall_15.jpg"), null, null, null, null)));
        this.getChildren().addAll(structureLabyrinthe);
    }




}
