package fr.umontpellier.iut.groupe2.inventory;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class Controller {
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

    public void update(MouseEvent mouseEvent) {

        ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream("piece25.png")));
        TextField textField = new TextField("yo");
        //textField.setText("ok google");
        //inventoryGrid.add(imageView, 0, 0);
        slotUn.setImage(new Image(getClass().getResourceAsStream("piece25.png")));
    }

    public void update2(){

    }
}
