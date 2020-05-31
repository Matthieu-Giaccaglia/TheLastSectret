package fr.umontpellier.iut.groupe2.inventory;

import java.util.ArrayList;

public class Inventaire {

    private ArrayList<Item> inventaire = new ArrayList<>();

    public void ajoutItem(String url){
        /*if (inventaire.size() < 5) {
           // controller.update2();
        }*/
    }



    @Override
    public String toString() {
        return "Inventaire{" +
                "inventaire=" + inventaire +
                '}';
    }
}
