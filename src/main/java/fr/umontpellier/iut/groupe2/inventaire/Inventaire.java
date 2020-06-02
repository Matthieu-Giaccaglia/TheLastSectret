package fr.umontpellier.iut.groupe2.inventaire;


import javafx.scene.image.Image;
import java.util.ArrayList;

public class Inventaire {

    private final ArrayList<Item> inventaire = new ArrayList<>();

    public void ajouterItem(Image image, IdItem idItem){

        Item itemAjout = new Item(image, idItem);

        if (inventaire.size() < 5 && !contientItem(itemAjout)) {
            inventaire.add(itemAjout);
        } else if(inventaire.size() >= 5) {
            System.err.println("L'inventaire est rempli");
        } else if(contientItem(itemAjout)) {
            System.err.println("L'item est déjà dans l'inventaire");
        }
    }

    public void retirerItem(IdItem idItem){
        inventaire.removeIf(item -> item.getIdItem().equals(idItem));
    }

    private Boolean contientItem(Item itemAjout){
        for (Item item: inventaire) {
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
}
