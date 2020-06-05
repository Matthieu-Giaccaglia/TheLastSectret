package fr.umontpellier.iut.groupe1.Labyrinthe;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage){
        double width = 1000, height = 900;
        //initMouseControl(labyrinthe, jeuLabyrinthe, primaryStage);
        JeuLabyrinthe jeuLabyrinthe = new JeuLabyrinthe(new StructureLabyrinthe(width / 2, height / 2, primaryStage),width, height);

        primaryStage.setTitle("Labyrinthe");
        primaryStage.setScene(jeuLabyrinthe);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    /*private double anchorX, anchorY, anchorAngleX = 0, anchorAngleY = 0;
    private final DoubleProperty angleX = new SimpleDoubleProperty(0), angleY = new SimpleDoubleProperty(0);

    public void initMouseControl(Group group, Scene scene, Stage stage){
        Rotate xRotate;
        Rotate yRotate;

        group.getTransforms().addAll(
                xRotate = new Rotate(0, Rotate.X_AXIS),
                yRotate = new Rotate(0, Rotate.Y_AXIS)
        );
        xRotate.angleProperty().bind(angleX);
        yRotate.angleProperty().bind(angleY);

        scene.setOnMousePressed(mouseEvent -> {
            anchorX = mouseEvent.getSceneX();
            anchorY = mouseEvent.getSceneY();
            anchorAngleX = angleX.get();
            anchorAngleY = angleY.get();
        });

        scene.setOnMouseDragged(mouseEvent -> {
            angleX.set(anchorAngleX - (anchorY - mouseEvent.getSceneY()));
            angleY.set(anchorAngleY + anchorX - mouseEvent.getSceneX());
        });

        stage.addEventHandler(ScrollEvent.SCROLL, scrollEvent -> {
            double delta = scrollEvent.getDeltaY();
            group.translateZProperty().set(group.getTranslateZ() + delta );
        });
    }*/
}
