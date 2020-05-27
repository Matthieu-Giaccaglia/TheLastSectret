package fr.umontpellier.iut.groupe1;

import fr.umontpellier.iut.commun.data.LayoutLoader;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Escape Game S6");

        Parent root = LayoutLoader.getLayout("groupe1/layout_main.fxml");

        Node mainNode = root.lookup("stack");

        //if(mainNode != null)



        primaryStage.setScene(new Scene(root, 800, 480));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
