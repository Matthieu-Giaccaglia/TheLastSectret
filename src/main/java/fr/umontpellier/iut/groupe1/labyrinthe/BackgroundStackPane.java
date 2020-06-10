package fr.umontpellier.iut.groupe1.labyrinthe;

import fr.umontpellier.iut.groupe1.data.ImageLoader;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.StackPane;


public class BackgroundStackPane extends StackPane {

    public BackgroundStackPane(Group group){

        this.setBackground(new javafx.scene.layout.Background(new BackgroundImage(ImageLoader.getImage("groupe1/wall_15.jpg"), null, null, null, null)));
        this.getChildren().addAll( group);

    }

    public BackgroundStackPane(Group group, double width, double height){

        ImageView image = new ImageView(ImageLoader.getImage("groupe1/wall_15.jpg"));
        image.setFitWidth(width);
        image.setFitHeight(height);
        this.getChildren().addAll(image, group);
    }

    public BackgroundStackPane(Group group, double widthImageFond, double heightImageFond, double widthBackground, double heightBackground){
        ImageView fondNoir = new ImageView(ImageLoader.getImage("groupe1/noir2.jpg"));
        fondNoir.setFitWidth(widthBackground);
        fondNoir.setFitHeight(heightBackground);
        fondNoir.setOpacity(0.8);
        ImageView image = new ImageView(ImageLoader.getImage("groupe1/wall_15.jpg"));
        image.setFitWidth(widthImageFond);
        image.setFitHeight(heightImageFond);
        this.getChildren().addAll(fondNoir, image, group);
    }
}
