package fr.umontpellier.iut.groupe1.enigmesymbole;

import javafx.geometry.Dimension2D;
import javafx.scene.image.Image;

public class Dessin {

    private Image symbole;
    private Dimension2D dimension2D;

    public Dessin(Image symbole, Dimension2D dimension2D) {
        this.symbole = symbole;
        this.dimension2D = dimension2D;
    }

}
