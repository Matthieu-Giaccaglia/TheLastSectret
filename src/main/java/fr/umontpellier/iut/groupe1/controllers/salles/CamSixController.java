package fr.umontpellier.iut.groupe1.controllers.salles;

import fr.umontpellier.iut.groupe1.Main;
import fr.umontpellier.iut.groupe1.view.StepID;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class CamSixController implements Initializable {
    @FXML
    private ImageView background;
    @FXML
    public ImageView arrowBack;
    @FXML
    public ImageView goto7;
    @FXML
    public ImageView goto8;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        background.fitWidthProperty().bind(Main.stage.widthProperty());
        background.fitHeightProperty().bind(Main.stage.heightProperty());
    }

    public void handleMouseClicked(MouseEvent mouseEvent) {
        if(mouseEvent.getSource().equals(arrowBack))
            Main.stepManager.openStep(StepID.CAM5);
        else if(mouseEvent.getSource().equals(goto7))
            Main.stepManager.openStep(StepID.CAM7);
        else if(mouseEvent.getSource().equals(goto8))
            Main.stepManager.openStep(StepID.CAM8);
    }
}
