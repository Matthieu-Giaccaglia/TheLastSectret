package fr.umontpellier.iut.commun.data;

import fr.umontpellier.iut.commun.exceptions.LayoutNotFoundException;
import javafx.scene.Parent;

public class Layout {

    private final Parent root;

    public Layout(String relativePath) throws LayoutNotFoundException {
        root = LayoutLoader.getLayout(relativePath);
    }

    public Parent getRoot() {
        return root;
    }
}
