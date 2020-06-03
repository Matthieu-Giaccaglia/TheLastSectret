package fr.umontpellier.iut.groupe1.data;

import javafx.scene.Parent;

public class Layout<T extends Parent> {

    private final T root;

    public Layout(T root) {
        this.root = root;
    }

    public T getRoot() {
        return root;
    }
}
