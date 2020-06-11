package fr.umontpellier.iut.groupe2.inventaire;


import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.nio.file.Paths;
import java.util.ArrayList;

public class Inventaire {

    private Media sonAjout = new Media(Paths.get("src/main/resources/sound/groupe2/Inventaire/pickItem.mp3").toUri().toString());
    private final ArrayList<ItemId> inventaire = new ArrayList<>(5);
    private final InventaireController controller;
    private int nombreItemInventaire = 0;

    public Inventaire(InventaireController controller) {

        this.controller = controller;
        for (int i = 0; i < 5; i++){
            inventaire.add(null);
        }
    }

    private Boolean contientItem(ItemId itemAjout){
        for (ItemId item: inventaire) {
            if (itemAjout.equals(item))
                return true;
        }
        return false;
    }

    public void updateInventaireGraphique(ItemId itemId, int i)  {
        if (itemId == null) {
            controller.setImageItem(null, i);
        } else {
            controller.setImageItem(itemId.getImage(), i);
        }
    }

    @Override
    public String toString() {
        return "Inventaire{" +
                "inventaire=" + inventaire +
                '}';
    }




    /**
     * @author Matthieu Giaccaglia
     *
     * Ajouter un item dans l'inventaire.
     *
     * Exemple d'utilisation :
     *  {@code MainSalle2.stepManager.getInventaire().ajouterItem(ItemId.taquinPiece25);}
     *
     * Il faudra forcément passer par votre Main et ensuite faire le chemin décrit ci-dessus.
     *
     * @param itemId est l'id de l'item a ajouté dans l'inventaire. L'id + chemin d'accès de l'image de l'item sont à définir dans la classe ItemId au préalable.
     */
    public void ajouterItem(ItemId itemId){

        if (nombreItemInventaire < 5 && !contientItem(itemId)) {
            for (int i = 0; i < 5; i++) {
                if (inventaire.get(i) == null) {
                    new MediaPlayer(sonAjout).play();
                    inventaire.set(i,itemId);
                    nombreItemInventaire++;
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

    /**
     * @author Matthieu Giaccaglia
     *
     * Ajouter un item dans l'inventaire
     *
     * Exemple d'utilisation :
     *  {@code MainSalle2.stepManager.getInventaire().ajouterItem(ItemId.taquinPiece25);}
     *
     * Il faudra forcément passer par votre Main et ensuite faire le chemin décrit ci-dessus.
     *
     * @param itemId est l'id de l'item a ajouté. L'id + chemin d'accès de l'image de l'item sont à définir dans la classe ItemId au préalable.
     */
    public void retirerItem(ItemId itemId){

        if (inventaire.contains(itemId)) {
            int i = inventaire.indexOf(itemId);
            inventaire.set(i,null);
            nombreItemInventaire--;
            updateInventaireGraphique(null,i);
        } else {
            System.err.println("L'item n'est pas présent dans l'inventaire");
        }

    }

    /**
     * @author Matthieu Giaccaglia
     *
     * Savoir quel item est sélectionné par le joueur.
     *
     * Exemple d'utilisation :
     *  {@code MainSalle2.stepManager.getInventaire().getItemIdSelection();}
     *
     * Il faudra forcément passer par votre Main et ensuite faire le chemin décrit ci-dessus.
     *
     * @return l'ItemId de l'item sélectionné par le joueur.
     */
    public ItemId getItemIdSelection(){

        return inventaire.get(controller.getItemSelectionne());
    }

    public boolean inventairePasPlein(){
        System.out.println(nombreItemInventaire < 5);
        return nombreItemInventaire < 5;
    }

}
