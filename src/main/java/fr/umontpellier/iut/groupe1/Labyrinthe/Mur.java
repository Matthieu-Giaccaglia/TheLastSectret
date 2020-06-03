package fr.umontpellier.iut.groupe1.Labyrinthe;

import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;

public class Mur extends Box {



    public Mur (double width, double height, double depth, double translateX, double translateY){
        this.setWidth(width);
        this.setHeight(height);
        this.setDepth(depth);
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.BLACK);
        this.setMaterial(material);
        this.setTranslateZ(-depth/2);
        this.setTranslateX(translateX);
        this.setTranslateY(translateY);
    }

}
