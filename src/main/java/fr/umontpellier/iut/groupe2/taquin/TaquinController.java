package fr.umontpellier.iut.groupe2.taquin;


import fr.umontpellier.iut.groupe2.MainSalleGroupe2;
import fr.umontpellier.iut.groupe2.inventaire.ItemId;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
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

    public AnchorPane taquinAnchor;
    @FXML
    private ImageView pieceUn, pieceDeux, pieceTrois, pieceQuatre, pieceCinq, pieceSix, pieceSept, pieceHuit, pieceNeuf, pieceDix, pieceOnze, pieceDouze;
    @FXML
    private ImageView gemme;

    private final int[][] mat1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 0, 11}};
    @FXML
    private final Taquin taquin = new Taquin(mat1);
    private boolean gagnant = false;

    public Media mouv1 = new Media(Paths.get("src/main/resources/sound/groupe2/taquin/mouv1.mp3").toUri().toString());
    public Media mouv2 = new Media(Paths.get("src/main/resources/sound/groupe2/taquin/mouv2.mp3").toUri().toString());
    public Media mouv3 = new Media(Paths.get("src/main/resources/sound/groupe2/taquin/mouv3.mp3").toUri().toString());

    private final MediaPlayer putPiece25 = new MediaPlayer(new Media(Paths.get("src/main/resources/sound/groupe2/taquin/putPiece25.mp3").toUri().toString()));
    private final MediaPlayer stoneDrag = new MediaPlayer(new Media(Paths.get("src/main/resources/sound/groupe2/taquin/stoneDrag.mp3").toUri().toString()));


    Random random = new Random();
    public Media[] listSound = {mouv1,mouv2,mouv3};


    public void mouvement(MouseEvent event) {

        if (!taquin.estGagnant()) {
            System.out.println(taquin.estGagnant());
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
                System.out.println("ok");
                updateScene(pieceOnze, 11);
            }
        }

        if (pieceDouze.isDisable() && taquin.estGagnant()) {
            pieceDouze.setDisable(false);
        }

    }




    public void putLastPiece(MouseEvent mouseEvent) {
        if (MainSalleGroupe2.stepManager.getInventaire().getItemIdSelection() == ItemId.taquinPiece12) {
            putPiece25.play();
            pieceDouze.setImage(ItemId.taquinPiece12.getImage());
            MainSalleGroupe2.stepManager.getInventaire().retirerItem(ItemId.taquinPiece12);
            gagnant = true;

            stoneDrag.setVolume(0.7);
            stoneDrag.play();

            TranslateTransition translateAnimation = new TranslateTransition(Duration.seconds(2.0), taquinAnchor);
            translateAnimation.setByX(-800);
            translateAnimation.play();

            taquinAnchor.setDisable(true);
        }
    }



    public void updateScene (Node node, int i){

        int [] coordonne = taquin.trouverCoordonne(0);
        System.out.println(coordonne[1] +" ; " + coordonne[0]);
        if(taquin.peutDeplacer(i)) {
            GridPane.setConstraints(node, coordonne[1], coordonne[0]);
            new MediaPlayer(listSound[random.nextInt(3)]).play();
            System.out.println("ok2");
        }
    }



    public void recupGemme(MouseEvent mouseEvent) {

        MainSalleGroupe2.stepManager.getInventaire().ajouterItem(ItemId.gemmeBleue);
        gemme.setVisible(false);
    }


}
