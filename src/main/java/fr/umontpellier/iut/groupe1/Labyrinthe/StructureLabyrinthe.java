package fr.umontpellier.iut.groupe1.Labyrinthe;

import javafx.animation.AnimationTimer;
import javafx.collections.ObservableList;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.transform.NonInvertibleTransformException;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class StructureLabyrinthe extends Group {

    PhongMaterial material = new PhongMaterial();
    private final Stage stage;
    private final List<Mur> listeMur = new ArrayList<>();
    private final double vitesseDeplacementRotation = 4;

    public StructureLabyrinthe(double width, double height, Stage stage) {
        this.stage = stage;

        Boule boule = new Boule(14, width/2 -125, height/2 -145);

        deplacementBoule(boule);

        Socle socle = new Socle(800, 10);
        socle.setTranslateX(width);
        socle.setTranslateY(height);
        int tailleMur = 5;

        Mur murHaut = new Mur(socle.getWidth(), tailleMur, 100, width, socle.getBoundsInParent().getMinY() );
        listeMur.add(murHaut);

        Mur murDroite = new Mur(tailleMur, socle.getHeight(), 100, socle.getBoundsInParent().getMaxX(), height );
        listeMur.add(murDroite);

        Mur murBas = new Mur(socle.getWidth(), tailleMur, 100, width, socle.getBoundsInParent().getMaxY());
        listeMur.add(murBas);

        Mur murGauche = new Mur(tailleMur, socle.getHeight(), 100, socle.getBoundsInParent().getMinX(), height);
        listeMur.add(murGauche);

        Mur murCheckpoint1 = new Mur(20, 20, 20, width/2 -125, height/2 -145);
        material.setDiffuseColor(Color.RED);
        murCheckpoint1.setMaterial(material);

        Mur murCheckpoint2 = new Mur(20, 20, 20, width, height);
        material.setDiffuseColor(Color.RED);
        murCheckpoint2.setMaterial(material);

        final Mur[] checkpoint = {murCheckpoint1};

        Mur mur1 = new Mur(50, tailleMur, 100, socle.getBoundsInParent().getMinX() + 75, socle.getBoundsInParent().getMinY() + 50);
        listeMur.add(mur1);

        Mur mur2 = new Mur(tailleMur, 300, 100, socle.getBoundsInParent().getMinX() + 50, socle.getBoundsInParent().getMinY() + 150 + 50);
        listeMur.add(mur2);

        Mur mur3 = new Mur(tailleMur, 100, 100, socle.getBoundsInParent().getMinX() + 100, socle.getBoundsInParent().getMinY() + 150);
        listeMur.add(mur3);

        Mur mur4 = new Mur(50, tailleMur, 100, mur1.getTranslateX(), 50 + mur2.getHeight());
        listeMur.add(mur4);

        Mur mur5 = new Mur(100, tailleMur, 100, mur1.getTranslateX() + 25, mur2.getHeight());
        listeMur.add(mur5);

        Mur mur6 = new Mur(tailleMur, 150, 100, mur1.getTranslateX() + 75, mur2.getHeight() - 125);
        listeMur.add(mur6);

        Mur mur7 = new Mur(300, tailleMur, 100, mur1.getTranslateX() + 175, mur2.getHeight() - 50);
        listeMur.add(mur7);

        Mur mur8 = new Mur(tailleMur, 100, 100, mur1.getTranslateX() + 125, mur2.getHeight() - 150);
        listeMur.add(mur8);

        Mur mur9 = new Mur(50, tailleMur, 100, socle.getBoundsInParent().getMinX() + 225, socle.getBoundsInParent().getMinY() + 50);
        listeMur.add(mur9);

        Mur mur10 = new Mur(tailleMur, 50, 100,socle.getBoundsInParent().getMinX() + 250,socle.getBoundsInParent().getMinY() + 75);
        listeMur.add(mur10);

        Mur mur11 = new Mur(300, tailleMur, 100, mur1.getTranslateX() + 325, mur2.getHeight() - 150);
        listeMur.add(mur11);

        Mur mur12 = new Mur(tailleMur, 50, 100,socle.getBoundsInParent().getMinX() + 300,socle.getBoundsInParent().getMinY() + 25);
        listeMur.add(mur12);

        Mur mur13 = new Mur(200, tailleMur, 100, mur1.getTranslateX() + 325, mur2.getHeight() - 200);
        listeMur.add(mur13);

        Mur mur14 = new Mur(tailleMur, 300, 100, mur1.getTranslateX() + 475, mur2.getHeight() - 50);
        listeMur.add(mur14);

        Mur mur15 = new Mur(300, tailleMur, 100, mur1.getTranslateX() + 275, mur2.getHeight() - 100);
        listeMur.add(mur15);

        /*Mur mur16 = new Mur(300, tailleMur, 100, mur1.getTranslateX() + 325, mur2.getHeight() - 150);
        listeMur.add(mur16);*/

        this.getChildren().addAll(
                boule, socle, murHaut, murBas, murDroite, murGauche, murCheckpoint1, murCheckpoint2, mur1, mur2, mur3, mur4, mur5, mur6, mur7, mur8, mur9, mur10, mur11, mur12, mur13, mur14, mur15
        );

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                for (Mur mur : listeMur) {
                    if(intersection(boule, mur)){
                        boule.setTranslateX(checkpoint[0].getTranslateX());
                        boule.setTranslateY(checkpoint[0].getTranslateY());
                    }else if(intersection(boule, murCheckpoint1)){
                        checkpoint[0] = murCheckpoint1;
                    }else if(intersection(boule, murCheckpoint2)){
                        checkpoint[0] = murCheckpoint2;
                    }
                }
            }
        };
        timer.start();
    }

    public boolean intersection(Boule nodeA, Mur nodeB) {

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

        return  (nodeA.getBoundsInParent().getMinX() + 5 <= nodeB.getBoundsInParent().getMaxX() && nodeA.getBoundsInParent().getMaxX() - 5 >= nodeB.getBoundsInParent().getMinX()) &&
                (nodeA.getBoundsInParent().getMinY() + 5 <= nodeB.getBoundsInParent().getMaxY() && nodeA.getBoundsInParent().getMaxY() - 5 >= nodeB.getBoundsInParent().getMinY()) &&
                (nodeA.getBoundsInParent().getMinZ() + 5 <= nodeB.getBoundsInParent().getMaxZ() && nodeA.getBoundsInParent().getMaxZ() - 5 >= nodeB.getBoundsInParent().getMinZ());
    }

    public synchronized void deplacementBoule(Boule boule) {

        stage.addEventHandler(KeyEvent.KEY_PRESSED, keyEvent -> {
            //System.out.println(collision[1]);
            if (keyEvent.getCode() == KeyCode.LEFT) {
                addRotate(boule, new Point3D(0, boule.getTranslateY(), 0), vitesseDeplacementRotation);
                boule.setTranslateX(boule.getTranslateX() - vitesseDeplacementRotation);
            }
            if (keyEvent.getCode() == KeyCode.RIGHT) {
                addRotate(boule, new Point3D(0, boule.getTranslateY(), 0), -vitesseDeplacementRotation);
                boule.setTranslateX(boule.getTranslateX() + vitesseDeplacementRotation);
            }
            if (keyEvent.getCode() == KeyCode.UP) {
                addRotate(boule, new Point3D(boule.getTranslateX(), 0, 0), -vitesseDeplacementRotation);
                boule.setTranslateY(boule.getTranslateY() - vitesseDeplacementRotation);
            }
            if (keyEvent.getCode() == KeyCode.DOWN) {
                addRotate(boule, new Point3D(boule.getTranslateX(), 0, 0), vitesseDeplacementRotation);
                boule.setTranslateY(boule.getTranslateY() + vitesseDeplacementRotation);
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
