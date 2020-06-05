package fr.umontpellier.iut.groupe2.inventaire;

import fr.umontpellier.iut.commun.data.ImageLoader;
import fr.umontpellier.iut.groupe2.MainSalleGroupe2;
import fr.umontpellier.iut.groupe2.view.StepManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class InventaireController {
    @FXML
    private GridPane inventoryGrid;


    public void update(ActionEvent mouseEvent) {

        ImageView imageView = new ImageView(new Image(String.valueOf(ImageLoader.getImage("groupe2/taquin/piece25.png"))));
        inventoryGrid.add(imageView,0,0);
    }

    public void update2(){

    }


    public void okay(ActionEvent event) {
        System.out.println("okay");
    }
}
