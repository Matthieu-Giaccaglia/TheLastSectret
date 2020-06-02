package fr.umontpellier.iut.groupe2.lightsout;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
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
}
