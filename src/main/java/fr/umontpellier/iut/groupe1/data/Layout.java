package fr.umontpellier.iut.groupe1.data;

import javafx.scene.Parent;

public class Layout<T extends Parent> {

    private final T root;
    private final ControllerManagerInventaire controller;
    private final Openable openable;

    public Layout(T root, ControllerManagerInventaire controller, Openable openable) {
        this.root = root;
        this.controller = controller;
        this.openable = openable;
    }

    public Layout(T root, ControllerManagerInventaire controller) {
        this(root, controller, null);
    }

    /*public Layout(T root, Openable openable) {
        this(root, null, openable);
    }*/

    public T getRoot() {
        return root;
    }

    public ControllerManagerInventaire getControllerInventaire() {
        return controller;
    }

    public Openable getOpenable(){
        return openable;
    }
}
