package fr.umontpellier.iut.groupe2.inventoraire;

import fr.umontpellier.iut.commun.data.ImageLoader;
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
    private GridPane inventoryGrid;
    @FXML
    private ImageView slotUn;
    @FXML
    private Button button;

    public void update(ActionEvent mouseEvent) {

        ImageView imageView = new ImageView(new Image(String.valueOf(ImageLoader.getImage("groupe2/taquin/piece25.png"))));
        inventoryGrid.add(imageView,0,0);
    }

    public void update2(){
    }
}
