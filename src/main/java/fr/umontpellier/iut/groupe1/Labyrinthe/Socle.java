package fr.umontpellier.iut.groupe1.Labyrinthe;

import fr.umontpellier.iut.groupe1.data.ImageLoader;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;

public class Socle extends Box {

    public Socle(double width, double depth, double translateX, double translateY) {
        this.setWidth(width);
        this.setHeight(width);
        this.setDepth(depth);
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseMap(ImageLoader.getImage("groupe1/sable.png"));
        this.setMaterial(material);
        this.setTranslateX(translateX);
        this.setTranslateY(translateY);
    }
}
