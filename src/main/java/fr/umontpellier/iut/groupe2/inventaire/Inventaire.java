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

    private final ArrayList<ItemId> inventaire = new ArrayList<>(5);
    private final InventaireController controller; //todo
    private int nombreItemInventaire = 0;

    public Inventaire(InventaireController controller) {//todo

        this.controller = controller;
        inventaire.add(null);
        inventaire.add(null);
        inventaire.add(null);
        inventaire.add(null);
        inventaire.add(null);
    }

    public void ajouterItem(ItemId itemId){

        if (nombreItemInventaire < 5 && !contientItem(itemId)) {
            for (int i = 0; i < 5; i++) {
                if (inventaire.get(i) == null) {
                    inventaire.remove(i);
                    inventaire.add(i, itemId);
                    updateInventaireGraphique(itemId,i);
                    break;
                }
            }
        } else if(nombreItemInventaire >= 5) {
            System.err.println("L'inventaire est rempli");
        } else if(contientItem(itemId)) {
            System.err.println("L'item est déjà dans l'inventaire");
        }
    }

    public void retirerItem(ItemId itemId){

        if (inventaire.contains(itemId)) {
            int i = inventaire.indexOf(itemId);
            inventaire.remove(itemId);
            inventaire.add(i, null);
            updateInventaireGraphique(null,i);
        } else {
            System.err.println("L'item n'est pas présent dans l'inventaire");
        }

    }

    public ItemId getItemIdSelection(){

        if (inventaire.get(controller.getItemSelectionne()) != null) {
            return inventaire.get(controller.getItemSelectionne());
        } else{
            System.err.println("Aucun item sélectionné");
            return null;
        }
    }

    private Boolean contientItem(ItemId itemAjout){
        for (ItemId item: inventaire) {
            if (itemAjout.equals(item))
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Inventaire{" +
                "inventaire=" + inventaire +
                '}';
    }

    public void updateInventaireGraphique(ItemId itemId, int i)  {
        if (itemId == null) {
            controller.setImageItem(null, i);
        } else {
            controller.setImageItem(itemId.getImage(), i);
        }
    }
}
