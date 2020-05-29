package fr.umontpellier.iut.groupe2.taquin;



import java.util.ArrayList;


public class Contexte {

    /*private Taquin jeuPuzzleInitial;
    private ArrayList<Taquin> solution;

    public Contexte(Taquin jeuPuzzleInitial) {
        this.jeuPuzzleInitial = jeuPuzzleInitial;
        solution = new ArrayList<>();
    }

    public void resoudre() {

        int i = 0;
        boolean impossible = false;
        ArrayList<Taquin> dejaVu = new ArrayList<>();
        ArrayList<Couple> frontiere = new ArrayList<>();
        ArrayList<Couple> newFrontiere = new ArrayList<>();
        Couple initial = new Couple(jeuPuzzleInitial,null);
        frontiere.add(initial);
        dejaVu.add(initial.getTaquin());
        initial.mettreAJour(frontiere,dejaVu);
        while (!impossible && !frontiere.get(i).getTaquin().estGagnant()) {
            i++;
            if (i >= frontiere.size()) {
                for(i = 0; i < frontiere.size(); i++) {
                    frontiere.get(i).mettreAJour(newFrontiere,dejaVu);
                    System.out.println(newFrontiere.size());
                }
                if(newFrontiere.size() == 0) {
                    impossible = true;
                }
                frontiere = newFrontiere;
                newFrontiere = new ArrayList<>();
                i = 0;
            }
        }
        if (impossible) {
            solution = new ArrayList<>();
        }
        else {
            solution = frontiere.get(i).getListeDeMouvements();
        }
    }

    public String toString() {
        String result = "";
        for(int i = 0;i<solution.size();i++) {
            result += solution.get(i).toString()+"\n";
        }
        return result;
    }*/

}

