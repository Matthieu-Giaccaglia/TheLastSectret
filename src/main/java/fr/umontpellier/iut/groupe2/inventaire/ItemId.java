package fr.umontpellier.iut.groupe2.inventaire;

import fr.umontpellier.iut.groupe1.data.ImageLoader;
import javafx.scene.image.ImageView;

/**
 * Ajouter les id des Items que vous souhaitez utiliser.
 *
 * Séparer les Ids par une virgule (,).
 *
 * Par ex. pour le Taquin j'ai besoin de la piece 25 du puzzle.
 *
 * J'ajoute donc "taquinPiece25" dans l'enum.
 *
 * Faites bien attention à utiliser les bons id pour vos énigmes !
 */



public enum ItemId {
    taquinPiece25(new ImageView(ImageLoader.getImage("groupe2/taquin/piece25.png"))),
    taquinPiece24(new ImageView(ImageLoader.getImage("groupe2/taquin/piece24.png"))),
    taquinPiece23(new ImageView(ImageLoader.getImage("groupe2/taquin/piece23.png"))),
    taquinPiece22(new ImageView(ImageLoader.getImage("groupe2/taquin/piece22.png"))),
    taquinPiece21(new ImageView(ImageLoader.getImage("groupe2/taquin/piece21.png"))),
    taquinPiece20(new ImageView(ImageLoader.getImage("groupe2/taquin/piece20.png")));

    private final ImageView imageView;

    ItemId(ImageView imageView) {
        this.imageView = imageView;
    }

    public ImageView getImageView() {
        return imageView;
    }
}
