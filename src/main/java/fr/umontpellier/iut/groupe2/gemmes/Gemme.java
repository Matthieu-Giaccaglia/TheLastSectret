package fr.umontpellier.iut.groupe2.gemmes;

        import java.util.ArrayList;

public class Gemme {
    private int numGemme;
    private String nomGemme;

    public Gemme(String nomGemme, int numGemme){
        this.numGemme = numGemme;
        this.nomGemme = nomGemme;
    }

    public ArrayList<Gemme> ajoutGemme(Gemme g){
        ArrayList<Gemme> listGemme = new ArrayList<>();
        listGemme.add(g);
        return listGemme;
    }

}
