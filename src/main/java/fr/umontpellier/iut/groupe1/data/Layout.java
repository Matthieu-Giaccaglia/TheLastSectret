package fr.umontpellier.iut.groupe1.data;

import javafx.scene.Parent;

public class Layout<T extends Parent> {

    private final T root;
    private final ControllerManager controller;

    public Layout(T root, ControllerManager controller) {
        this.root = root;
        this.controller = controller;
    }

    public T getRoot() {
        return root;
    }

    public ControllerManager getController() {
        return controller;
    }
}
