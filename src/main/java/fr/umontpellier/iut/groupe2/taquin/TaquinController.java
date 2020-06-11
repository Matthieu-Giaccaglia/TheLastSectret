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
    Random random = new Random();

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

        MainSalleGroupe2.stepManager.getInventaire().ajouterItem(ItemId.gemmeBleue);
        gemme.setVisible(false);
    }


    public void casserLeMur() {
        if (MainSalleGroupe2.stepManager.getInventaire().getItemIdSelection() == ItemId.marteau)
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
    }

    public void finish() {
        recupGemme();
    }
}
