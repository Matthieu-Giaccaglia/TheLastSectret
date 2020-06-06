package fr.umontpellier.iut.groupe2.taquin;


import fr.umontpellier.iut.groupe1.thread.ThreadTimer;
import fr.umontpellier.iut.groupe2.MainSalleGroupe2;
import fr.umontpellier.iut.groupe2.handlers.StepChangeRequest;
import fr.umontpellier.iut.groupe2.inventaire.ItemId;
import fr.umontpellier.iut.groupe2.view.StepID;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class TaquinController {



    @FXML
    private ImageView vingtcinq;
    @FXML
    private ImageView un, deux, trois, quatre, cinq, six, sept, huit, neuf, dix, onze, douze, treize, quatorze, quinze, seize, dixsept, dixhuit, dixneuf, vingt, vingtun, vingtdeux, vingttrois, vingtquatre;

    private final int[][] mat1 = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 0, 24}};
    private final Taquin taquin = new Taquin(mat1);

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
            vingtcinq.setImage(ItemId.taquinPiece25.getImage());
            MainSalleGroupe2.stepManager.getInventaire().retirerItem(ItemId.taquinPiece25);
        }

        if(vingtcinq.isDisable() && taquin.estGagnant())
            vingtcinq.setDisable(false);
    }




    public void updateScene (Node node, int i){

        int [] coordonne = taquin.trouverCoordonne(0);
        if(taquin.peutDeplacer(i)) {
            GridPane.setConstraints(node, coordonne[1], coordonne[0]);
        }
    }

    public void recupItem(MouseEvent mouseEvent) {

        MainSalleGroupe2.stepManager.getInventaire().ajouterItem(ItemId.taquinPiece25);
        MainSalleGroupe2.stepManager.getInventaire().ajouterItem(ItemId.taquinPiece24);
        MainSalleGroupe2.stepManager.getInventaire().ajouterItem(ItemId.taquinPiece23);

    }
}
