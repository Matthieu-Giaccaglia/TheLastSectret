package fr.umontpellier.iut.groupe2.taquin;


import java.util.ArrayList;
import java.util.Arrays;


public class Taquin {
    private int[][] tableau;

    public Taquin(int[][] tableau) {
        this.tableau = tableau;
    }

    public boolean estGagnant() {
        for (int i=0, j=0, k=1; i<tableau.length; i++, j=0){
            for (; j<tableau[i].length; j++, k++){
                if ((tableau[i][j] != k && i!=tableau.length-1 && j!=tableau[i].length) || tableau[tableau.length-1][tableau.length-1] != 0){
                    System.out.println((i+1)*(j+1));
                    System.out.println(tableau[i][j]);
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Taquin taquin = (Taquin) o;
        for (int i = 0; i < this.tableau.length ; i++) {
            for (int j = 0; j < this.tableau.length ; j++) {
                if ( this.tableau[i][j]!=((Taquin) o).tableau[i][j] ){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(tableau);
    }


    public Taquin genererFils(int i) {
        int[] coordonneeTrou = trouverCoordonne(i);
        int ligne = coordonneeTrou[0], colonne = coordonneeTrou[1];
        Taquin fils = new Taquin(copierTableau());

        if (ligne > 0 && tableau[ligne-1][colonne]==0){                          //déplacer en haut
            int[][] copie = copierTableau();
            copie[ligne][colonne] = copie[ligne-1][colonne];
            copie[ligne-1][colonne]=i;
            fils = new Taquin(copie);
        } else if (ligne < this.tableau.length-1 && tableau[ligne+1][colonne]==0){      //déplacer en bas
            int[][] copie = copierTableau();
            copie[ligne][colonne] = copie[ligne+1][colonne];
            copie[ligne+1][colonne] = i;
            fils = new Taquin(copie);
        } else if (colonne > 0 && tableau[ligne][colonne-1]==0){                       //déplacer à gauche
            int[][] copie = copierTableau();
            copie[ligne][colonne] = copie[ligne][colonne-1];
            copie[ligne][colonne-1]=i;
            fils = new Taquin(copie);
        } else if (colonne < this.tableau.length-1 && tableau[ligne][colonne+1]==0){   //déplacer à droite
            int[][] copie = copierTableau();
            copie[ligne][colonne] = copie[ligne][colonne+1];
            copie[ligne][colonne+1]=i;
            fils = new Taquin(copie);
        }
        return fils;
    }

    public int[][] copierTableau(){
        int[][] copie = new int[tableau.length][];
        for (int i=0; i<tableau.length; i++){
            copie[i]= Arrays.copyOf(tableau[i],tableau[i].length);
        }
        return copie;
    }

    public int[] trouverCoordonne(int num) {
        int[] coordonneeTrou = new int[2];
        for (int i=0,j=0;i<tableau.length;i++,j=0){
            for(;j<tableau.length;j++){
                if (tableau[i][j] == num){
                    coordonneeTrou[0]=i;
                    coordonneeTrou[1]=j;
                }
            }
        }
        return coordonneeTrou;
    }

    public String toString(){
        String taquin="";
        for(int i=0; i<tableau.length; i++){
            taquin+= Arrays.toString(tableau[i])+"\n";
        }
        return taquin;
    }

    public void deplacer(int i) {
        System.out.println(genererFils(i).toString());
    }
}