package fr.umontpellier.iut.groupe1.controllers.salles;

import fr.umontpellier.iut.groupe1.Main;
import fr.umontpellier.iut.groupe1.view.StepID;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class CamOneController implements Initializable {
    @FXML
    private ImageView background;
    @FXML
    public ImageView arrowBack;
    @FXML
    public ImageView goto3;
    @FXML
    public ImageView goto4;
    @FXML
    public ImageView goto6;
    @FXML
    public ImageView goto9;
    @FXML
    public Label buttonLabyrinthe;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        background.fitWidthProperty().bind(Main.stage.widthProperty());
        background.fitHeightProperty().bind(Main.stage.heightProperty());
    }

    public void handleMouseClicked(MouseEvent mouseEvent) {
        if(mouseEvent.getSource().equals(arrowBack))
            Main.stepManager.openStep(StepID.CAM2);
        else if(mouseEvent.getSource().equals(goto3))
            Main.stepManager.openStep(StepID.CAM3);
        else if(mouseEvent.getSource().equals(goto4))
            Main.stepManager.openStep(StepID.CAM4);
        else if(mouseEvent.getSource().equals(goto6))
            Main.stepManager.openStep(StepID.CAM6);
        else if(mouseEvent.getSource().equals(goto9))
            Main.stepManager.openStep(StepID.CAM9);
        else if(mouseEvent.getSource().equals(buttonLabyrinthe))
            Main.stepManager.openStep(StepID.LABYRINTHE);
    }
}
