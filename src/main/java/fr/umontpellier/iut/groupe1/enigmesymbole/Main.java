package fr.umontpellier.iut.groupe1.enigmesymbole;

import fr.umontpellier.iut.commun.data.LayoutLoader;
import fr.umontpellier.iut.commun.exceptions.LayoutNotFoundException;
import fr.umontpellier.iut.groupe1.view.StepManager;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static StepManager stepManager;
    public static Stage stage;

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        primaryStage.setTitle("Escape Game S6");

        stepManager = new StepManager(primaryStage);

        Parent root = null;
        try {
            root = LayoutLoader.getLayout("groupe1/layout_trapeze.fxml");
        } catch (LayoutNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }

        assert root != null;

        primaryStage.setScene(new Scene(root, 1920, 1017));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
