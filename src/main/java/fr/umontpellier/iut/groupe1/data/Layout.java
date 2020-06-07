package fr.umontpellier.iut.groupe1.data;

import javafx.scene.Parent;

public class Layout<T extends Parent> {

    private final T root;
    private final ControllerManagerInventaire controller;

    public Layout(T root, ControllerManagerInventaire controller) {
        this.root = root;
        this.controller = controller;
    }

    public T getRoot() {
        return root;
    }

    public ControllerManagerInventaire getControllerInventaire() {
        return controller;
    }
}
