package fr.umontpellier.iut.groupe2.inventaire;

import fr.umontpellier.iut.groupe1.data.ImageLoader;
import fr.umontpellier.iut.groupe1.data.ControllerManagerInventaire;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class InventaireController implements ControllerManagerInventaire {
    @FXML
    private ImageView slotUn, slotDeux, slotTrois, slotQuatre, slotCinq;
    @FXML
    private ImageView slotItemUn,slotItemDeux,slotItemTrois,slotItemQuatre,slotItemCinq;

    private final Image slotSelectionne = ImageLoader.getImage("groupe1/inventory_slot_selectionne.png");
    private final Image slotNonSelectionne = ImageLoader.getImage("groupe1/inventory_slot.jpg");
    private int itemSelectionne = 0;


    public void itemSelection(MouseEvent mouseEvent) {

            if(mouseEvent.getSource() == slotItemUn)
                changeSlotSelection(0);
            else if(mouseEvent.getSource() == slotItemDeux)
                changeSlotSelection(1);
            else if(mouseEvent.getSource() == slotItemTrois)
                changeSlotSelection(2);
            else if(mouseEvent.getSource() == slotItemQuatre)
                changeSlotSelection(3);
            else if(mouseEvent.getSource() == slotItemCinq)
                changeSlotSelection(4);
    }

    public void changeSlotSelection(int i){
        setImage(slotNonSelectionne, itemSelectionne, slotUn, slotDeux, slotTrois, slotQuatre, slotCinq);
        itemSelectionne = i;
        setImage(slotSelectionne, itemSelectionne, slotUn, slotDeux, slotTrois, slotQuatre, slotCinq);
    }


    public void setImageItem(Image image, int i){
        setImage(image, i, slotItemUn, slotItemDeux, slotItemTrois, slotItemQuatre, slotItemCinq);
    }

    private void setImage(Image image, int i, ImageView un, ImageView deux, ImageView trois, ImageView quatre, ImageView cinq) {
        if (i == 0){
            un.setImage(image);
        } else if (i == 1){
            deux.setImage(image);
        } else if (i == 2){
            trois.setImage(image);
        } else if (i == 3){
            quatre.setImage(image);
        } else if (i == 4){
            cinq.setImage(image);
        }
    }

    public int getItemSelectionne() {
        return itemSelectionne;
    }

    @Override
    public InventaireController getInventaire() {
        return this;
    }
}
