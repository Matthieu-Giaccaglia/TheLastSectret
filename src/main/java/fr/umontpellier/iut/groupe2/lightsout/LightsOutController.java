package fr.umontpellier.iut.groupe2.lightsout;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class LightsOutController {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private GridPane gridPane;
    @FXML
    private ImageView un, deux, trois, quatre, cinq, six, sept, huit, neuf, dix, onze, douze, treize, quatorze, quinze, seize;

    private int[][] tab_lo = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};;
    private LightsOut Lout = new LightsOut(tab_lo);

    void onMouseClicked(MouseEvent event) {

        if (!Lout.estGagnant()) {

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
            }
        }
    }
    public void updateScene (int i, Node node){

        int [] coordonne = Lout.trouverCoordonne(0);
        Lout.lightSwitch(coordonne[0],coordonne[1]);
        GridPane.setConstraints(node, coordonne[1], coordonne[0]);
    }
}
