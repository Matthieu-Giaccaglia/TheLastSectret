package fr.umontpellier.iut.groupe1;

import fr.umontpellier.iut.commun.exceptions.LayoutNotFoundException;
import fr.umontpellier.iut.groupe1.data.Layout;
import fr.umontpellier.iut.groupe1.data.LayoutLoader;
import fr.umontpellier.iut.groupe1.labyrinthe.BackgroundStackPane;
import fr.umontpellier.iut.groupe1.labyrinthe.StructureLabyrinthe;
import fr.umontpellier.iut.groupe1.menu.MenuAccueil;
import fr.umontpellier.iut.groupe1.view.Step;
import fr.umontpellier.iut.groupe1.view.StepID;
import fr.umontpellier.iut.groupe1.view.StepManager;
import fr.umontpellier.iut.groupe2.inventaire.Inventaire;
import fr.umontpellier.iut.groupe2.inventaire.InventaireController;
import fr.umontpellier.iut.groupe2.inventaire.ItemId;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.nio.file.Paths;

public class Main extends Application {

    public static StepManager stepManager;
    public static Stage stage;


    @Override
    public void start(Stage primaryStage) {

        stage = primaryStage;
        primaryStage.setMaximized(true);

        primaryStage.setTitle("Escape Game S6");

        stepManager = new StepManager(primaryStage);
        try {
            /*Group group = new Group();
            group.getChildren().add(new ImageView(ImageLoader.getImage("groupe1/dauphin.png")));
            Step<Group> start = new Step<>(StepID.START, new Layout<>(group));*/

            stepManager.addStep(new Step<>(StepID.ACCUEIL, new Layout<>(new BackgroundStackPane(new MenuAccueil(350)), null)));

            stepManager.addStep(new Step<>(StepID.CAM1, LayoutLoader.getLayout2("groupe1/salles/layout_cam1.fxml")));
            stepManager.addStep(new Step<>(StepID.CAM2, LayoutLoader.getLayout2("groupe1/salles/layout_cam2.fxml")));
            stepManager.addStep(new Step<>(StepID.CAM3, LayoutLoader.getLayoutWithController("groupe1/salles/layout_cam3.fxml")));
            stepManager.addStep(new Step<>(StepID.CAM4, LayoutLoader.getLayout2("groupe1/layout_trapeze.fxml")));
            stepManager.addStep(new Step<>(StepID.CAM5, LayoutLoader.getLayout2("groupe1/salles/layout_cam5.fxml")));
            stepManager.addStep(new Step<>(StepID.CAM6, LayoutLoader.getLayout2("groupe1/salles/layout_cam6.fxml")));
            stepManager.addStep(new Step<>(StepID.CAM7, LayoutLoader.getLayout2("groupe1/salles/layout_cam7.fxml")));
            stepManager.addStep(new Step<>(StepID.CAM8, LayoutLoader.getLayout2("groupe1/salles/layout_cam8.fxml")));
            stepManager.addStep(new Step<>(StepID.CAM9, LayoutLoader.getLayout2("groupe1/salles/layout_cam9.fxml")));

            stepManager.addStep(new Step<>(StepID.LABYRINTHE, new Layout<>(new StructureLabyrinthe(500, 450, primaryStage), null)));
            stepManager.addStep(new Step<>(StepID.GAMEOVER, LayoutLoader.getLayout2("groupe1/gameOver.fxml")));

            /*Step<Parent> inventaire = new Step<>(StepID.INVENTAIRE, LayoutLoader.getLayout2("groupe2/inventaire.fxml"));
            InventaireController inventaireController = inventaire.getLayout().getControllerInventaire().getInventaire();
            stepManager.setInventaire(new Inventaire(inventaireController));
            stepManager.addStep(inventaire);*/

        } catch (LayoutNotFoundException e) {
            e.printStackTrace();
        }

        stepManager.openStep(StepID.ACCUEIL);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
