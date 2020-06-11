package fr.umontpellier.iut.groupe1.controllers.salles;

import fr.umontpellier.iut.groupe1.Main;
import fr.umontpellier.iut.groupe1.data.Openable;
import fr.umontpellier.iut.groupe1.view.StepID;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class CamThreeController implements Initializable, Openable {
    @FXML
    public ImageView arrowBack;
    @FXML
    private ImageView backgroundSansCarre;
    @FXML
    private ImageView backgroundAvecCarre;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        backgroundSansCarre.fitWidthProperty().bind(Main.stage.widthProperty());
        backgroundSansCarre.fitHeightProperty().bind(Main.stage.heightProperty());
    }

    @Override
    public void open() {
        if(Main.stepManager.getEnigmeReussi(StepID.CAM4)) {
            setBackgrounds();
        }
    }

    public void handleMouseClicked(MouseEvent mouseEvent) {
        if(mouseEvent.getSource().equals(arrowBack)){
            Main.stepManager.openStep(StepID.CAM1);
        }
    }

    public void setBackgrounds() {
        backgroundSansCarre.setVisible(false);
        backgroundAvecCarre.setVisible(true);
    }
}
