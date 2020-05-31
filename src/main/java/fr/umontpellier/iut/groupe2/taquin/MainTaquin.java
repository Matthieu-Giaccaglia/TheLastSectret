package fr.umontpellier.iut.groupe2.taquin;

import fr.umontpellier.iut.commun.data.LayoutLoader;
import fr.umontpellier.iut.commun.exceptions.LayoutNotFoundException;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainTaquin extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Taquin");

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
