package fr.umontpellier.iut.groupe2.taquin;


import fr.umontpellier.iut.groupe1.data.ImageLoader;
import fr.umontpellier.iut.groupe2.MainSalleGroupe2;
import fr.umontpellier.iut.groupe2.inventaire.ItemId;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
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



    private final MediaPlayer putPiece25 = new MediaPlayer(new Media(Paths.get("src/main/resources/sound/groupe2/taquin/soundPutLastPiece.mp3").toUri().toString()));
    private final MediaPlayer stoneDrag = new MediaPlayer(new Media(Paths.get("src/main/resources/sound/groupe2/taquin/soundTaquinMove.mp3").toUri().toString()));
    private final MediaPlayer impactUn = new MediaPlayer(new Media(Paths.get("src/main/resources/sound/groupe2/taquin/soundBreakWall1.mp3").toUri().toString()));
    private final MediaPlayer impactDeux = new MediaPlayer(new Media(Paths.get("src/main/resources/sound/groupe2/taquin/soundBreakWall2.mp3").toUri().toString()));

    private Media[] listSound = {   new Media(Paths.get("src/main/resources/sound/groupe2/taquin/soundPieceTaquinMove1.mp3").toUri().toString()),
                                    new Media(Paths.get("src/main/resources/sound/groupe2/taquin/soundPieceTaquinMove2.mp3").toUri().toString()),
                                    new Media(Paths.get("src/main/resources/sound/groupe2/taquin/soundPieceTaquinMove3.mp3").toUri().toString())};
    private Random random = new Random();

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
            pieceDouze.setVisible(true);
            pieceDouze.setDisable(false);
        }
    }




    public void putLastPiece() {
        if (MainSalleGroupe2.stepManager.getInventaire().getItemIdSelection() == ItemId.taquinPiece12) {
            pieceDouze.setDisable(true);
            putPiece25.play();
            pieceDouze.setImage(ItemId.taquinPiece12.getImage());
            MainSalleGroupe2.stepManager.getInventaire().retirerItem(ItemId.taquinPiece12);

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



    public void recupGemme() {
        if(MainSalleGroupe2.stepManager.getInventaire().inventairePasPlein()) {
            MainSalleGroupe2.stepManager.getInventaire().ajouterItem(ItemId.gemmeBleue);
            gemme.setVisible(false);
        }
    }


    public void casserLeMur() {
        if (MainSalleGroupe2.stepManager.getInventaire().getItemIdSelection() == ItemId.marteau) {
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
            MainSalleGroupe2.stepManager.getInventaire().retirerItem(ItemId.marteau);
        }
        }else pasCassable.setVisible(true);
    }

    public void finish() {
        taquinResoudre();
        pieceDouze.setDisable(false);
    }

    public void taquinResoudre(){

        TranslateTransition translatePiece1 = new TranslateTransition(Duration.seconds(1), pieceUn);
        translatePiece1.setByX(getNode(0,0).getLayoutX() - pieceUn.getLayoutX());
        translatePiece1.setByY(getNode(0,0).getLayoutY() - pieceUn.getLayoutY());

        TranslateTransition translatePiece2 = new TranslateTransition(Duration.seconds(1), pieceDeux);
        translatePiece2.setByX(getNode(0,1).getLayoutX() - pieceDeux.getLayoutX());
        translatePiece2.setByY(getNode(0,1).getLayoutY() - pieceDeux.getLayoutY());

        TranslateTransition translatePiece3 = new TranslateTransition(Duration.seconds(1), pieceTrois);
        translatePiece3.setByX(getNode(0,2).getLayoutX() - pieceTrois.getLayoutX());
        translatePiece3.setByY(getNode(0,2).getLayoutY() - pieceTrois.getLayoutY());

        TranslateTransition translatePiece4 = new TranslateTransition(Duration.seconds(1), pieceQuatre);
        translatePiece4.setByX(getNode(0,3).getLayoutX() - pieceQuatre.getLayoutX());
        translatePiece4.setByY(getNode(0,3).getLayoutY() - pieceQuatre.getLayoutY());

        TranslateTransition translatePiece5 = new TranslateTransition(Duration.seconds(1), pieceCinq);
        translatePiece5.setByX(getNode(1,0).getLayoutX() - pieceCinq.getLayoutX());
        translatePiece5.setByY(getNode(1,0).getLayoutY() - pieceCinq.getLayoutY());

        TranslateTransition translatePiece6 = new TranslateTransition(Duration.seconds(1), pieceSix);
        translatePiece6.setByX(getNode(1,1).getLayoutX() - pieceSix.getLayoutX());
        translatePiece6.setByY(getNode(1,1).getLayoutY() - pieceSix.getLayoutY());

        TranslateTransition translatePiece7 = new TranslateTransition(Duration.seconds(1), pieceSept);
        translatePiece7.setByX(getNode(1,2).getLayoutX() - pieceSept.getLayoutX());
        translatePiece7.setByY(getNode(1,2).getLayoutY() - pieceSept.getLayoutY());

        TranslateTransition translatePiece8 = new TranslateTransition(Duration.seconds(1), pieceHuit);
        translatePiece8.setByX(getNode(1,3).getLayoutX() - pieceHuit.getLayoutX());
        translatePiece8.setByY(getNode(1,3).getLayoutY() - pieceHuit.getLayoutY());

        TranslateTransition translatePiece9 = new TranslateTransition(Duration.seconds(1), pieceNeuf);
        translatePiece9.setByX(getNode(2,0).getLayoutX() - pieceNeuf.getLayoutX());
        translatePiece9.setByY(getNode(2,0).getLayoutY() - pieceNeuf.getLayoutY());

        TranslateTransition translatePiece10 = new TranslateTransition(Duration.seconds(1), pieceDix);
        translatePiece10.setByX(getNode(2,1).getLayoutX() - pieceDix.getLayoutX());
        translatePiece10.setByY(getNode(2,1).getLayoutY() - pieceDix.getLayoutY());

        TranslateTransition translatePiece11 = new TranslateTransition(Duration.seconds(1), pieceOnze);
        translatePiece11.setByX(getNode(2,2).getLayoutX() - pieceOnze.getLayoutX());
        translatePiece11.setByY(getNode(2,2).getLayoutY() - pieceOnze.getLayoutY());

        TranslateTransition translatePiece12 = new TranslateTransition(Duration.seconds(1), pieceDouze);
        translatePiece12.setByX(getNode(2,3).getLayoutX() - pieceDouze.getLayoutX());
        translatePiece12.setByY(getNode(2,3).getLayoutY() - pieceDouze.getLayoutY());

        ParallelTransition parallelTransition = new ParallelTransition(
                translatePiece1,
                translatePiece2,
                translatePiece3,
                translatePiece4,
                translatePiece5,
                translatePiece6,
                translatePiece7,
                translatePiece8,
                translatePiece9,
                translatePiece10,
                translatePiece11,
                translatePiece12);

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
}
