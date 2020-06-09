package fr.umontpellier.iut.groupe1.labyrinthe;

import fr.umontpellier.iut.groupe1.data.ImageLoader;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;

public class Clef extends Box {

    public Clef(double translateX, double translateY){
        this.setWidth(15);
        this.setHeight(15);
        this.setDepth(15);
        this.setTranslateX(translateX);
        this.setTranslateY(translateY);
        this.setTranslateZ(-20);
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseMap(ImageLoader.getImage("groupe1/cobblestone.png"));
        this.setMaterial(material);
    }

}
