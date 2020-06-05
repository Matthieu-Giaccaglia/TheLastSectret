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
import javafx.stage.Stage;

public class Main extends Application {

    public static StepManager stepManager;
    public static Stage stage;

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;

        primaryStage.setTitle("Escape Game S6");

        stepManager = new StepManager(primaryStage, null);
        try {
            /*Group group = new Group();
            group.getChildren().add(new ImageView(ImageLoader.getImage("groupe1/dauphin.png")));
            Step<Group> start = new Step<>(StepID.START, new Layout<>(group));*/

            stepManager.addStep(new Step<>(StepID.CAM1, LayoutLoader.getLayout2("groupe1/salles/layout_cam1.fxml")));
            stepManager.addStep(new Step<>(StepID.CAM2, LayoutLoader.getLayout2("groupe1/salles/layout_cam2.fxml")));
            stepManager.addStep(new Step<>(StepID.CAM3, LayoutLoader.getLayout2("groupe1/salles/layout_cam3.fxml")));
            stepManager.addStep(new Step<>(StepID.CAM4, LayoutLoader.getLayout2("groupe1/salles/layout_cam4.fxml")));
            stepManager.addStep(new Step<>(StepID.CAM5, LayoutLoader.getLayout2("groupe1/salles/layout_cam5.fxml")));
            stepManager.addStep(new Step<>(StepID.CAM6, LayoutLoader.getLayout2("groupe1/salles/layout_cam6.fxml")));
            stepManager.addStep(new Step<>(StepID.CAM7, LayoutLoader.getLayout2("groupe1/salles/layout_cam7.fxml")));
            stepManager.addStep(new Step<>(StepID.CAM8, LayoutLoader.getLayout2("groupe1/salles/layout_cam8.fxml")));
            stepManager.addStep(new Step<>(StepID.CAM9, LayoutLoader.getLayout2("groupe1/salles/layout_cam9.fxml")));

        } catch (LayoutNotFoundException e) {
            e.printStackTrace();
        }

        stepManager.openStep(StepID.CAM1);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
