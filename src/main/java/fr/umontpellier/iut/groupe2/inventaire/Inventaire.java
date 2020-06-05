package fr.umontpellier.iut.groupe2.inventaire;


import fr.umontpellier.iut.groupe2.MainSalleGroupe2;
import fr.umontpellier.iut.groupe2.TestController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.ArrayList;

import static fr.umontpellier.iut.groupe1.data.ImageLoader.getImage;

public class Inventaire {

    private final ArrayList<ItemId> inventaire = new ArrayList<>();
    private final InventaireController controller; //todo

    public Inventaire(InventaireController controller) {//todo
        this.controller = controller;
    }

    public void ajouterItem(ItemId itemId){

        if (inventaire.size() < 5 && !contientItem(itemId)) {
            inventaire.add(itemId);
            System.out.println(itemId.getImage());
            updateInventaireGraphique();
        } else if(inventaire.size() >= 5) {
            System.err.println("L'inventaire est rempli");
        } else if(contientItem(itemId)) {
            System.err.println("L'item est déjà dans l'inventaire");
        }
    }

    public void retirerItem(ItemId itemId){

    }

    private Boolean contientItem(ItemId itemAjout){
        for (ItemId item: inventaire) {
            if (itemAjout.equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Inventaire{" +
                "inventaire=" + inventaire +
                '}';
    }

    public void updateInventaireGraphique()  {
        ImageView imageView = new ImageView(getImage("groupe2/taquin/piece25.png"));
        controller.getInventoryGrid().add(imageView, 0, 0); //todo

        //MainSalleGroupe2.inventaireController.updateInventaireGraphique();


    }
}
