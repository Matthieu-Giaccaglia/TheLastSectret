package fr.umontpellier.iut.groupe2.taquin;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class TaquinController {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private GridPane gridPane;
    @FXML
    private ImageView un, deux, trois, quatre, cinq, six, sept, huit, neuf, dix, onze, douze, treize, quatorze, quinze, seize, dixsept, dixhuit, dixneuf, vingt, vingtun, vingtdeux, vingttrois, vingtquatre;

    private int[][] mat1 = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 0, 24}};
    private Taquin taquin = new Taquin(mat1);

    public void mouvement(MouseEvent event) {

        if (!taquin.estGagnant()) {

            if (event.getSource() == un) {
                updateScene(1, un);
            } else if (event.getSource() == deux) {
                updateScene(2, deux);
            } else if (event.getSource() == trois) {
                updateScene(3, trois);
            } else if (event.getSource() == quatre) {
                updateScene(4, quatre);
            } else if (event.getSource() == cinq) {
                updateScene(5, cinq);
            } else if (event.getSource() == six) {
                updateScene(6, six);
            } else if (event.getSource() == sept) {
                updateScene(7, sept);
            } else if (event.getSource() == huit) {
                updateScene(8, huit);
            } else if (event.getSource() == neuf) {
                updateScene(9, neuf);
            } else if (event.getSource() == dix) {
                updateScene(10, dix);
            } else if (event.getSource() == onze) {
                updateScene(11, onze);
            } else if (event.getSource() == douze) {
                updateScene(12, douze);
            } else if (event.getSource() == treize) {
                updateScene(13, treize);
            } else if (event.getSource() == quatorze) {
                updateScene(14, quatorze);
            } else if (event.getSource() == quinze) {
                updateScene(15, quinze);
            } else if (event.getSource() == seize) {
                updateScene(16, seize);
            } else if (event.getSource() == dixsept) {
                updateScene(17, dixsept);
            } else if (event.getSource() == dixhuit) {
                updateScene(18, dixhuit);
            } else if (event.getSource() == dixneuf) {
                updateScene(19, dixneuf);
            } else if (event.getSource() == vingt) {
                updateScene(20, vingt);
            } else if (event.getSource() == vingtun) {
                updateScene(21, vingtun);
            } else if (event.getSource() == vingtdeux) {
                updateScene(22, vingtdeux);
            } else if (event.getSource() == vingttrois) {
                updateScene(23, vingttrois);
            } else if (event.getSource() == vingtquatre) {
                updateScene(24, vingtquatre);
            }
        }
    }




    public void updateScene (int i, Node node){
        int [] coordonne = taquin.trouverCoordonne(0);
        if(taquin.peutDeplacer(i)) {
            GridPane.setConstraints(node, coordonne[1], coordonne[0]);
        }

    }
}
