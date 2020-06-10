package fr.umontpellier.iut.groupe1;

import fr.umontpellier.iut.commun.exceptions.LayoutNotFoundException;
import fr.umontpellier.iut.groupe1.data.ImageLoader;
import fr.umontpellier.iut.groupe1.data.Layout;
import fr.umontpellier.iut.groupe1.data.LayoutLoader;
import fr.umontpellier.iut.groupe1.enigmesymbole.TrapezeController;
import fr.umontpellier.iut.groupe1.labyrinthe.BackgroundStackPane;
import fr.umontpellier.iut.groupe1.menu.MenuPause;
import fr.umontpellier.iut.groupe1.utils.Callback;
import fr.umontpellier.iut.groupe1.view.Step;
import fr.umontpellier.iut.groupe1.view.StepID;
import fr.umontpellier.iut.groupe1.view.StepManager;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.nio.file.Paths;

public class Main extends Application {

    public static StepManager stepManager;
    public static Stage stage;
    private MediaPlayer zombiesound;

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        primaryStage.setMaximized(true);

        primaryStage.setTitle("Escape Game S6");

        stepManager = new StepManager(primaryStage, null);
        try {
            /*Group group = new Group();
            group.getChildren().add(new ImageView(ImageLoader.getImage("groupe1/dauphin.png")));
            Step<Group> start = new Step<>(StepID.START, new Layout<>(group));*/

            stepManager.addStep(new Step<>(StepID.CAM1, LayoutLoader.getLayout2("groupe1/salles/layout_cam1.fxml")));
            stepManager.addStep(new Step<>(StepID.CAM2, LayoutLoader.getLayout2("groupe1/salles/layout_cam2.fxml")));
            stepManager.addStep(new Step<>(StepID.CAM3, LayoutLoader.getLayout2("groupe1/salles/layout_cam3.fxml")));

            Step<Parent> trapeze = new Step<>(StepID.CAM4, LayoutLoader.getLayout2("groupe1/layout_trapeze.fxml"));
            trapeze.setOnStart(() -> {
                //todo ajouter son
            });

            stepManager.addStep(trapeze);
            stepManager.addStep(new Step<>(StepID.CAM5, LayoutLoader.getLayout2("groupe1/salles/layout_cam5.fxml")));
            stepManager.addStep(new Step<>(StepID.CAM6, LayoutLoader.getLayout2("groupe1/salles/layout_cam6.fxml")));

            Step<Parent> cerco = new Step<>(StepID.CAM7, LayoutLoader.getLayout2("groupe1/salles/layout_cam7.fxml"));
            cerco.setOnStart(() -> {
                zombiesound = new MediaPlayer(new Media(Paths.get("src/main/resources/sound/groupe1/minecraft-zombie-bruh-sound-effect.mp3").toUri().toString()));
                zombiesound.play();
            });
            stepManager.addStep(cerco);

            Step<Parent> tableTradu = new Step<>(StepID.CAM8, LayoutLoader.getLayout2("groupe1/salles/layout_cam8.fxml"));
            tableTradu.setOnStart(() -> {
                zombiesound = new MediaPlayer(new Media(Paths.get("src/main/resources/sound/groupe1/minecraft-zombie-bruh-sound-effect.mp3").toUri().toString()));
                zombiesound.play();
            });
            stepManager.addStep(tableTradu);
            stepManager.addStep(new Step<>(StepID.CAM9, LayoutLoader.getLayout2("groupe1/salles/layout_cam9.fxml")));

            Layout<StackPane> menuPause = new Layout<>(new BackgroundStackPane(new MenuPause(300), 300, 400, 1950, 1080), null);
            stepManager.addStep(new Step<>(StepID.PAUSE, menuPause));

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
