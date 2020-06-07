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
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.nio.file.Paths;
import java.util.Random;

public class TaquinController {

    @FXML
    private ImageView lastPiece;
    @FXML
    private TextField textLastPiece;
    @FXML
    private GridPane taquinGrid;
    @FXML
    private ImageView gemme;
    @FXML
    private ImageView vingtcinq;
    @FXML
    private ImageView un, deux, trois, quatre, cinq, six, sept, huit, neuf, dix, onze, douze, treize, quatorze, quinze, seize, dixsept, dixhuit, dixneuf, vingt, vingtun, vingtdeux, vingttrois, vingtquatre;

    private final int[][] mat1 = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 0, 24}};
    private final Taquin taquin = new Taquin(mat1);
    private boolean gagnant = false;

    public Media mouv1 = new Media(Paths.get("src/main/resources/raw/groupe2/taquin/mouv1.mp3").toUri().toString());
    public Media mouv2 = new Media(Paths.get("src/main/resources/raw/groupe2/taquin/mouv2.mp3").toUri().toString());
    public Media mouv3 = new Media(Paths.get("src/main/resources/raw/groupe2/taquin/mouv3.mp3").toUri().toString());
    public Media putPiece25 = new Media(Paths.get("src/main/resources/raw/groupe2/taquin/putPiece25.mp3").toUri().toString());
    private Media stoneDrag = new Media(Paths.get("src/main/resources/raw/groupe2/taquin/stoneDrag.mp3").toUri().toString());


    Random random = new Random();
    public Media[] listSound = {mouv1,mouv2,mouv3};


    public void mouvement(MouseEvent event) {

        if (!taquin.estGagnant()) {

            if (event.getSource() == un) {
                updateScene(un, 1);
            } else if (event.getSource() == deux) {
                updateScene(deux, 2);
            } else if (event.getSource() == trois) {
                updateScene(trois, 3);
            } else if (event.getSource() == quatre) {
                updateScene(quatre, 4);
            } else if (event.getSource() == cinq) {
                updateScene(cinq, 5);
            } else if (event.getSource() == six) {
                updateScene(six, 6);
            } else if (event.getSource() == sept) {
                updateScene(sept, 7);
            } else if (event.getSource() == huit) {
                updateScene(huit, 8);
            } else if (event.getSource() == neuf) {
                updateScene(neuf, 9);
            } else if (event.getSource() == dix) {
                updateScene(dix, 10);
            } else if (event.getSource() == onze) {
                updateScene(onze, 11);
            } else if (event.getSource() == douze) {
                updateScene(douze, 12);
            } else if (event.getSource() == treize) {
                updateScene(treize, 13);
            } else if (event.getSource() == quatorze) {
                updateScene(quatorze, 14);
            } else if (event.getSource() == quinze) {
                updateScene(quinze, 15);
            } else if (event.getSource() == seize) {
                updateScene(seize, 16);
            } else if (event.getSource() == dixsept) {
                updateScene(dixsept, 17);
            } else if (event.getSource() == dixhuit) {
                updateScene(dixhuit, 18);
            } else if (event.getSource() == dixneuf) {
                updateScene(dixneuf, 19);
            } else if (event.getSource() == vingt) {
                updateScene(vingt, 20);
            } else if (event.getSource() == vingtun) {
                updateScene(vingtun, 21);
            } else if (event.getSource() == vingtdeux) {
                updateScene(vingtdeux,22);
            } else if (event.getSource() == vingttrois) {
                updateScene(vingttrois,23);
            } else if (event.getSource() == vingtquatre) {
                updateScene(vingtquatre,24);
            }
        } else if (event.getSource() == vingtcinq && MainSalleGroupe2.stepManager.getInventaire().getItemIdSelection() == ItemId.taquinPiece25){
            //new MediaPlayer(putPiece25).play();
            vingtcinq.setImage(ItemId.taquinPiece25.getImage());
            MainSalleGroupe2.stepManager.getInventaire().retirerItem(ItemId.taquinPiece25);
            gagnant = true;
            new MediaPlayer(stoneDrag).play();
            TranslateTransition translateAnimation = new TranslateTransition(Duration.seconds(2.0),taquinGrid);
            //translateAnimation.setCycleCount(TranslateTransition.);
            translateAnimation.setFromX(0);
            translateAnimation.setToX(-400);
            translateAnimation.play();

            taquinGrid.setDisable(true);

        }

        if(vingtcinq.isDisable() && taquin.estGagnant())
            vingtcinq.setDisable(false);
    }




    public void updateScene (Node node, int i){

        int [] coordonne = taquin.trouverCoordonne(0);
        if(taquin.peutDeplacer(i)) {
            GridPane.setConstraints(node, coordonne[1], coordonne[0]);
            new MediaPlayer(listSound[random.nextInt(3)]).play();
        }
    }

    public void recupItem(MouseEvent mouseEvent) {

        MainSalleGroupe2.stepManager.getInventaire().ajouterItem(ItemId.taquinPiece25);
        lastPiece.setVisible(false);
        textLastPiece.setVisible(false);
    }

    public boolean estGagnant(){
        return gagnant;
    }

    public void recupGemme(MouseEvent mouseEvent) {

        MainSalleGroupe2.stepManager.getInventaire().ajouterItem(ItemId.gemmeBleue);
        gemme.setVisible(false);
    }
}
