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


    public boolean peutDeplacer(int i) {
        int[] coordonnee = trouverCoordonne(i);
        int ligne = coordonnee[0], colonne = coordonnee[1];

        if (ligne > 0 && tableau[ligne-1][colonne]==0){                          //déplacer en haut
            tableau[ligne][colonne] = 0;
            tableau[ligne-1][colonne] = i;
            return true;
        } else if (ligne < this.tableau.length-1 && tableau[ligne+1][colonne]==0){      //déplacer en bas
            tableau[ligne][colonne] = 0;
            tableau[ligne+1][colonne] = i;
            return true;
        } else if (colonne > 0 && tableau[ligne][colonne-1]==0){                       //déplacer à gauche
            tableau[ligne][colonne] = 0;
            tableau[ligne][colonne-1] = i;
            return true;
        } else if (colonne < this.tableau.length-1 && tableau[ligne][colonne+1]==0){   //déplacer à droite
            tableau[ligne][colonne] = 0;
            tableau[ligne][colonne+1] = i;
            return true;
        }
        return false;
    }

    public int[][] copierTableau(){
        int[][] copie = new int[tableau.length][];
        for (int i=0; i<tableau.length; i++){
            copie[i]= Arrays.copyOf(tableau[i],tableau[i].length);
        }
        return copie;
    }

    public int[] trouverCoordonne(int num) {
        int[] coordonnee = new int[2];
        for (int i=0, j=0; i<tableau.length; i++,j=0){
            for(; j<tableau.length; j++){
                if (tableau[i][j] == num){
                    coordonnee[0]=i;
                    coordonnee[1]=j;
                }
            }
        }
        return coordonnee;
    }

    public String toString(){
        StringBuilder taquin= new StringBuilder();
        for (int[] ints : tableau) {
            taquin.append(Arrays.toString(ints)).append("\n");
        }
        return taquin.toString();
    }

}