package fr.umontpellier.iut.groupe1.menu;

import fr.umontpellier.iut.groupe1.labyrinthe.BackgroundStackPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class testMenuMain extends Application {


    @Override
    public void start(Stage stage){
        stage.setTitle("test");
        //stage.setScene(new Scene(new BackgroundStackPane(new MenuPause(300), 300, 400, 1950, 1080), 300, 400));
        stage.setScene(new Scene(new BackgroundStackPane(new MenuAccueil(350)), 1000, 800));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
