package fr.umontpellier.iut.groupe2.inventaire;

import fr.umontpellier.iut.commun.data.ImageLoader;
import fr.umontpellier.iut.groupe1.data.ControllerManager;
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

import static fr.umontpellier.iut.groupe1.data.ImageLoader.getImage;

public class InventaireController implements ControllerManager {
    @FXML
    private ImageView slotUn, slotDeux, slotTrois, slotQuatre, slotCinq;
    @FXML
    private ImageView slotItemUn,slotItemDeux,slotItemTrois,slotItemQuatre,slotItemCinq;
    @FXML
    private GridPane inventoryGrid;

    public void updateInventaireGraphique(){
        ImageView imageView = new ImageView(getImage("groupe2/taquin/piece25.png"));
        inventoryGrid.add(imageView,0,0);
    }

    public void changeImage(MouseEvent mouseEvent) {
        //ImageView imageView = new ImageView(getImage("groupe2/taquin/piece25.png"));
        //inventoryGrid.add(imageView,0,0);
        slotItemUn.setImage(getImage("groupe2/taquin/piece25.png"));
        if(slotItemUn.getImage() != null){
            slotUn.setImage(getImage("groupe1/inventory_slot_selectionne.png"));
        }
    }

    public GridPane getInventoryGrid() { //todo
        return inventoryGrid;
    }

    @Override
    public InventaireController getInventaire() {
        return this;
    }
}
