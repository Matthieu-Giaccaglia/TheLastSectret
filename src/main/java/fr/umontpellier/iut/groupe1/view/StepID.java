package fr.umontpellier.iut.groupe1.view;

public enum StepID {
    START(0),
    TRAPEZE(1),
    CAM1(2);


    private final int id;

    StepID(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


}
