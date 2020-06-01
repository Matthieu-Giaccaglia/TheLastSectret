package fr.umontpellier.iut.groupe2.inventoraire;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class InventaireController {
    @FXML
    private Label label_room;
    @FXML
    private Label timer;
    @FXML
    public GridPane inventoryGrid;
    @FXML
    private ImageView slotUn;
    @FXML
    private Button button;

    public void update(ActionEvent mouseEvent) {

        ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream("piece25.png")));
        //slotUn.setImage(new Image(getClass().getResourceAsStream("piece25.png")));
        inventoryGrid.add(imageView,0,0);
    }

    public void update2(){
        ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream("piece25.png")));
        //slotUn.setImage(new Image(getClass().getResourceAsStream("piece25.png")));
        inventoryGrid.add(imageView,0,0);
    }
}
