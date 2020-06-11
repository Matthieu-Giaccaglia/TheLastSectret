package fr.umontpellier.iut.groupe2.lightsout;

import fr.umontpellier.iut.groupe2.MainSalleGroupe2;
import fr.umontpellier.iut.groupe2.inventaire.ItemId;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.nio.file.Paths;

public class LightsOutController {
    public AnchorPane anchorPane;
    @FXML
    private GridPane gridMain;//à utiliser(coordonnés à changer) car tab marche pas
    @FXML
    private ImageView un, deux, trois, quatre, cinq, six, sept, huit, neuf, dix, onze, douze, treize, quatorze, quinze, seize, buttonBrick;

    private final int[][] tab_lo = {{1,0,0,0},{0,0,1,0},{0,1,0,0},{0,0,0,1}};
    private final LightsOut Lout = new LightsOut(tab_lo);
    private boolean aGagne = false;
    public Media bricksound = new Media(Paths.get("src/main/resources/sound/groupe2/lightsout/brick.mp3").toUri().toString());

    public void light_switch(MouseEvent event) {
        if (!Lout.estGagnant()) {
            if (event.getSource() == un) {
                updateScene(0, un);
            } else if (event.getSource() == deux) {
                updateScene(1, deux);
            } else if (event.getSource() == trois) {
                updateScene(2, trois);
            } else if (event.getSource() == quatre) {
                updateScene(3, quatre);
            } else if (event.getSource() == cinq) {
                updateScene(4, cinq);
            } else if (event.getSource() == six) {
                updateScene(5, six);
            } else if (event.getSource() == sept) {
                updateScene(6, sept);
            } else if (event.getSource() == huit) {
                updateScene(7, huit);
            } else if (event.getSource() == neuf) {
                updateScene(8, neuf);
            } else if (event.getSource() == dix) {
                updateScene(9, dix);
            } else if (event.getSource() == onze) {
                updateScene(10, onze);
            } else if (event.getSource() == douze) {
                updateScene(11, douze);
            } else if (event.getSource() == treize) {
                updateScene(12, treize);
            } else if (event.getSource() == quatorze) {
                updateScene(13, quatorze);
            } else if (event.getSource() == quinze) {
                updateScene(14, quinze);
            } else if (event.getSource() == seize) {
                updateScene(15, seize);
            }
        }
        if(Lout.estGagnant() && !aGagne){
            buttonBrick.setOpacity(1);
            buttonBrick.setDisable(false);
            ParallelTransition brickMove;
            brickMove = animationClique(buttonBrick);
            brickMove.play();
        }
    }
    public void finished(){
        if(Lout.estGagnant() && !aGagne) {
            MainSalleGroupe2.stepManager.getInventaire().ajouterItem(ItemId.boutonLumiere);
            buttonBrick.setVisible(false);
            aGagne = true;
        }
    }

    public void updateScene (int i, ImageView img){
        int [] coordonne = Lout.trouverCoordonne(i);
        Lout.onClick(coordonne[0],coordonne[1]);
        /*System.out.println(Lout.toString());
        System.out.println(gridMain.getChildren());
        System.out.println(GridPane.getRowIndex(img));
        System.out.println(GridPane.getColumnIndex(img));*/
        new MediaPlayer(bricksound).play();
        if(GridPane.getColumnIndex(img)==null||GridPane.getRowIndex(img)==null){
            if(GridPane.getColumnIndex(img)==null&&GridPane.getRowIndex(img)==null){
                imgsSwitch(0,0);
            }else if(GridPane.getColumnIndex(img)==null){
                imgsSwitch(0,GridPane.getRowIndex(img));
            }else{
                imgsSwitch(GridPane.getColumnIndex(img),0);
            }
        }else {
            imgsSwitch(GridPane.getColumnIndex(img), GridPane.getRowIndex(img));
        }
    }

    private void imgsSwitch(int pos_i, int pos_j) {//update scene
        int max_i = tab_lo.length - 1;
        int max_j = tab_lo[0].length - 1;
        int i_grid;//car 0 dans grid = null
        int j_grid;

        for (Node node : gridMain.getChildren()) {

            if(GridPane.getColumnIndex(node)==null||GridPane.getRowIndex(node)==null){
                if(GridPane.getColumnIndex(node)==null&&GridPane.getRowIndex(node)==null){
                    i_grid = 0;
                    j_grid = 0;
                }else if(GridPane.getColumnIndex(node)==null){
                    i_grid = 0;
                    j_grid = GridPane.getRowIndex(node);
                }else{
                    i_grid = GridPane.getColumnIndex(node);
                    j_grid = 0;
                }
            }else{
                i_grid = GridPane.getColumnIndex(node);
                j_grid = GridPane.getRowIndex(node);
            }

            if (i_grid == pos_i && j_grid == pos_j) {
                if (pos_i == 0){//barre haut
                    if(pos_j == 0){//gauche
                        imgSwitch(pos_i,pos_j);
                        imgSwitch(pos_i+1,pos_j);
                        imgSwitch(pos_i,pos_j+1);
                    }else if(pos_j == max_j){//droite
                        imgSwitch(pos_i,pos_j);
                        imgSwitch(pos_i+1,pos_j);
                        imgSwitch(pos_i,pos_j-1);
                    } else{//milieu
                        imgSwitch(pos_i,pos_j);
                        imgSwitch(pos_i,pos_j+1);
                        imgSwitch(pos_i+1,pos_j);
                        imgSwitch(pos_i,pos_j-1);
                    }
                }else if(pos_i == max_i){//barre bas
                    if(pos_j == 0){//gauche
                        imgSwitch(pos_i,pos_j);
                        imgSwitch(pos_i-1,pos_j);
                        imgSwitch(pos_i,pos_j+1);
                    }else if(pos_j == max_j){//droite
                        imgSwitch(pos_i,pos_j);
                        imgSwitch(pos_i-1,pos_j);
                        imgSwitch(pos_i,pos_j-1);
                    } else{//milieu
                        imgSwitch(pos_i,pos_j);
                        imgSwitch(pos_i,pos_j+1);
                        imgSwitch(pos_i-1,pos_j);
                        imgSwitch(pos_i,pos_j-1);
                    }
                }else{//barres milieu
                    if(pos_j == 0){//gauche
                        imgSwitch(pos_i,pos_j);
                        imgSwitch(pos_i-1,pos_j);
                        imgSwitch(pos_i+1,pos_j);
                        imgSwitch(pos_i,pos_j+1);
                    }else if(pos_j == max_j){//droite
                        imgSwitch(pos_i,pos_j);
                        imgSwitch(pos_i-1,pos_j);
                        imgSwitch(pos_i+1,pos_j);
                        imgSwitch(pos_i,pos_j-1);
                    } else{//milieu
                        imgSwitch(pos_i,pos_j);
                        imgSwitch(pos_i-1,pos_j);
                        imgSwitch(pos_i+1,pos_j);
                        imgSwitch(pos_i,pos_j-1);
                        imgSwitch(pos_i,pos_j+1);
                    }
                }
            }
        }
    }

    public void imgSwitch(int i, int j){
        int i_grid;//car 0 grid = null
        int j_grid;
        ParallelTransition brickMove;
        for (Node node : gridMain.getChildren()) {
            if(GridPane.getColumnIndex(node)==null||GridPane.getRowIndex(node)==null){
                if(GridPane.getColumnIndex(node)==null&&GridPane.getRowIndex(node)==null){
                    i_grid = 0;
                    j_grid = 0;
                }else if(GridPane.getColumnIndex(node)==null){
                    i_grid = 0;
                    j_grid = GridPane.getRowIndex(node);
                }else{
                    i_grid = GridPane.getColumnIndex(node);
                    j_grid = 0;
                }
            }else{
                i_grid = GridPane.getColumnIndex(node);
                j_grid = GridPane.getRowIndex(node);
            }
            if (i_grid == i && j_grid == j) {
                //node off
                //si node on
                node.setDisable(!node.isDisable());
                brickMove = animationClique(node);
                brickMove.play();
            }
        }
    }
    /*
    public void createKeyframe(){}
    public void shakeEffect{

    }
    */
    public ParallelTransition animationClique(Node idBrick){
        if(idBrick.isDisable()) {
            ScaleTransition scaleBrick = new ScaleTransition(Duration.seconds(0.2), idBrick);
            scaleBrick.setByX(-0.1);
            scaleBrick.setByY(-0.1);
            FadeTransition fadeBrick = new FadeTransition(Duration.seconds(0.2), idBrick);
            fadeBrick.setByValue(-0.5);

            return new ParallelTransition(fadeBrick, scaleBrick);
        }else{
            ScaleTransition scaleBrick = new ScaleTransition(Duration.seconds(0.2), idBrick);
            scaleBrick.setByX(0.1);
            scaleBrick.setByY(0.1);
            FadeTransition fadeBrick = new FadeTransition(Duration.seconds(0.2), idBrick);
            fadeBrick.setByValue(0.5);

            return new ParallelTransition(fadeBrick, scaleBrick);
        }
    }

}
