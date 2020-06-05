package fr.umontpellier.iut.groupe2.lightsout;

import fr.umontpellier.iut.commun.data.LayoutLoader;
import fr.umontpellier.iut.commun.exceptions.LayoutNotFoundException;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainLightsOut extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("LightsOut");

        Parent root = null;
        try {
            root = LayoutLoader.getLayout("groupe2/lightsout/lightsout.fxml");
        } catch (LayoutNotFoundException e) {
            e.printStackTrace();
        }

        assert root != null;
        primaryStage.setScene(new Scene(root, 1920, 1080));
        primaryStage.setFullScreen(true);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
