package fr.umontpellier.iut.groupe1;

import fr.umontpellier.iut.commun.exceptions.LayoutNotFoundException;
import fr.umontpellier.iut.groupe1.data.ImageLoader;
import fr.umontpellier.iut.groupe1.data.Layout;
import fr.umontpellier.iut.groupe1.data.LayoutLoader;
import fr.umontpellier.iut.groupe1.view.Step;
import fr.umontpellier.iut.groupe1.view.StepID;
import fr.umontpellier.iut.groupe1.view.StepManager;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {

    public static StepManager stepManager;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Escape Game S6");

        

        stepManager = new StepManager(primaryStage, null);
        try {
            //LayoutLoader.getLayout2("groupe1/layout_game.fxml")
            Group group = new Group();
            group.getChildren().add(new ImageView(ImageLoader.getImage("groupe1/dauphin.png")));
            Step<Group> start = new Step<>(StepID.START, new Layout<>(group));
            

            stepManager.addStep(start);
            stepManager.addStep(new Step<>(StepID.TRAPEZE, LayoutLoader.getLayout2("groupe1/layout_trapeze.fxml")));
        } catch (LayoutNotFoundException e) {
            e.printStackTrace();
        }

        stepManager.openStep(StepID.START);

        new Thread(() -> {
            try {
                Thread.sleep(5000);
                Platform.runLater(() -> stepManager.openStep(StepID.TRAPEZE));
                Thread.sleep(5000);
                Platform.runLater(() -> stepManager.openStep(StepID.START));
                Thread.sleep(5000);
                Platform.runLater(() -> stepManager.openStep(StepID.TRAPEZE));
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
