package fr.umontpellier.iut.groupe2.inventory;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class Controller {
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

    public void update(MouseEvent mouseEvent) {

        ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream("piece25.png"),50,50,false,false));
        inventoryGrid.add(imageView, 0, 0);
    }

    public void update2(){
        ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream("piece25.png"),50,50,false,false));
        inventoryGrid.add(imageView, 0, 0);
    }
}
