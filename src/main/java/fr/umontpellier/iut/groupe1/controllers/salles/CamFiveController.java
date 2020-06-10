package fr.umontpellier.iut.groupe1.controllers.salles;

import fr.umontpellier.iut.groupe1.Main;
import fr.umontpellier.iut.groupe1.view.StepID;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class CamFiveController implements Initializable {
    @FXML
    private ImageView background;
    @FXML
    private ImageView arrowBack;
    @FXML
    private ImageView goto1;
    @FXML
    private ImageView goto3;
    @FXML
    private ImageView goto4;
    @FXML
    private ImageView goto9;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        background.fitWidthProperty().bind(Main.stage.widthProperty());
        background.fitHeightProperty().bind(Main.stage.heightProperty());
    }

    public void handleMouseClicked(MouseEvent mouseEvent) {
        if(mouseEvent.getSource().equals(goto1))
            Main.stepManager.openStep(StepID.CAM1);
        else if(mouseEvent.getSource().equals(goto3))
            Main.stepManager.openStep(StepID.CAM3);
        else if(mouseEvent.getSource().equals(goto4))
            Main.stepManager.openStep(StepID.CAM4);
        else if(mouseEvent.getSource().equals(arrowBack))
            Main.stepManager.openStep(StepID.CAM6);
        else if(mouseEvent.getSource().equals(goto9))
            Main.stepManager.openStep(StepID.CAM9);
    }
}
