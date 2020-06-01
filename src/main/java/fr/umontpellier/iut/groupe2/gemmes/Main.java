package fr.umontpellier.iut.groupe2.gemmes;


import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Gemme Ruby = new Gemme("Ruby", 1);
        Gemme Amethyste = new Gemme("Amethyste", 2);
        Gemme Emeraude = new Gemme("Emeraude", 3);
        Gemme Saphir = new Gemme("Saphir", 4);

        ArrayList<Gemme> liste = new ArrayList<>();
        liste.add(Ruby);
        liste.add(Emeraude);

        Enigme gm = new Enigme();
        gm.codeBon(liste);

    }

}
