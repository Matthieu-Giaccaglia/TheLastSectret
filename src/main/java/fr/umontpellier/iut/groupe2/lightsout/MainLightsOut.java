package fr.umontpellier.iut.groupe2.lightsout;

import fr.umontpellier.iut.commun.data.LayoutLoader;
import fr.umontpellier.iut.commun.exceptions.LayoutNotFoundException;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainLightsOut extends Application {
    /*
    public static void main(String[] args) {
        int[][] tableau = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
        LightsOut jeu_walter = new LightsOut(tableau);
        System.out.println(jeu_walter.toString());
        int[] postion0_0 = {0,0};
        int[] postion0_1 = {0,1};
        int[] postion1_1 = {1,1};
        jeu_walter.onClick(postion0_0);
        System.out.println(jeu_walter.toString());
        jeu_walter.onClick(postion0_1);
        System.out.println(jeu_walter.toString());
        jeu_walter.onClick(postion1_1);
        System.out.println(jeu_walter.toString());

        int[][] tableau_gagnant = {{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}};
        LightsOut jeu_walter1 = new LightsOut(tableau_gagnant);
        System.out.println(jeu_walter1.estGagnant());
        System.out.println(jeu_walter.estGagnant());
    }*/
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
        primaryStage.setScene(new Scene(root, 900, 1080));
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
