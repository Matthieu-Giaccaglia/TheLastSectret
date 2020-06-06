package fr.umontpellier.iut.groupe2.inventaire;

import fr.umontpellier.iut.commun.data.ImageLoader;
import fr.umontpellier.iut.groupe1.data.ControllerManager;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import static fr.umontpellier.iut.groupe1.data.ImageLoader.getImage;

public class InventaireController implements ControllerManager {
    @FXML
    private ImageView slotUn, slotDeux, slotTrois, slotQuatre, slotCinq;
    @FXML
    private ImageView slotItemUn,slotItemDeux,slotItemTrois,slotItemQuatre,slotItemCinq;

    private final Image slotSelectionne = ImageLoader.getImage("groupe1/inventory_slot_selectionne.png");
    private final Image slotNonSelectionne = ImageLoader.getImage("groupe1/inventory_slot.jpg");
    private int itemSelectionne = 0;


    public void itemSelection(MouseEvent mouseEvent) {

        if(itemSelectionne > -1)
            setImageSlot(slotNonSelectionne);

            if(mouseEvent.getSource() == slotItemUn){
                setItemSelectionne(0);
            } else if(mouseEvent.getSource() == slotItemDeux){
                setItemSelectionne(1);
            } else if(mouseEvent.getSource() == slotItemTrois){
                setItemSelectionne(2);
            } else if(mouseEvent.getSource() == slotItemQuatre){
                setItemSelectionne(3);
            } else if(mouseEvent.getSource() == slotItemCinq){
                setItemSelectionne(4);
            }

    }

    public void setImageSlot(Image image){
        setImage(image, itemSelectionne, slotUn, slotDeux, slotTrois, slotQuatre, slotCinq);
    }

    public void setImageItem(Image image, int i){

        setImage(image, i, slotItemUn, slotItemDeux, slotItemTrois, slotItemQuatre, slotItemCinq);
    }

    private void setImage(Image image, int i, ImageView slotItemUn, ImageView slotItemDeux, ImageView slotItemTrois, ImageView slotItemQuatre, ImageView slotItemCinq) {
        if (i == 0){
            slotItemUn.setImage(image);
        } else if (i == 1){
            slotItemDeux.setImage(image);
        } else if (i == 2){
            slotItemTrois.setImage(image);
        } else if (i == 3){
            slotItemQuatre.setImage(image);
        } else if (i == 4){
            slotItemCinq.setImage(image);
        }
    }

    public void setItemSelectionne(int i){
        itemSelectionne = i;
        setImageSlot(slotSelectionne);
    }

    public int getItemSelectionne() {
        return itemSelectionne;
    }

    @Override
    public InventaireController getInventaire() {
        return this;
    }
}
