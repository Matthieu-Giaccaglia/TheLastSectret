package fr.umontpellier.iut.groupe2.gemmes;

public class Gemme {
    private int numGemme;
    private String couleur;
    private String nomGemme;


    public Gemme(String nomGemme, int numGemme, String couleur){
        this.numGemme = numGemme;
        this.nomGemme = nomGemme;
        this.couleur = couleur;
    }

    public Gemme(String nomGemme, int numGemme){
        this.numGemme = numGemme;
        this.nomGemme = nomGemme;
        this.couleur = "";
    }

    public int getNumGemme() {
        return numGemme;
    }

    public String getCouleur() {
        return couleur;
    }

    public String getNomGemme() {
        return nomGemme;
    }
}
