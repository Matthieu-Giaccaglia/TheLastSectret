package fr.umontpellier.iut.groupe2.view;

public enum StepID {
    START(0),
    TRAPEZE(1),
    TAQUIN(2);

    private final int id;

    StepID(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


}
