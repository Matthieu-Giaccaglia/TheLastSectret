package fr.umontpellier.iut.groupe2.inventaire;

import javafx.scene.image.Image;

import java.util.Objects;

public class Item {

    private Image image;
    private IdItem idItem;

    public Item(Image image, IdItem idItem) {
        this.image = image;
        this.idItem = idItem;
    }

    public Item(IdItem idItem) {
        this.idItem = idItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return idItem == item.idItem;
    }


    @Override
    public int hashCode() {
        return Objects.hash(idItem);
    }



    public Image getImageItem(){
        return image;
    }

    public IdItem getIdItem(){
        return idItem;
    }

}





