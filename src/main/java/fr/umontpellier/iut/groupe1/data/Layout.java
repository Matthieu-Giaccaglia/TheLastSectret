package fr.umontpellier.iut.groupe1.data;

import javafx.scene.Parent;

public class Layout<T extends Parent> {

    private final T root;
    private final ControllerManagerInventaire controller;
    private final Controller control;

    public Layout(T root, ControllerManagerInventaire controller, Controller control) {
        this.root = root;
        this.controller = controller;
        this.control = control;
    }

    public Layout(T root, ControllerManagerInventaire controller) {
        this(root, controller, null);
    }

    public T getRoot() {
        return root;
    }

    public ControllerManagerInventaire getControllerInventaire() {
        return controller;
    }

    public Controller getController(){
        return control;
    }
}
