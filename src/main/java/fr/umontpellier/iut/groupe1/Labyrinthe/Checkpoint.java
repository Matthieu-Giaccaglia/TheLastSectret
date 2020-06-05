package fr.umontpellier.iut.groupe1.Labyrinthe;

import fr.umontpellier.iut.groupe1.data.ImageLoader;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;

public class Checkpoint extends Box {
    public Checkpoint(double translateX, double translateY) {
        this.setWidth(20);
        this.setHeight(20);
        this.setDepth(20);
        this.setTranslateX(translateX);
        this.setTranslateY(translateY);
        this.setTranslateZ(-10);
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseMap(ImageLoader.getImage("groupe1/stone.png"));
        this.setMaterial(material);

    }
}
