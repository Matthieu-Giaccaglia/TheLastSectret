package fr.umontpellier.iut.groupe2.gemmes;

import java.util.ArrayList;

public class Enigme {

    public boolean codeBon(ArrayList<Gemme> listGemme) {
        ArrayList<Gemme> listeGemmeSolution = new ArrayList<>();
        listeGemmeSolution.add(new Gemme("Ruby", 1));
        listeGemmeSolution.add(new Gemme("Emeraude", 3));
        for (int i = 0 ; i < listeGemmeSolution.size() ; i++) {
            if (listGemme.get(i).getNomGemme() != listeGemmeSolution.get(i).getNomGemme()){
                System.out.println("pasok");
                return false;
            }
        }
        System.out.println("ok");
        return true;
    }

}
