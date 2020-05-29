package fr.umontpellier.iut.groupe2.taquin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Controller {

    private int[][] mat1 ={{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,0}};
    private Taquin taquin = new Taquin(mat1);

    @FXML
    private ImageView un, deux, trois, quatre, cinq, six, sept, huit, neuf, dix, onze, douze, treize, quatorze, quinze, seize, dixsept, dixhuit, dixneuf, vingt, vingtun, vingtdeux, vingttrois, vingtquatre;

    public void mouvement(MouseEvent event) {
        System.out.println("ok");

        if (event.getSource() == un){
            taquin.deplacer(1);
        } else if (event.getSource() == deux){
            taquin.deplacer(2);
        } else if (event.getSource() == trois){
            taquin.deplacer(3);
        } else if (event.getSource() == quatre){
            taquin.deplacer(4);
        } else if (event.getSource() == cinq){
            taquin.deplacer(5);
        } else if (event.getSource() == six){
            taquin.deplacer(6);
        } else if (event.getSource() == sept){
            taquin.deplacer(7);
        } else if (event.getSource() == huit){
            taquin.deplacer(8);
        } else if (event.getSource() == neuf){
            taquin.deplacer(9);
        } else if (event.getSource() == dix){
            taquin.deplacer(10);
        } else if (event.getSource() == onze){
            taquin.deplacer(11);
        } else if (event.getSource() == douze){
            taquin.deplacer(12);
        } else if (event.getSource() == treize){
            taquin.deplacer(13);
        } else if (event.getSource() == quatorze){
            taquin.deplacer(14);
        } else if (event.getSource() == quinze){
            taquin.deplacer(15);
        } else if (event.getSource() == seize){
            taquin.deplacer(16);
        } else if (event.getSource() == dixsept){
            taquin.deplacer(17);
        } else if (event.getSource() == dixhuit){
            taquin.deplacer(18);
        } else if (event.getSource() == dixneuf){
            taquin.deplacer(19);
        } else if (event.getSource() == vingt){
            taquin.deplacer(20);
        } else if (event.getSource() == vingtun){
            taquin.deplacer(21);
        } else if (event.getSource() == vingtdeux){
            taquin.deplacer(22);
        } else if (event.getSource() == vingttrois){
            taquin.deplacer(23);
        } else if (event.getSource() == vingtquatre){
            taquin.deplacer(24);
        }
    }
}
