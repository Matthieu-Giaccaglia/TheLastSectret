package fr.umontpellier.iut.groupe2.lightsout;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.HashMap;

public class LightsOutController {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private GridPane gridPane;
    @FXML
    private ImageView un, deux, trois, quatre, cinq, six, sept, huit, neuf, dix, onze, douze, treize, quatorze, quinze, seize;
    @FXML
    private ImageView[] tab_imgView = {un, deux, trois, quatre, cinq, six, sept, huit, neuf, dix, onze, douze, treize, quatorze, quinze, seize};

    private int[][] tab_lo = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
    private LightsOut Lout = new LightsOut(tab_lo);
    private static HashMap<Integer, String> Tab_ID;

    static {
        Tab_ID = new HashMap<>();

        Tab_ID.put(0,"un");
        Tab_ID.put(1,"deux");
        Tab_ID.put(2,"trois");
        Tab_ID.put(3,"quatre");

        Tab_ID.put(4,"cinq");
        Tab_ID.put(5,"six");
        Tab_ID.put(6,"sept");
        Tab_ID.put(7,"huit");

        Tab_ID.put(8,"neuf");
        Tab_ID.put(9,"dix");
        Tab_ID.put(10,"onze");
        Tab_ID.put(11,"douze");

        Tab_ID.put(12,"treize");
        Tab_ID.put(13,"quatorze");
        Tab_ID.put(14,"quinze");
        Tab_ID.put(15,"seize");
    }

    public static String getTabString(int num_id) {
        return Tab_ID.get(num_id);
    }

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
    }
    public void updateScene (int i, ImageView img){
        int [] coordonne = Lout.trouverCoordonne(i);
        Lout.onClick(coordonne[0],coordonne[1]);
        System.out.println(Lout.toString());
        for(int j = 0; j< Lout.getTableau().length; j++) {
            for (int k=0; k<Lout.getTableau()[0].length; k++){
                if (Lout.getTableau()[j][k] == 1) {
                    if(compare(j,k)) {
                        tab_imgView[j+k].setImage(new Image("https://media-exp1.licdn.com/dms/image/C560BAQHMnA03XDdf3w/company-logo_200_200/0?e=2159024400&v=beta&t=C7KMOtnrJwGrMXmgIk2u1B8a7VRfgxMwXng9cdP9kZk"));
                    }
                }
                else{
                    if(compare(j,k)) {
                        tab_imgView[j+k].setImage(new Image("https://i.pinimg.com/236x/c4/b8/22/c4b822d890fe6d90358f5e2f2561cd56.jpg"));
                    }
                }
            }
        }
    }
    public boolean compare(int i_tabid,int j_tabid){
        for(int i = 0; i<Lout.getTableau().length;i++){
            for(int j = 0; j<Lout.getTableau()[0].length;j++) {
                System.out.println(LightsOutController.getTabString(LightsOut.getID(i_tabid, j_tabid)));
                System.out.println(j);
                System.out.println(i);
                System.out.println(tab_imgView[j + i]);
                if (LightsOutController.getTabString(LightsOut.getID(i_tabid, j_tabid)).equals(tab_imgView[j + i].getId())){
                    return true;
                }
            }
        }
        return false;
    }
}
