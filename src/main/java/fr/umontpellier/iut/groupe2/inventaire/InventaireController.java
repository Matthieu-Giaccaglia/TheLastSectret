package fr.umontpellier.iut.groupe2.inventaire;

import fr.umontpellier.iut.commun.data.ImageLoader;
import fr.umontpellier.iut.groupe2.MainSalleGroupe2;
import fr.umontpellier.iut.groupe2.view.StepManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class InventaireController {
    public ImageView slotUn;
    public ImageView slotDeux;
    public ImageView slotTrois;
    public ImageView slotQuatre;
    public ImageView slotCinq;
    @FXML
    private GridPane inventoryGrid;

    public void updateInventaireGraphique(Node node){
        inventoryGrid.add(node,0,0);
    }
}
