package fr.umontpellier.iut.groupe2.taquin;

import fr.umontpellier.iut.commun.data.LayoutLoader;
import fr.umontpellier.iut.commun.exceptions.LayoutNotFoundException;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Escape Game S6");

        Parent root = null;
        try {
            root = LayoutLoader.getLayout("groupe2/taquin/taquin.fxml");
        } catch (LayoutNotFoundException e) {
            e.printStackTrace();
        }

        assert root != null;
        primaryStage.setScene(new Scene(root, 900, 1080));
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
