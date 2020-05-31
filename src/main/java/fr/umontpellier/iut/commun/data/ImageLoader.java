package fr.umontpellier.iut.commun.data;

import javafx.scene.image.Image;

import java.net.URL;
import java.util.Objects;

public class ImageLoader {

    /**
     * @author Enzo Dardaillon
     *
     * Charge une image (Possibilité de la mettre dans une #ImageView).
     *
     *
     * Exemple d'utilisation :
     *  {@code Image img = ImageLoader.getImage("groupe1/sample.jpg");
     *  OU ENCORE
     *  ImageView view = new ImageView(ImagerLoader.getImage("groupe1/sample.jpg"));}
     *
     * @param relativePath est le chemin dde l'image à charger. Ce fichier doit être stocké dans le dossier resources/raw/
     * @return une #javafx.scene.image.Image
     */
    public static Image getImage(String relativePath) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        URL resource = Objects.requireNonNull(classLoader.getResource("raw/" + relativePath));

        return new Image(resource.getFile());
    }
}
