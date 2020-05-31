package fr.umontpellier.iut.groupe1.enigmesymbole;

import fr.umontpellier.iut.commun.data.LayoutLoader;
import fr.umontpellier.iut.commun.exceptions.LayoutNotFoundException;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Escape Game S6");

        Parent root = null;
        try {
            root = LayoutLoader.getLayout("groupe1/layout_trapeze.fxml");
        } catch (LayoutNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }

        assert root != null;

        primaryStage.setScene(new Scene(root, 800, 480));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
