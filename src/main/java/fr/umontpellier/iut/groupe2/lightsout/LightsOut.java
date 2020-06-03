package fr.umontpellier.iut.groupe2.lightsout;

import java.util.Arrays;
import java.util.HashMap;

public class LightsOut {
    private int[][] tableau;
    private static HashMap<String, Integer> Tab_ID;

    static {
        Tab_ID = new HashMap<>();

        Tab_ID.put(Arrays.toString(new int[]{0, 0}),0);
        Tab_ID.put(Arrays.toString(new int[]{0,1}),1);
        Tab_ID.put(Arrays.toString(new int[]{0,2}),2);
        Tab_ID.put(Arrays.toString(new int[]{0,3}),3);

        Tab_ID.put(Arrays.toString(new int[]{1,0}),4);
        Tab_ID.put(Arrays.toString(new int[]{1,1}),5);
        Tab_ID.put(Arrays.toString(new int[]{1,2}),6);
        Tab_ID.put(Arrays.toString(new int[]{1,3}),7);

        Tab_ID.put(Arrays.toString(new int[]{2,0}),8);
        Tab_ID.put(Arrays.toString(new int[]{2,1}),9);
        Tab_ID.put(Arrays.toString(new int[]{2,2}),10);
        Tab_ID.put(Arrays.toString(new int[]{2,3}),11);

        Tab_ID.put(Arrays.toString(new int[]{3,0}),12);
        Tab_ID.put(Arrays.toString(new int[]{3,1}),13);
        Tab_ID.put(Arrays.toString(new int[]{3,2}),14);
        Tab_ID.put(Arrays.toString(new int[]{3,3}),15);
    }

    public static int getID(int i, int j) {
        return Tab_ID.get(Arrays.toString(new int[]{i, j}));
    }

    public LightsOut(int[][] tableau) {
        this.tableau = tableau;
    }

    public void onClick(int pos_i, int pos_j){
        int max_i = tableau.length - 1;
        int max_j = tableau[0].length - 1;
        if (pos_i == 0){//barre haut
            if(pos_j == 0){//gauche
                lightSwitch(pos_i,pos_j);
                lightSwitch(pos_i+1,pos_j);
                lightSwitch(pos_i,pos_j+1);
            }else if(pos_j == max_j){//droite
                lightSwitch(pos_i,pos_j);
                lightSwitch(pos_i+1,pos_j);
                lightSwitch(pos_i,pos_j-1);
            } else{//milieu
                lightSwitch(pos_i,pos_j);
                lightSwitch(pos_i,pos_j+1);
                lightSwitch(pos_i+1,pos_j);
                lightSwitch(pos_i,pos_j-1);
            }
        }else if(pos_i == max_i){//barre bas
            if(pos_j == 0){//gauche
                lightSwitch(pos_i,pos_j);
                lightSwitch(pos_i-1,pos_j);
                lightSwitch(pos_i,pos_j+1);
            }else if(pos_j == max_j){//droite
                lightSwitch(pos_i,pos_j);
                lightSwitch(pos_i-1,pos_j);
                lightSwitch(pos_i,pos_j-1);
            } else{//milieu
                lightSwitch(pos_i,pos_j);
                lightSwitch(pos_i,pos_j+1);
                lightSwitch(pos_i-1,pos_j);
                lightSwitch(pos_i,pos_j-1);
            }
        }else{//barres milieu
            if(pos_j == 0){//gauche
                lightSwitch(pos_i,pos_j);
                lightSwitch(pos_i-1,pos_j);
                lightSwitch(pos_i+1,pos_j);
                lightSwitch(pos_i,pos_j+1);
            }else if(pos_j == max_j){//droite
                lightSwitch(pos_i,pos_j);
                lightSwitch(pos_i-1,pos_j);
                lightSwitch(pos_i+1,pos_j);
                lightSwitch(pos_i,pos_j-1);
            } else{//milieu
                lightSwitch(pos_i,pos_j);
                lightSwitch(pos_i-1,pos_j);
                lightSwitch(pos_i+1,pos_j);
                lightSwitch(pos_i,pos_j-1);
                lightSwitch(pos_i,pos_j+1);
            }
        }

        if(estGagnant()){
            System.out.println("c'est gagné");//à modifier en close the window(faut aussi l'ouvrir du coup)
        }
    }

    public void lightSwitch(int position_i, int position_j){
        if( this.tableau[position_i][position_j] == 1) {
            this.tableau[position_i][position_j] = 0;
        }else{
            this.tableau[position_i][position_j] = 1;
        }
    }

    public boolean estGagnant() {
        for (int[] ints : tableau) {
            for (int anInt : ints) {
                if (anInt == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public int[] trouverCoordonne(int id){
        int[] coordonnee = new int[2];
        for (int i=0; i<tableau.length; i++){
            for(int j=0 ; j<tableau.length; j++){
                if (getID(i,j) == id){
                    coordonnee[0]=i;
                    coordonnee[1]=j;
                }
            }
        }
        return coordonnee;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        if(this.tableau.length != 0) {
            for (int[] ints : this.tableau) {
                for (int anInt : ints) {
                    res.append(anInt).append(" ");
                }
                res.append("\n");
            }
        }
        return (res.toString());
    }
}
