package fr.umontpellier.iut.groupe2;

import fr.umontpellier.iut.commun.exceptions.LayoutNotFoundException;
import fr.umontpellier.iut.groupe1.data.LayoutLoader;
import fr.umontpellier.iut.groupe2.inventaire.Inventaire;
import fr.umontpellier.iut.groupe2.view.Step;
import fr.umontpellier.iut.groupe2.view.StepID;
import fr.umontpellier.iut.groupe2.view.StepManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainSalleGroupe2 extends Application {

    public static StepManager stepManager;

    @Override
    public void start(Stage primaryStage){

        primaryStage.setTitle("Escape Game S6");

        stepManager = new StepManager(primaryStage, new Inventaire());
        try {
            stepManager.addStep(new Step<>(StepID.START, LayoutLoader.getLayout2("groupe2/layout_game.fxml")));
            stepManager.addStep(new Step<>(StepID.TAQUIN, LayoutLoader.getLayout2("groupe2/taquin/taquin.fxml")));
            stepManager.addStep(new Step<>(StepID.LIGHTSOUT, LayoutLoader.getLayout2("groupe2/lightsout/lightsout.fxml")));
        } catch (LayoutNotFoundException e) {
            e.printStackTrace();
        }

        stepManager.openStep(StepID.START);

        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
