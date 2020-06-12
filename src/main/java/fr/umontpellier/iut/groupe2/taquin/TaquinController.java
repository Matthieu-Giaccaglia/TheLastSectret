package fr.umontpellier.iut.groupe2.taquin;


import fr.umontpellier.iut.groupe1.Main;
import fr.umontpellier.iut.groupe1.data.ImageLoader;
import fr.umontpellier.iut.groupe1.thread.ThreadTimer;
import fr.umontpellier.iut.groupe2.inventaire.ItemId;
import javafx.animation.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.nio.file.Paths;
import java.util.Random;

public class TaquinController {

    public ImageView indice;
    public ImageView taquinIndice;
    public TextField textIndice;
    public Button buttonOui;
    public Button buttonNon;
    @FXML
    private Button buttonFinish;
    @FXML
    private TextField pasCassable;
    @FXML
    private ImageView mur;
    @FXML
    private ImageView gemme;
    @FXML
    private GridPane taquinGrid;
    @FXML
    private AnchorPane taquinAnchor;
    @FXML
    private ImageView pieceUn, pieceDeux, pieceTrois, pieceQuatre, pieceCinq, pieceSix, pieceSept, pieceHuit, pieceNeuf, pieceDix, pieceOnze, pieceDouze;


    private final int[][] mat1 = {{11, 5, 8, 7}, {10, 4, 9, 0}, {3, 1, 6, 2}};
    @FXML
    private final Taquin taquin = new Taquin(mat1);
    private int compteur;
    private Thread thread;
    private int compteurIndice;


    private final MediaPlayer putPiece25 = new MediaPlayer(new Media(Paths.get("src/main/resources/sound/groupe2/taquin/soundPutLastPiece.mp3").toUri().toString()));
    private final MediaPlayer stoneDrag = new MediaPlayer(new Media(Paths.get("src/main/resources/sound/groupe2/taquin/soundTaquinMove.mp3").toUri().toString()));
    private final MediaPlayer impactUn = new MediaPlayer(new Media(Paths.get("src/main/resources/sound/groupe2/taquin/soundBreakWall1.mp3").toUri().toString()));
    private final MediaPlayer impactDeux = new MediaPlayer(new Media(Paths.get("src/main/resources/sound/groupe2/taquin/soundBreakWall2.mp3").toUri().toString()));

    private final Media[] listSound = {   new Media(Paths.get("src/main/resources/sound/groupe2/taquin/soundPieceTaquinMove1.mp3").toUri().toString()),
                                    new Media(Paths.get("src/main/resources/sound/groupe2/taquin/soundPieceTaquinMove2.mp3").toUri().toString()),
                                    new Media(Paths.get("src/main/resources/sound/groupe2/taquin/soundPieceTaquinMove3.mp3").toUri().toString())};
    private final Random random = new Random();

    public void mouvement(MouseEvent event) {

        if (!taquin.estGagnant()) {
            if (event.getSource() == pieceUn) {
                updateScene(pieceUn, 1);
            } else if (event.getSource() == pieceDeux) {
                updateScene(pieceDeux, 2);
            } else if (event.getSource() == pieceTrois) {
                updateScene(pieceTrois, 3);
            } else if (event.getSource() == pieceQuatre) {
                updateScene(pieceQuatre, 4);
            } else if (event.getSource() == pieceCinq) {
                updateScene(pieceCinq, 5);
            } else if (event.getSource() == pieceSix) {
                updateScene(pieceSix, 6);
            } else if (event.getSource() == pieceSept) {
                updateScene(pieceSept, 7);
            } else if (event.getSource() == pieceHuit) {
                updateScene(pieceHuit, 8);
            } else if (event.getSource() == pieceNeuf) {
                updateScene(pieceNeuf, 9);
            } else if (event.getSource() == pieceDix) {
                updateScene(pieceDix, 10);
            } else if (event.getSource() == pieceOnze) {
                updateScene(pieceOnze, 11);
            }
        }

        if (pieceDouze.isDisable() && taquin.estGagnant()) {
            taquinTermine();
            pieceDouze.setVisible(true);
            pieceDouze.setDisable(false);
        }
    }

    public void putLastPiece() {
        if (Main.stepManager.getInventaire().getItemIdSelection() == ItemId.taquinPiece12) {
            pieceDouze.setDisable(true);
            putPiece25.play();
            pieceDouze.setImage(ItemId.taquinPiece12.getImage());
            Main.stepManager.getInventaire().retirerItem(ItemId.taquinPiece12);

            stoneDrag.setVolume(0.7);
            stoneDrag.play();

            TranslateTransition translateAnimation = new TranslateTransition(Duration.seconds(2.0), taquinAnchor);
            translateAnimation.setByX(-800);
            translateAnimation.play();

            translateAnimation.setOnFinished(event -> mur.setDisable(false));

            taquinAnchor.setDisable(true);
        }
    }

    private void updateScene (Node node, int i){

        int [] coordonnePiece12 = taquin.trouverCoordonne(0);
        int [] coordonnePieceNode = taquin.trouverCoordonne(i);

        if(taquin.peutDeplacer(i)) {
            taquinGrid.setDisable(true);
            taquinGrid.layout();

            TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.3),node);
            translateTransition.setToX( pieceDouze.getLayoutX() - node.getLayoutX());
            translateTransition.setToY( pieceDouze.getLayoutY() - node.getLayoutY());

            TranslateTransition translateTransitionDouze = new TranslateTransition(Duration.seconds(0.3),pieceDouze);
            translateTransitionDouze.setToX( node.getLayoutX() - pieceDouze.getLayoutX());
            translateTransitionDouze.setToY( node.getLayoutY() - pieceDouze.getLayoutY());

            ParallelTransition parallelTransition = new ParallelTransition(translateTransition,translateTransitionDouze);
            parallelTransition.play();

            parallelTransition.setOnFinished(event -> {
                taquinGrid.getChildren().remove(pieceDouze);
                pieceDouze.setTranslateX(0);
                pieceDouze.setTranslateY(0);
                taquinGrid.add(pieceDouze,coordonnePieceNode[1], coordonnePieceNode[0]);

                taquinGrid.getChildren().remove(node);
                node.setTranslateX(0);
                node.setTranslateY(0);
                taquinGrid.add(node,coordonnePiece12[1], coordonnePiece12[0]);

                taquinGrid.setDisable(false);
            });

            new MediaPlayer(listSound[random.nextInt(3)]).play();
        }
    }

    public void taquinTermine(){
        pieceUn.setDisable(true);
        pieceDeux.setDisable(true);
        pieceTrois.setDisable(true);
        pieceQuatre.setDisable(true);
        pieceCinq.setDisable(true);
        pieceSix.setDisable(true);
        pieceSept.setDisable(true);
        pieceHuit.setDisable(true);
        pieceNeuf.setDisable(true);
        pieceDix.setDisable(true);
        pieceOnze.setDisable(true);
    }

    public void recupGemme() {
        if(Main.stepManager.getInventaire().inventairePasPlein()) {
            Main.stepManager.getInventaire().ajouterItem(ItemId.gemmeBleue);
            gemme.setVisible(false);
        }
    }

    public void casserLeMur() {
        if (Main.stepManager.getInventaire().getItemIdSelection() == ItemId.marteau) {
        pasCassable.setVisible(false);
        compteur++;
        System.out.println(compteur);
        if(compteur == 1){
            mur.setImage(ImageLoader.getImage("groupe2/taquin/fissure2.png"));
            impactUn.play();
        } else if (compteur == 2){
            impactDeux.play();
            mur.setImage(ImageLoader.getImage("groupe2/taquin/fissure3.png"));
            mur.setDisable(true);
            gemme.setDisable(false);
            Main.stepManager.getInventaire().retirerItem(ItemId.marteau);
        }
        }else pasCassable.setVisible(true);
    }

    public void finish() {
        taquinTermine();
        taquinResoudre();
        pieceDouze.setDisable(false);
    }

    public TranslateTransition animationResoudreTaquin(Node node, int x, int y){
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1), node);
        translateTransition.setByX(getNode(x,y).getLayoutX() - node.getLayoutX());
        translateTransition.setByY(getNode(x,y).getLayoutY() - node.getLayoutY());
        return translateTransition;
    }

    public void taquinResoudre(){

        ParallelTransition parallelTransition = new ParallelTransition(
                animationResoudreTaquin(pieceUn,0,0),
                animationResoudreTaquin(pieceDeux,0,1),
                animationResoudreTaquin(pieceTrois,0,2),
                animationResoudreTaquin(pieceQuatre,0,3),
                animationResoudreTaquin(pieceCinq,1,0),
                animationResoudreTaquin(pieceSix,1,1),
                animationResoudreTaquin(pieceSept,1,2),
                animationResoudreTaquin(pieceHuit,1,3),
                animationResoudreTaquin(pieceNeuf,2,0),
                animationResoudreTaquin(pieceDix,2,1),
                animationResoudreTaquin(pieceOnze,2,2),
                animationResoudreTaquin(pieceDouze,2,3)
                );

        parallelTransition.playFromStart();

    }

    public Node getNode(int x, int y){

        if (taquin.getNumber(x, y) == 0){
            return pieceDouze;
        } else if (taquin.getNumber(x, y) == 1){
            return pieceUn;
        } else if (taquin.getNumber(x, y) == 2){
            return pieceDeux;
        } else if (taquin.getNumber(x, y) == 3){
            return pieceTrois;
        } else if (taquin.getNumber(x, y) == 4){
            return pieceQuatre;
        } else if (taquin.getNumber(x, y) == 5){
            return pieceCinq;
        } else if (taquin.getNumber(x, y) == 6){
            return pieceSix;
        } else if (taquin.getNumber(x, y) == 7){
            return pieceSept;
        } else if (taquin.getNumber(x, y) == 8){
            return pieceHuit;
        } else if (taquin.getNumber(x, y) == 9){
            return pieceNeuf;
        } else if (taquin.getNumber(x, y) == 10){
            return pieceDix;
        } else{
            return pieceOnze;
        }
    }

    public void showIndice() {
        compteur++;
        indice.setVisible(false);

        thread = new Thread(() -> {
            taquinIndice.setVisible(true);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            taquinIndice.setVisible(false);
            indice.setVisible(true);
            if (compteur >= 5) {
                buttonOui.setVisible(true);
                buttonNon.setVisible(true);
                textIndice.setVisible(true);
            }
        });

        thread.start();
    }

    public void indiceReponse(ActionEvent event) {
        if (event.getSource() == buttonOui){
            finish();
            indice.setVisible(false);
        }
        textIndice.setVisible(false);
        buttonNon.setVisible(false);
        buttonOui.setVisible(false);
    }
}
