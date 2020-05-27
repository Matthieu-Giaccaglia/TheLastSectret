package fr.umontpellier.iut.commun.data;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class LayoutLoader {

    /**
     * @author Enzo Dardaillon
     *
     * Charge un layout.
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

    /**
     * @author Enzo Dardaillon
     *
     * Charge un layout et l'affiche sur la fenêtre renseigné en paramètre.
     *
     * Exemple d'utilisation :
     *  {@code openLayout(primaryStage, "groupe1/sample.fxml")}
     *
     * @param stage est la fenêtre
     * @param relativePath est le chemin du layout (.fxml) a charger. Ce fichier doit être stocké dans le dossier resources/layout/
     */
    public static void openLayout(Stage stage, String relativePath){
        stage.setScene(new Scene(getLayout(relativePath)));
    }

    /**
     * @author Enzo Dardaillon
     *
     * Charge un layout et l'affiche sur la fenêtre renseigné en paramètre.
     *
     * Exemple d'utilisation :
     *  {@code Parent root = Resources.getLayout("groupe1/sample.fxml");
     *      *  openLayout(primaryStage, root)}
     *
     * @param stage est la fenêtre
     * @param parent est le Parent à afficher sur la fenêtre
     */
    public static void openLayout(Stage stage, Parent parent){
        stage.setScene(new Scene(parent));
    }
}
