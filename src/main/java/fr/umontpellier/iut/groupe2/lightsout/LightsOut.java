package fr.umontpellier.iut.groupe2.lightsout;

public class LightsOut {
    private int[][] tableau;
    public LightsOut(int[][] tableau) {
        this.tableau = tableau;
    }

    public void onClick(int[] position){
        int max_i = tableau.length - 1;
        int max_j = tableau[0].length - 1;

        if (position[0] == 0){
            if(position[1] == 0){
                lightSwitch(position[0],position[1]);
                lightSwitch(position[0]+1,position[1]);
                lightSwitch(position[0],position[1]+1);
            }else if(position[1] == max_j){
                lightSwitch(position[0],position[1]);
                lightSwitch(position[0]-1,position[1]);
                lightSwitch(position[0],position[1]+1);
            } else{
                lightSwitch(position[0],position[1]);
                lightSwitch(position[0]-1,position[1]);
                lightSwitch(position[0]+1,position[1]);
                lightSwitch(position[0],position[1]+1);
            }
        }else if(position[0] == max_i){

        }

        if(estGagnant() == 1){
            System.out.println("c'est gagné");
        }
    }

    public void lightSwitch(int position_i, int position_j){
        if( this.tableau[position_i][position_j] == 1) {
            this.tableau[position_i][position_j] = 0;
        }else{
            this.tableau[position_i][position_j] = 1;
        }
    }

    public int estGagnant() {
        for (int i=0; i<tableau.length; i++){
            for(int j=0; j<tableau[i].length; j++){
                if (tableau[i][j] == 0) {
                    //System.out.println((i + 1) * (j + 1));
                    //System.out.println(tableau[i][j]);
                    return 0;
                }
            }
        }
        return 1;
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
