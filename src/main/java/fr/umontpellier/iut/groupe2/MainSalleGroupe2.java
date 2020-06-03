package fr.umontpellier.iut.groupe2;

import fr.umontpellier.iut.commun.data.Layout;
import fr.umontpellier.iut.commun.data.LayoutLoader;
import fr.umontpellier.iut.commun.exceptions.LayoutNotFoundException;
import fr.umontpellier.iut.groupe2.view.Step;
import fr.umontpellier.iut.groupe2.view.StepID;
import fr.umontpellier.iut.groupe2.view.StepManager;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainSalleGroupe2 extends Application {

    public static StepManager stepManager;

    @Override
    public void start(Stage primaryStage){

        primaryStage.setTitle("Escape Game S6");

        stepManager = new StepManager(primaryStage, null);
        try {
            stepManager.addStep(new Step(StepID.START, new Layout("groupe2/layout_game.fxml")));
            stepManager.addStep(new Step(StepID.TAQUIN, new Layout("groupe2/taquin/taquin.fxml")));
        } catch (LayoutNotFoundException e) {
            e.printStackTrace();
        }

        stepManager.openStep(StepID.START);

        new Thread(() -> {
            try {
                Thread.sleep(5000);
                Platform.runLater(() -> stepManager.openStep(StepID.TAQUIN));
                Thread.sleep(5000);
                Platform.runLater(() -> stepManager.openStep(StepID.START));
                Thread.sleep(5000);
                Platform.runLater(() -> stepManager.openStep(StepID.TAQUIN));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
