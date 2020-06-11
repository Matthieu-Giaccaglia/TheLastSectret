package fr.umontpellier.iut.groupe2.inventaire;

import fr.umontpellier.iut.groupe1.data.ImageLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @author Matthieu Giaccaglia
 *
 * Ajoutez un Id unique et le chemin d'accès de l'image de votre Item afin de les utiliser.
 *
 * Séparer les Ids par une virgule.
 *
 * Exemple d'utilisation :
 *
 * Pour terminer l'énigme du taquin, il faut mettre la pièece du puzzle manquant.
 * J'ajoute : taquinPiece25(new ImageView(ImageLoader.getImage("groupe2/taquin/piece25.png"))).
 * Ainsi, je pourrais l'utiliser l'item dans le jeu.
 *
 * Pour des raisons de praticité, l'inventaire ne pourra pas contenir deux item ayants le même ID
 * Si vous avez donc deux item possédant la même image et qu'ils devront être dans l'inventaire en même temps.
 * Il faudra donc mettre deux Id possédant la même image.
 *
 * Faites bien attention à utiliser les bons id pour vos énigmes !
 */



public enum ItemId {
    taquinPiece12(new ImageView(ImageLoader.getImage("groupe2/taquin/piece12.png"))),
    gemmeBleue(new ImageView(ImageLoader.getImage("groupe2/salle/gemmeBleue.png"))),
    gemmeVerte(new ImageView(ImageLoader.getImage("groupe2/salle/gemmeVerte.png"))),
    gemmeViolette(new ImageView(ImageLoader.getImage("groupe2/salle/gemmeViolette.png"))),
    gemmeRouge(new ImageView(ImageLoader.getImage("groupe2/salle/gemmeRouge.png"))),
    boutonLumiere(new ImageView(ImageLoader.getImage("groupe2/lightsout/BRIQUE_inventaire.png"))),
    marteau(new ImageView(ImageLoader.getImage("groupe2/salle/marteau.png")));


    private final ImageView imageView;

    ItemId(ImageView imageView) {
        this.imageView = imageView;
    }

    public Image getImage() {
        return imageView.getImage();
    }
}
