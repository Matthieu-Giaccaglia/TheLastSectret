package fr.umontpellier.iut.groupe2.lightsout;

public class Main{
    public static void main(String[] args) {
        int[][] tableau = {{0,0,0},{0,0,0},{0,0,0}};
        LightsOut jeu_walter = new LightsOut(tableau);
        System.out.println(jeu_walter.toString());
        int[] postion0_0 = {0,0};
        jeu_walter.onClick(postion0_0);
        System.out.println(jeu_walter.toString());
    }

}
