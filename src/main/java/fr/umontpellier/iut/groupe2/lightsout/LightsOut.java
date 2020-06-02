package fr.umontpellier.iut.groupe2.lightsout;

import java.util.HashMap;

public class LightsOut {
    private int[][] tableau;
    private static HashMap<int[], Integer> Tab_ID;

    static {
        Tab_ID = new HashMap<>();

        Tab_ID.put(new int[]{0,0},0);
        Tab_ID.put(new int[]{0,1},1);
        Tab_ID.put(new int[]{0,2},2);
        Tab_ID.put(new int[]{0,3},3);

        Tab_ID.put(new int[]{1,0},4);
        Tab_ID.put(new int[]{1,1},5);
        Tab_ID.put(new int[]{1,2},6);
        Tab_ID.put(new int[]{1,3},7);

        Tab_ID.put(new int[]{2,0},8);
        Tab_ID.put(new int[]{2,1},9);
        Tab_ID.put(new int[]{2,2},10);
        Tab_ID.put(new int[]{2,3},11);

        Tab_ID.put(new int[]{3,0},12);
        Tab_ID.put(new int[]{3,1},13);
        Tab_ID.put(new int[]{3,2},14);
        Tab_ID.put(new int[]{3,3},15);
    }

    public static int getID(int[] pos) {
        return Tab_ID.get(pos);
    }

    public LightsOut(int[][] tableau) {
        this.tableau = tableau;
    }

    public void onClick(int[] position){
        int max_i = tableau.length - 1;
        int max_j = tableau[0].length - 1;

        if (position[0] == 0){//barre haut
            if(position[1] == 0){//gauche
                lightSwitch(position[0],position[1]);
                lightSwitch(position[0]+1,position[1]);
                lightSwitch(position[0],position[1]+1);
            }else if(position[1] == max_j){//droite
                lightSwitch(position[0],position[1]);
                lightSwitch(position[0]+1,position[1]);
                lightSwitch(position[0],position[1]-1);
            } else{//milieu
                lightSwitch(position[0],position[1]);
                lightSwitch(position[0],position[1]+1);
                lightSwitch(position[0]+1,position[1]);
                lightSwitch(position[0],position[1]-1);
            }
        }else if(position[0] == max_i){//barre bas
            if(position[1] == 0){//gauche
                lightSwitch(position[0],position[1]);
                lightSwitch(position[0]-1,position[1]);
                lightSwitch(position[0],position[1]+1);
            }else if(position[1] == max_j){//droite
                lightSwitch(position[0],position[1]);
                lightSwitch(position[0]-1,position[1]);
                lightSwitch(position[0],position[1]-1);
            } else{//milieu
                lightSwitch(position[0],position[1]);
                lightSwitch(position[0],position[1]+1);
                lightSwitch(position[0]-1,position[1]);
                lightSwitch(position[0],position[1]-1);
            }
        }else{//barres milieu
            if(position[1] == 0){//gauche
                lightSwitch(position[0],position[1]);
                lightSwitch(position[0]-1,position[1]);
                lightSwitch(position[0]+1,position[1]);
                lightSwitch(position[0],position[1]+1);
            }else if(position[1] == max_j){//droite
                lightSwitch(position[0],position[1]);
                lightSwitch(position[0]-1,position[1]);
                lightSwitch(position[0]+1,position[1]);
                lightSwitch(position[0],position[1]-1);
            } else{//milieu
                lightSwitch(position[0],position[1]);
                lightSwitch(position[0]-1,position[1]);
                lightSwitch(position[0]+1,position[1]);
                lightSwitch(position[0],position[1]-1);
                lightSwitch(position[0],position[1]+1);
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
        for (int i=0; i<tableau.length; i++){
            for(int j=0; j<tableau[i].length; j++){
                if (tableau[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public int[] trouverCoordonne(int id){
        int[] coordonnee = new int[2];
        int[] position = new int[2];
        for (int i=0; i<tableau.length; i++){
            for(int j=0 ; j<tableau.length; j++){
                position[0] = i;
                position[1] = j;
                if (getID(position) == id){
                    coordonnee[0]=i;
                    coordonnee[1]=j;
                }
            }
        }
        return coordonnee;
    }

    @Override
    public String toString() {
        String res = "";
        if(this.tableau.length != 0) {
            for (int i = 0; i < this.tableau.length; i++) {
                for (int j = 0; j < this.tableau[i].length; j++) {
                    res = res+this.tableau[i][j]+" ";
                }
                res += "\n";
            }
        }
        return (res);
    }
}
