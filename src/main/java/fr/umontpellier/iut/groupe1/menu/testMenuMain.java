package fr.umontpellier.iut.groupe1.menu;

import fr.umontpellier.iut.groupe1.labyrinthe.BackgroundStackPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class testMenuMain extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("test");
        //BackgroundStackPane backgroundStackPane = new BackgroundStackPane(new MenuPause(350, sc));
        //backgroundStackPane.setPrefSize(300, 400);
        stage.setScene(new Scene(new BackgroundStackPane(new MenuPause(350), 300, 400), 300, 400));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
