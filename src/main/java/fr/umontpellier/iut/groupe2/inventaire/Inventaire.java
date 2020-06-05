package fr.umontpellier.iut.groupe2.inventaire;


import javafx.scene.image.Image;
import java.util.ArrayList;

public class Inventaire {

    private final ArrayList<ItemId> inventaire = new ArrayList<>();

    public void ajouterItem(ItemId itemId){

        if (inventaire.size() < 5 && !contientItem(itemId)) {
            inventaire.add(itemId);
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
}
