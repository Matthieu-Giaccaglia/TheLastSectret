package fr.umontpellier.iut.groupe2;

import fr.umontpellier.iut.commun.data.LayoutLoader;
import fr.umontpellier.iut.commun.exceptions.LayoutNotFoundException;
import fr.umontpellier.iut.groupe2.inventory.Inventaire;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Inventaire inventaire = new Inventaire();
        primaryStage.setTitle("Escape Game S6");


        Parent root = null;
        try {
            root = LayoutLoader.getLayout("groupe2/layout_main.fxml");
        } catch (LayoutNotFoundException e) {
            e.printStackTrace();
        }

        assert root != null;
        primaryStage.setScene(new Scene(root, 800, 800));
        primaryStage.show();

        inventaire.ajoutItem("@../../raw.groupe2/piece25.png");

    }


    public static void main(String[] args) {
        launch(args);
    }
}
