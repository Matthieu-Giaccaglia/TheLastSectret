package fr.umontpellier.iut.groupe1.enigmesymbole;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;


public class TrapezeController {

    @FXML
    private Button flecheDroite;

    @FXML
    private Button flecheGauche;

    @FXML
    private ImageView aigle;

    @FXML
    private ImageView serpent;

    @FXML
    private ImageView dauphin;

    @FXML
    private ImageView vide;

    @FXML
    void handleButtonAction(ActionEvent actionEvent) {
        if (actionEvent.getSource() == flecheDroite && aigle.isVisible()) {
            aigle.setVisible(false);
            serpent.setVisible(true);
        }else if (actionEvent.getSource() == flecheGauche && aigle.isVisible()){
            aigle.setVisible(false);
            dauphin.setVisible(true);
        }

        else if (actionEvent.getSource() == flecheDroite && serpent.isVisible()){
            serpent.setVisible(false);
            vide.setVisible(true);
        }else if (actionEvent.getSource() == flecheGauche && serpent.isVisible()){
            serpent.setVisible(false);
            aigle.setVisible(true);
        }

        else if (actionEvent.getSource() == flecheDroite && vide.isVisible()){
            vide.setVisible(false);
            dauphin.setVisible(true);
        }else if (actionEvent.getSource() == flecheGauche && vide.isVisible()){
            vide.setVisible(false);
            serpent.setVisible(true);
        }

        else if (actionEvent.getSource() == flecheDroite && dauphin.isVisible()){
            dauphin.setVisible(false);
            aigle.setVisible(true);
        }else if (actionEvent.getSource() == flecheGauche && dauphin.isVisible()){
            dauphin.setVisible(false);
            vide.setVisible(true);
        }

    }

}
