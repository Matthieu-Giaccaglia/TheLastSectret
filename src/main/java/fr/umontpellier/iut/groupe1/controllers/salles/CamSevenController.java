package fr.umontpellier.iut.groupe1.controllers.salles;

import fr.umontpellier.iut.groupe1.Main;
import fr.umontpellier.iut.groupe1.view.StepID;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class CamSevenController implements Initializable {
    @FXML
    private ImageView background;
    @FXML
    private ImageView arrowBack;
    @FXML
    private ImageView indice2, indice22, black;

    @FXML
    void handleButton(MouseEvent mouseEvent){
        if (!(black.isVisible() && indice22.isVisible())){
            black.setVisible(true);
            indice22.setVisible(true);
            indice2.setVisible(false);
        }else if (!(indice2.isVisible())){
            black.setVisible(false);
            indice22.setVisible(false);
            indice2.setVisible(true);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        background.fitWidthProperty().bind(Main.stage.widthProperty());
        background.fitHeightProperty().bind(Main.stage.heightProperty());
        black.fitWidthProperty().bind(Main.stage.widthProperty());
        black.fitHeightProperty().bind(Main.stage.heightProperty());
    }

    public void handleMouseClicked(MouseEvent mouseEvent) {
        if(mouseEvent.getSource().equals(arrowBack))
            Main.stepManager.openStep(StepID.CAM6);
    }
}
