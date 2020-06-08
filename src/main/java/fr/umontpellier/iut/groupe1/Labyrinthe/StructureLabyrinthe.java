package fr.umontpellier.iut.groupe1.Labyrinthe;

import javafx.animation.AnimationTimer;
import javafx.collections.ObservableList;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.transform.*;
import javafx.stage.Stage;


import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StructureLabyrinthe extends Group {

    private final Stage stage;
    private final List<Mur> listeMur = new ArrayList<>();
    private double vitesseDeplacementRotation = 3;
    private int nombreMort = 0;
    private final Label compteurMort = new Label("Compteur de morts : " + nombreMort);
    private final AnimationTimer timer;
    private final MediaPlayer boulleRoulante = new MediaPlayer(new Media(Paths.get("src/main/resources/sound/groupe1/shakira-waka-waka.mp3").toUri().toString()));

    public StructureLabyrinthe(double width, double height, Stage stage) {
        this.stage = stage;

        compteurMort.setTranslateX(width - (width/4));
        compteurMort.setTranslateY(height/4 -100);
        compteurMort.setTranslateZ(-50);
        compteurMort.setStyle("-fx-text-fill: black; -fx-background-color: transparent;-fx-font-size: 16;");

        Checkpoint murCheckpoint1 = new Checkpoint(width/2 - 125, height/2 -150);
        Checkpoint murCheckpoint2 = new Checkpoint(width + 25, height + 25);
        Checkpoint murCheckpoint3 = new Checkpoint(width - 175, height + 75);
        Checkpoint murCheckpoint4 = new Checkpoint(width + 275, height - 175);

        final Checkpoint[] checkpoint = {murCheckpoint1};

        Boule boule = new Boule(13, checkpoint[0].getTranslateX(), checkpoint[0].getTranslateY());

        Clef clef = new Clef(width * 2 - 125, height * 2 - 75);

        deplacementBoule(boule);

        System.out.println(stage.getX());

        Socle socle = new Socle(800, 10, width, height);
        int tailleMur = 5;

        Mur murHaut = new Mur(socle.getWidth(), tailleMur, width, socle.getBoundsInParent().getMinY() );
        listeMur.add(murHaut);

        Mur murDroite = new Mur(tailleMur, socle.getHeight(), socle.getBoundsInParent().getMaxX(), height);
        listeMur.add(murDroite);

        Mur murBas = new Mur(socle.getWidth(), tailleMur, width, socle.getBoundsInParent().getMaxY());
        listeMur.add(murBas);

        Mur murGauche = new Mur(tailleMur, socle.getHeight(), socle.getBoundsInParent().getMinX(), height);
        listeMur.add(murGauche);

        Mur mur1 = new Mur(50, tailleMur, socle.getBoundsInParent().getMinX() + 75, socle.getBoundsInParent().getMinY() + 50);
        listeMur.add(mur1);

        Mur mur2 = new Mur(tailleMur, 300, socle.getBoundsInParent().getMinX() + 50, socle.getBoundsInParent().getMinY() + 150 + 50);
        listeMur.add(mur2);

        Mur mur3 = new Mur(tailleMur, 100, socle.getBoundsInParent().getMinX() + 100, socle.getBoundsInParent().getMinY() + 150);
        listeMur.add(mur3);

        Mur mur4 = new Mur(100, tailleMur, mur1.getTranslateX() -25, 350);
        listeMur.add(mur4);

        Mur mur5 = new Mur(100, tailleMur, mur1.getTranslateX() + 25, 300);
        listeMur.add(mur5);

        Mur mur6 = new Mur(tailleMur, 150, mur1.getTranslateX() + 75, 175);
        listeMur.add(mur6);

        Mur mur7 = new Mur(300, tailleMur, mur1.getTranslateX() + 175, 250);
        listeMur.add(mur7);

        Mur mur8 = new Mur(tailleMur, 100, mur1.getTranslateX() + 125, mur2.getHeight() - 150);
        listeMur.add(mur8);

        Mur mur9 = new Mur(50, tailleMur, socle.getBoundsInParent().getMinX() + 225, socle.getBoundsInParent().getMinY() + 50);
        listeMur.add(mur9);

        Mur mur10 = new Mur(tailleMur, 50,socle.getBoundsInParent().getMinX() + 250,socle.getBoundsInParent().getMinY() + 75);
        listeMur.add(mur10);

        Mur mur11 = new Mur(300, tailleMur, mur1.getTranslateX() + 325, mur2.getHeight() - 150);
        listeMur.add(mur11);

        Mur mur12 = new Mur(tailleMur, 50,socle.getBoundsInParent().getMinX() + 300,socle.getBoundsInParent().getMinY() + 25);
        listeMur.add(mur12);

        Mur mur13 = new Mur(200, tailleMur, mur1.getTranslateX() + 325, 100);
        listeMur.add(mur13);

        Mur mur14 = new Mur(tailleMur, 200, mur1.getTranslateX() + 475, 450);
        listeMur.add(mur14);

        Mur mur15 = new Mur(300, tailleMur, mur1.getTranslateX() + 275, 200);
        listeMur.add(mur15);

        Mur mur16 = new Mur(tailleMur, 100,mur1.getTranslateX() + 375, 300);
        listeMur.add(mur16);

        Mur mur17 = new Mur(tailleMur, 150,mur1.getTranslateX() + 425, 325);
        listeMur.add(mur17);

        Mur mur18 = new Mur(100, tailleMur,mur1.getTranslateX() + 325, mur2.getHeight());
        listeMur.add(mur18);

        Mur mur19 = new Mur(tailleMur, 300,mur1.getTranslateX() + 275, 450);
        listeMur.add(mur19);

        Mur mur20 = new Mur(150, tailleMur,mur1.getTranslateX() + 350, 400);
        listeMur.add(mur20);

        Mur mur21 = new Mur(50, tailleMur, mur1.getTranslateX() + 350, 350);
        listeMur.add(mur21);

        Mur mur22 = new Mur(100, tailleMur, mur1.getTranslateX() + 175, 300);
        listeMur.add(mur22);

        Mur mur23 = new Mur(tailleMur, 100, mur1.getTranslateX() + 175, 300);
        listeMur.add(mur23);

        Mur mur24 = new Mur(150, tailleMur, mur1.getTranslateX() + 150, 350);
        listeMur.add(mur24);

        Mur mur25 = new Mur(tailleMur, 150, mur1.getTranslateX() + 225, 425);
        listeMur.add(mur25);

        Mur mur26 = new Mur(200, tailleMur, mur1.getTranslateX() + 75, 400);
        listeMur.add(mur26);

        Mur mur27 = new Mur(250, tailleMur, mur1.getTranslateX() + 100, 450);
        listeMur.add(mur27);

        Mur mur28 = new Mur(tailleMur, 350, mur1.getTranslateX() - 25, 625);
        listeMur.add(mur28);

        Mur mur29 = new Mur(400, tailleMur, mur1.getTranslateX() + 175, 800);
        listeMur.add(mur29);

        Mur mur30 = new Mur(tailleMur, 50, mur1.getTranslateX() + 625,825); // mur invisble
        mur30.setVisible(false);
        listeMur.add(mur30);

        Mur mur31 = new Mur(150, tailleMur, mur1.getTranslateX() + 400,550);
        listeMur.add(mur31);

        Mur mur32 = new Mur(tailleMur, 100, mur1.getTranslateX() + 325,500);
        listeMur.add(mur32);

        Mur mur33 = new Mur(50, tailleMur, mur1.getTranslateX() + 400,500);
        listeMur.add(mur33);

        Mur mur34 = new Mur(tailleMur, 100, mur1.getTranslateX() + 425,450);
        listeMur.add(mur34);

        Mur mur35 = new Mur(50, tailleMur, mur1.getTranslateX() + 350,450);
        listeMur.add(mur35);

        Mur mur36 = new Mur(100, tailleMur, mur1.getTranslateX() + 325,600);
        listeMur.add(mur36);

        Mur mur37 = new Mur(tailleMur, 50, mur1.getTranslateX() + 375,625);
        listeMur.add(mur37);

        Mur mur38 = new Mur(tailleMur, 50, mur1.getTranslateX() + 425,575);
        listeMur.add(mur38);

        Mur mur39 = new Mur(50, tailleMur, mur1.getTranslateX() + 400,650);
        listeMur.add(mur39);

        Mur mur40 = new Mur(50, tailleMur, mur1.getTranslateX() + 450,600);
        listeMur.add(mur40);

        Mur mur41 = new Mur(tailleMur, 50, mur1.getTranslateX() + 475,625);
        listeMur.add(mur41);

        Mur mur42 = new Mur(tailleMur, 50, mur1.getTranslateX() + 425,675);
        listeMur.add(mur42);

        Mur mur43 = new Mur(50, tailleMur, mur1.getTranslateX() + 450,700);
        listeMur.add(mur43);

        Mur mur44 = new Mur(50, tailleMur, mur1.getTranslateX() + 500,650);
        listeMur.add(mur44);

        Mur mur45 = new Mur(tailleMur, 50, mur1.getTranslateX() + 525,675);
        listeMur.add(mur45);

        Mur mur46 = new Mur(tailleMur, 50, mur1.getTranslateX() + 475,725);
        listeMur.add(mur46);

        Mur mur47 = new Mur(50, tailleMur, mur1.getTranslateX() + 500,750);
        listeMur.add(mur47);

        Mur mur48 = new Mur(50, tailleMur, mur1.getTranslateX() + 550,700);
        listeMur.add(mur48);

        Mur mur49 = new Mur(tailleMur, 50, mur1.getTranslateX() + 575,725);
        listeMur.add(mur49);

        Mur mur50 = new Mur(tailleMur, 50, mur1.getTranslateX() + 525,775);
        listeMur.add(mur50);

        Mur mur51 = new Mur(100, tailleMur, mur1.getTranslateX() + 625,750);
        listeMur.add(mur51);

        Mur mur52 = new Mur(150, tailleMur, mur1.getTranslateX() + 100,500);
        listeMur.add(mur52);

        Mur mur53 = new Mur(tailleMur, 250, mur1.getTranslateX() + 25,625);
        listeMur.add(mur53);

        Mur mur54 = new Mur(tailleMur, 150, mur1.getTranslateX() + 175,575);
        listeMur.add(mur54);

        Mur mur55 = new Mur(200, tailleMur, mur1.getTranslateX() + 175,550);
        listeMur.add(mur55);

        Mur mur56 = new Mur(100, tailleMur, mur1.getTranslateX() + 75,600);
        listeMur.add(mur56);

        Mur mur57 = new Mur(100, tailleMur, mur1.getTranslateX() + 125,650);
        listeMur.add(mur57);

        Mur mur58 = new Mur(250, tailleMur, mur1.getTranslateX() + 550,800);
        listeMur.add(mur58);

        Mur mur59 = new Mur(tailleMur, 100, mur1.getTranslateX() + 75,700);
        listeMur.add(mur59);

        Mur mur60 = new Mur(50, tailleMur, mur1.getTranslateX() + 200,600);
        listeMur.add(mur60);

        Mur mur61 = new Mur(tailleMur, 100, mur1.getTranslateX() + 225,650);
        listeMur.add(mur61);

        Mur mur62 = new Mur(100, tailleMur, mur1.getTranslateX() + 175,700);
        listeMur.add(mur62);

        Mur mur63 = new Mur(200, tailleMur, mur1.getTranslateX() + 175,750);
        listeMur.add(mur63);

        Mur mur64 = new Mur(tailleMur, 100, mur1.getTranslateX() + 275,700);
        listeMur.add(mur64);

        Mur mur65 = new Mur(50, tailleMur, mur1.getTranslateX() + 300,650);
        listeMur.add(mur65);

        Mur mur66 = new Mur(100, tailleMur, mur1.getTranslateX() + 325,700);
        listeMur.add(mur66);

        Mur mur67 = new Mur(150, tailleMur, mur1.getTranslateX() + 350,750);
        listeMur.add(mur67);

        Mur mur68 = new Mur(50, tailleMur, mur1.getTranslateX() + 700,750); //mur invisible
        mur68.setVisible(false);
        listeMur.add(mur68);

        Mur mur69 = new Mur(tailleMur, 50, mur1.getTranslateX() + 475,75);
        listeMur.add(mur69);

        Mur mur70 = new Mur(tailleMur, 100, mur1.getTranslateX() + 525,100);
        listeMur.add(mur70);

        Mur mur71 = new Mur(150, tailleMur, mur1.getTranslateX() + 600,150);
        listeMur.add(mur71);

        Mur mur72 = new Mur(150, tailleMur, mur1.getTranslateX() + 650,100);
        listeMur.add(mur72);

        Mur mur73 = new Mur(100, tailleMur, mur1.getTranslateX() + 525,200);
        listeMur.add(mur73);

        Mur mur74 = new Mur(tailleMur, 150, mur1.getTranslateX() + 625,225);
        listeMur.add(mur74);

        Mur mur75 = new Mur(50, tailleMur, mur1.getTranslateX() + 550,250);
        listeMur.add(mur75);

        Mur mur76 = new Mur(100, tailleMur, mur1.getTranslateX() + 575,300);
        listeMur.add(mur76);

        Mur mur77 = new Mur(100, tailleMur, mur1.getTranslateX() + 575,350);
        listeMur.add(mur77);

        Mur mur78 = new Mur(tailleMur, 100, mur1.getTranslateX() + 675,250);
        listeMur.add(mur78);

        Mur mur79 = new Mur(100, tailleMur, mur1.getTranslateX() + 575,450); // mur qui tourne
        listeMur.add(mur79);

        Mur mur80 = new Mur(100, tailleMur, mur1.getTranslateX() + 575,450); // mur qui tourne
        mur80.setRotate(60);
        listeMur.add(mur80);

        Mur mur81 = new Mur(100, tailleMur, mur1.getTranslateX() + 575,450); // mur qui tourne
        mur81.setRotate(120);
        listeMur.add(mur81);

        Mur mur82 = new Mur(tailleMur, 200, mur1.getTranslateX() + 675,450);
        listeMur.add(mur82);

        Mur mur83 = new Mur(100, tailleMur, mur1.getTranslateX() + 575,550);
        listeMur.add(mur83);

        Mur mur84 = new Mur(tailleMur, 100, mur1.getTranslateX() + 675,650);
        listeMur.add(mur84);

        Mur mur85 = new Mur(150, tailleMur, mur1.getTranslateX() + 600,600);
        listeMur.add(mur85);

        Mur mur86 = new Mur(100, tailleMur, mur1.getTranslateX() + 625,650);
        listeMur.add(mur86);

        Mur mur87 = new Mur(50, tailleMur, mur1.getTranslateX() + 650,700);
        listeMur.add(mur87);

        Mur mur88 = new Mur(tailleMur, 100, mur1.getTranslateX() + 475, 250);
        listeMur.add(mur88);

        this.getChildren().addAll(
                clef, boule, socle, murHaut, murBas, murDroite, murGauche,
                compteurMort, murCheckpoint1, murCheckpoint2, murCheckpoint3, murCheckpoint4,
                mur1, mur2, mur3, mur4, mur5, mur6, mur7, mur8, mur9, mur10,
                mur11, mur12, mur13, mur14, mur15, mur16, mur17, mur18, mur19, mur20,
                mur21, mur22, mur23, mur24, mur25, mur26, mur27, mur28, mur29, mur30,
                mur31, mur32, mur33, mur34, mur35, mur36, mur37, mur38, mur39, mur40,
                mur41, mur42, mur43, mur44, mur45, mur46, mur47, mur48, mur49, mur50,
                mur51, mur52, mur53, mur54, mur55, mur56, mur57, mur58, mur59, mur60,
                mur61, mur62, mur63, mur64, mur65, mur66, mur67, mur68, mur69, mur70,
                mur71, mur72, mur73, mur74, mur75, mur76, mur77, mur78, mur79, mur80,
                mur81, mur82, mur83, mur84, mur85, mur86, mur87, mur88
        );

        timer = new AnimationTimer() {
            @Override
            public void handle(long l) {

                mur79.setRotate(mur79.getRotate() + 0.3);
                mur80.setRotate(mur80.getRotate() + 0.3);
                mur81.setRotate(mur81.getRotate() + 0.3);

                addRotate(clef, new Point3D(clef.getTranslateX(), clef.getTranslateY(), clef.getTranslateZ()), 0.5 + (Math.random() * (1.2 - 0.7)));

                for (Mur mur : listeMur) {
                    if(intersection(boule, mur)){
                        boule.setTranslateX(checkpoint[0].getTranslateX());
                        boule.setTranslateY(checkpoint[0].getTranslateY());
                        nombreMort++;
                        compteurMort.setText("Compteur de morts : " + nombreMort);
                        if(mur == mur30){
                            mur30.setVisible(true);
                        }else if(mur == mur68){
                            mur68.setVisible(true);
                        }
                    }
                }if(intersection(boule, murCheckpoint1)){
                    checkpoint[0] = murCheckpoint1;
                }else if(intersection(boule, murCheckpoint2)){
                    checkpoint[0] = murCheckpoint2;
                }else if(intersection(boule, murCheckpoint3)){
                    checkpoint[0] = murCheckpoint3;
                }else if(intersection(boule, murCheckpoint4)){
                    checkpoint[0] = murCheckpoint4;
                }if(intersection(boule, clef)){
                    timer.stop();
                    gagne();
                }
            }
        };
        timer.start();
    }

    public void gagne(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Bravo");
        alert.setHeaderText(null);
        alert.setContentText("Félicitation, vous avez réussi à sortir du labyrinthe \nObjet trouvé : pierre");
        alert.show();
    }

    public boolean intersection(Boule nodeA, Node nodeB) {

        /*if (nodeA.getBoundsInParent().getMinX() + 5 <= nodeB.getBoundsInParent().getMaxX() &&
                (nodeA.getBoundsInParent().getMaxX() + nodeA.getBoundsInParent().getMinX()) / 2 >= nodeB.getBoundsInParent().getMaxX() &&
                nodeA.getBoundsInParent().getMinY() < nodeB.getBoundsInParent().getMaxY() &&
                nodeA.getBoundsInParent().getMaxY() > nodeB.getBoundsInParent().getMinY()) {
            collision.set(3, false);
            //System.out.println("à droite");
        }else if(nodeA.getBoundsInParent().getMaxX() - 5 >= nodeB.getBoundsInParent().getMinX() &&
                (nodeA.getBoundsInParent().getMaxX() + nodeA.getBoundsInParent().getMinX()) / 2 <= nodeB.getBoundsInParent().getMinX() &&
                nodeA.getBoundsInParent().getMinY() < nodeB.getBoundsInParent().getMaxY() &&
                nodeA.getBoundsInParent().getMaxY() > nodeB.getBoundsInParent().getMinY()){
            collision.set(1 ,false);
            //System.out.println("à gauche");
        }else if(nodeA.getBoundsInParent().getMinY() + 5 <= nodeB.getBoundsInParent().getMaxY() &&
                (nodeA.getBoundsInParent().getMaxY() + nodeA.getBoundsInParent().getMinY()) / 2 >= nodeB.getBoundsInParent().getMaxY() &&
                nodeA.getBoundsInParent().getMinX() < nodeB.getBoundsInParent().getMaxX() &&
                nodeA.getBoundsInParent().getMaxX() > nodeB.getBoundsInParent().getMinX()){
            collision.set(0, false);
            //System.out.println("en bas");
        }else if(nodeA.getBoundsInParent().getMaxY() - 5 >= nodeB.getBoundsInParent().getMinY() &&
                (nodeA.getBoundsInParent().getMaxY() + nodeA.getBoundsInParent().getMinY()) / 2 <= nodeB.getBoundsInParent().getMaxY() &&
                nodeA.getBoundsInParent().getMinX() < nodeB.getBoundsInParent().getMaxX() &&
                nodeA.getBoundsInParent().getMaxX() > nodeB.getBoundsInParent().getMinX()){
            collision.set(2, false);
            //System.out.println("en haut");
        }*/

        double supplementCollision = 5.5;
        return  (nodeA.getBoundsInParent().getMinX() + supplementCollision <= nodeB.getBoundsInParent().getMaxX() && nodeA.getBoundsInParent().getMaxX() - supplementCollision >= nodeB.getBoundsInParent().getMinX()) &&
                (nodeA.getBoundsInParent().getMinY() + supplementCollision <= nodeB.getBoundsInParent().getMaxY() && nodeA.getBoundsInParent().getMaxY() - supplementCollision >= nodeB.getBoundsInParent().getMinY()) &&
                (nodeA.getBoundsInParent().getMinZ() + supplementCollision <= nodeB.getBoundsInParent().getMaxZ() && nodeA.getBoundsInParent().getMaxZ() - supplementCollision >= nodeB.getBoundsInParent().getMinZ());
    }

    public void deplacementBoule(Boule boule) {


        //mediaPlayer.play();

        stage.addEventHandler(KeyEvent.KEY_PRESSED, keyEvent -> {
            vitesseDeplacementRotation = 3;
            if (keyEvent.getCode() == KeyCode.LEFT) {
                addRotate(boule, new Point3D(0, boule.getTranslateY(), 0), vitesseDeplacementRotation);
                boule.setTranslateX(boule.getTranslateX() - vitesseDeplacementRotation);
                boulleRoulante.play();
            }
            if (keyEvent.getCode() == KeyCode.RIGHT) {
                addRotate(boule, new Point3D(0, boule.getTranslateY(), 0), - vitesseDeplacementRotation);
                boule.setTranslateX(boule.getTranslateX() + vitesseDeplacementRotation);
                //mediaPlayer.play();
                boulleRoulante.play();
            }
            if (keyEvent.getCode() == KeyCode.UP) {
                addRotate(boule, new Point3D(boule.getTranslateX(), 0, 0), - vitesseDeplacementRotation);
                boule.setTranslateY(boule.getTranslateY() - vitesseDeplacementRotation);
                boulleRoulante.play();
            }
            if (keyEvent.getCode() == KeyCode.DOWN) {
                addRotate(boule, new Point3D(boule.getTranslateX(), 0, 0), vitesseDeplacementRotation);
                boule.setTranslateY(boule.getTranslateY() + vitesseDeplacementRotation);
                boulleRoulante.play();
            }
        });
    }

    public void addRotate(Node node, Point3D rotationAxis, double angle) {
        ObservableList<Transform> transforms = node.getTransforms();
        try {
            for (Transform t : transforms) {
                rotationAxis = t.inverseDeltaTransform(rotationAxis);
            }
        } catch (NonInvertibleTransformException ex) {
            throw new IllegalStateException(ex);
        }
        transforms.add(new Rotate(angle, rotationAxis));
    }
}
