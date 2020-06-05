package fr.umontpellier.iut.groupe2.inventaire;

import javafx.scene.image.Image;

import java.util.Objects;

public class Item {

    private Image image;
    private ItemId itemId;

    public Item(Image image, ItemId itemId) {
        this.image = image;
        this.itemId = itemId;
    }

    public Item(ItemId itemId) {
        this.itemId = itemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return itemId == item.itemId;
    }


    @Override
    public int hashCode() {
        return Objects.hash(itemId);
    }



    public Image getImageItem(){
        return image;
    }

    public ItemId getItemId(){
        return itemId;
    }

}





