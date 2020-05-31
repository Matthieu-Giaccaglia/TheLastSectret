package fr.umontpellier.iut.groupe2.lightsout;

public class Main{
    public static void main(String[] args) {
        int[][] tableau = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
        LightsOut jeu_walter = new LightsOut(tableau);
        System.out.println(jeu_walter.toString());
        int[] postion0_0 = {0,0};
        int[] postion0_1 = {0,1};
        int[] postion1_1 = {1,1};
        jeu_walter.onClick(postion0_0);
        System.out.println(jeu_walter.toString());
        jeu_walter.onClick(postion0_1);
        System.out.println(jeu_walter.toString());
        jeu_walter.onClick(postion1_1);
        System.out.println(jeu_walter.toString());

        int[][] tableau_gagnant = {{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}};
        LightsOut jeu_walter1 = new LightsOut(tableau_gagnant);
        System.out.println(jeu_walter1.estGagnant());
        System.out.println(jeu_walter.estGagnant());
    }

}
