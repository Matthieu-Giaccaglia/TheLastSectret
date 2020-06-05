package fr.umontpellier.iut.groupe2.view;

public enum StepID {
    START(0),
    TAQUIN(1),
    LIGHTSOUT(2),
    INVENTAIRE(3);


    private final int id;

    StepID(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


}
