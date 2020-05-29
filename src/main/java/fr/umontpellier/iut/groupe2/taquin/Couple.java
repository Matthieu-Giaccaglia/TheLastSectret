package fr.umontpellier.iut.groupe2.taquin;

import java.util.ArrayList;
import java.util.Collections;


public class Couple {

    /*private Taquin taquin;
    private Couple predecesseur;

    public Couple(Taquin taquin, Couple predecesseur) {
        this.taquin = taquin;
        this.predecesseur = predecesseur;
    }

    public void mettreAJour(ArrayList<Couple> frontiere, ArrayList<Taquin> dejaVus) {
        ArrayList<Taquin> filsJeuPuzzle = taquin.genererFils();
        for (int i=0;i < filsJeuPuzzle.size();i++) {
            if (!dejaVus.contains(filsJeuPuzzle.get(i))) {
                dejaVus.add(filsJeuPuzzle.get(i));
                frontiere.add(new Couple(filsJeuPuzzle.get(i),this));
            }
        }
    }

    public ArrayList<Taquin> getListeDeMouvements() {
        Couple courant = this;
        ArrayList<Taquin> listeDeMouvement = new ArrayList<>();
        while (courant != null){
            listeDeMouvement.add(courant.taquin);
            courant = courant.predecesseur;
        }
        Collections.reverse(listeDeMouvement);
        return listeDeMouvement;
    }

    public Taquin getTaquin() {
        return taquin;
    }*/

}
