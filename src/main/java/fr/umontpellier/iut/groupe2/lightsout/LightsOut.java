package fr.umontpellier.iut.groupe2.lightsout;

public class LightsOut {
    private int[][] tableau;
    public LightsOut(int[][] tableau) {
        this.tableau = tableau;
    }

    public int estGagnant() {
        for (int i=0; i<tableau.length; i++){
            for(int j=0; j<tableau[i].length; j++){
                if (tableau[i][j] == 0) {
                    System.out.println((i + 1) * (j + 1));
                    System.out.println(tableau[i][j]);
                    return 0;
                }
            }
        }
        return 1;
    }
}
