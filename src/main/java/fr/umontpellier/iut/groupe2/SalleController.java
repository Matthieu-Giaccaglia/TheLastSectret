package fr.umontpellier.iut.groupe2;

import fr.umontpellier.iut.commun.data.LayoutLoader;
import fr.umontpellier.iut.commun.exceptions.LayoutNotFoundException;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SalleController {
    public Button taquinButton;
    public Button lightoutButton;

    public void goEnigme(MouseEvent actionEvent) {
        System.out.println("ok");
    }

    public void setScene(Stage primaryStage){
        primaryStage.setTitle("Escape Game S6");

        Parent root = null;
        try {
            root = LayoutLoader.getLayout("groupe2/layout_main.fxml");
        } catch (LayoutNotFoundException e) {
            e.printStackTrace();
        }

        assert root != null;
        primaryStage.setScene(new Scene(root, 800, 800));
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }
}
