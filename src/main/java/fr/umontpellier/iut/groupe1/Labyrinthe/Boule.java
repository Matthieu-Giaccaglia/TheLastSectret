package fr.umontpellier.iut.groupe1.Labyrinthe;

import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;

public class Boule extends Sphere {

    public Boule(double radius, double positionX, double positionY){
        PhongMaterial material = new PhongMaterial();
        //material.setDiffuseMap(new Image(getClass().getResourceAsStream("/resources/images/groupe1/rgb.jpg")));
        //TODO régler pb images
        //material.setSelfIlluminationMap(new Image(getClass().getResourceAsStream("/ressources/blanc.jpg")));
        this.setMaterial(material);
        this.setRadius(radius);
        this.setTranslateX(positionX);
        this.setTranslateY(positionY);
        this.setTranslateZ(-20);

    }


}
