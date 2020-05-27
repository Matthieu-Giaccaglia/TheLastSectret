package fr.umontpellier.iut.commun.data;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class LayoutLoader {

    /**
     * @author Enzo Dardaillon
     *
     * Exemple d'utilisation :
     *  {@code Parent root = Resources.getLayout("groupe1/sample.fxml");
     *  primaryStage.setScene(new Scene(root));}
     *
     * @param relativePath est le chemin du layout (.fxml) a charger. Ce fichier doit être stocké dans le dossier resources/layout/
     * @return un #Parent initialisé avec le contenu du fichier .fxml
     */
    public static Parent getLayout(String relativePath) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        URL resource = Objects.requireNonNull(classLoader.getResource(relativePath));

        try {
            return FXMLLoader.load(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }

        throw new RuntimeException("Impossible de charger le layout : " + resource);
    }
}
