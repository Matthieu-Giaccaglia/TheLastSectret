package fr.umontpellier.iut.groupe2.inventory;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class Inventaire {

    public Label label_room;
    public Label timer;
    public GridPane inventoryGrid;
    public ImageView soltUn;
    private ArrayList<Item> inventaire = new ArrayList<>();

    public void ajoutItem(String url){
        if (inventaire.size() < 5) {
            updateAjoutInventaire(url);
        }

    }

    public void enleverItem(){

    }

    public void updateAjoutInventaire(String url){
        ImageView imageView = new ImageView();
        //imageView.setImage(new Image(url));
        //soltUn.setImage(new Image("/piece25.png"));
    }

    @Override
    public String toString() {
        return "Inventaire{" +
                "inventaire=" + inventaire +
                '}';
    }
}
