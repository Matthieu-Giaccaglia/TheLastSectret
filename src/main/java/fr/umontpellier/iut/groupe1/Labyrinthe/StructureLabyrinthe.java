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

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class StructureLabyrinthe extends Group {

    PhongMaterial material = new PhongMaterial();
    private final Stage stage;
    private final List<Mur> listeMur = new ArrayList<>();
    private final double vitesseDeplacementRotation = 4;
    private int nombreMort = 0;
    private Label compteurMort = new Label("Compteur de morts : " + nombreMort);
    private double tailleSocle;

    public StructureLabyrinthe(double width, double height, Stage stage) {
        this.stage = stage;

        Mur murCheckpoint1 = new Mur(20, 20, 20, width/2 -125, height/2 -150);
        material.setDiffuseColor(Color.RED);
        murCheckpoint1.setMaterial(material);

        Mur murCheckpoint2 = new Mur(20, 20, 20, width, height);
        material.setDiffuseColor(Color.RED);
        murCheckpoint2.setMaterial(material);

        final Mur[] checkpoint = {murCheckpoint1};

        Boule boule = new Boule(14, checkpoint[0].getTranslateX(), checkpoint[0].getTranslateY());

        deplacementBoule(boule);

        if(width*2 > height*2){
            tailleSocle = height*2 - 100;
        }else if(width*2 <= height*2){
            tailleSocle = width*2 - 100;
        }

        Socle socle = new Socle(tailleSocle, 10, width, height);
        int tailleMur = 5;

       compteurMort.setBounds((int) width, (int) height, 100, 30);

        Mur murHaut = new Mur(socle.getWidth(), tailleMur, 100, width, socle.getBoundsInParent().getMinY() );
        listeMur.add(murHaut);

        Mur murDroite = new Mur(tailleMur, socle.getHeight(), 100, socle.getBoundsInParent().getMaxX(), height );
        listeMur.add(murDroite);

        Mur murBas = new Mur(socle.getWidth(), tailleMur, 100, width, socle.getBoundsInParent().getMaxY());
        listeMur.add(murBas);

        Mur murGauche = new Mur(tailleMur, socle.getHeight(), 100, socle.getBoundsInParent().getMinX(), height);
        listeMur.add(murGauche);

        Mur mur1 = new Mur(50, tailleMur, 100, socle.getBoundsInParent().getMinX() + 75, socle.getBoundsInParent().getMinY() + 50);
        listeMur.add(mur1);

        Mur mur2 = new Mur(tailleMur, 300, 100, socle.getBoundsInParent().getMinX() + 50, socle.getBoundsInParent().getMinY() + 150 + 50);
        listeMur.add(mur2);

        Mur mur3 = new Mur(tailleMur, 100, 100, socle.getBoundsInParent().getMinX() + 100, socle.getBoundsInParent().getMinY() + 150);
        listeMur.add(mur3);

        Mur mur4 = new Mur(50, tailleMur, 100, mur1.getTranslateX(), 350);
        listeMur.add(mur4);

        Mur mur5 = new Mur(100, tailleMur, 100, mur1.getTranslateX() + 25, 300);
        listeMur.add(mur5);

        Mur mur6 = new Mur(tailleMur, 150, 100, mur1.getTranslateX() + 75, 175);
        listeMur.add(mur6);

        Mur mur7 = new Mur(300, tailleMur, 100, mur1.getTranslateX() + 175, 250);
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

        Mur mur13 = new Mur(200, tailleMur, 100, mur1.getTranslateX() + 325, 100);
        listeMur.add(mur13);

        Mur mur14 = new Mur(tailleMur, 300, 100, mur1.getTranslateX() + 475, 250);
        listeMur.add(mur14);

        Mur mur15 = new Mur(300, tailleMur, 100, mur1.getTranslateX() + 275, 200);
        listeMur.add(mur15);

        Mur mur16 = new Mur(tailleMur, 100, 100, mur1.getTranslateX() + 375, 300);
        listeMur.add(mur16);

        Mur mur17 = new Mur(tailleMur, 150, 100, mur1.getTranslateX() + 425, 325);
        listeMur.add(mur17);

        Mur mur18 = new Mur(100, tailleMur, 100, mur1.getTranslateX() + 325, mur2.getHeight());
        listeMur.add(mur18);

        Mur mur19 = new Mur(tailleMur, 200, 100, mur1.getTranslateX() + 275, 400);
        listeMur.add(mur19);

        Mur mur20 = new Mur(150, tailleMur, 100, mur1.getTranslateX() + 350, 400);
        listeMur.add(mur20);

        Mur mur21 = new Mur(50, tailleMur, 100, mur1.getTranslateX() + 350, 350);
        listeMur.add(mur21);

        Mur mur22 = new Mur(100, tailleMur, 100, mur1.getTranslateX() + 175, 300);
        listeMur.add(mur22);

        this.getChildren().addAll(
                boule, socle, murHaut, murBas, murDroite, murGauche, murCheckpoint1, murCheckpoint2, mur1, mur2, mur3, mur4, mur5, mur6, mur7, mur8, mur9, mur10, mur11, mur12, mur13, mur14, mur15, mur16, mur17, mur18,
                mur19, mur20, mur21, mur22
        );

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                for (Mur mur : listeMur) {
                    if(intersection(boule, mur)){
                        boule.setTranslateX(checkpoint[0].getTranslateX());
                        boule.setTranslateY(checkpoint[0].getTranslateY());
                        nombreMort++;
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

        int supplementCollision = 5;
        return  (nodeA.getBoundsInParent().getMinX() + supplementCollision <= nodeB.getBoundsInParent().getMaxX() && nodeA.getBoundsInParent().getMaxX() - supplementCollision >= nodeB.getBoundsInParent().getMinX()) &&
                (nodeA.getBoundsInParent().getMinY() + supplementCollision <= nodeB.getBoundsInParent().getMaxY() && nodeA.getBoundsInParent().getMaxY() - supplementCollision >= nodeB.getBoundsInParent().getMinY()) &&
                (nodeA.getBoundsInParent().getMinZ() + supplementCollision <= nodeB.getBoundsInParent().getMaxZ() && nodeA.getBoundsInParent().getMaxZ() - supplementCollision >= nodeB.getBoundsInParent().getMinZ());
    }

    public synchronized void deplacementBoule(Boule boule) {

        stage.addEventHandler(KeyEvent.KEY_PRESSED, keyEvent -> {
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
