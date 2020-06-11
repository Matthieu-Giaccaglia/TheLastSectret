package fr.umontpellier.iut.groupe1.view;

public enum StepID {
    ACCUEIL(0),
    TRAPEZE(1),
    CAM1(2),
    CAM2(3),
    CAM3(4),
    CAM4(5),
    CAM5(6),
    CAM6(7),
    CAM7(8),
    CAM8(9),
    CAM9(10),
    PAUSE(11),
    LABYRINTHE(12),
    INVENTAIRE(13),
    GAMEOVER(14),
    START(15),
    TAQUIN(16),
    LIGHTSOUT(17);


    private final int id;

    StepID(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


}
