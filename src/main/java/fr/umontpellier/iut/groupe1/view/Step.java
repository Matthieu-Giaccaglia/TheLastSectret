package fr.umontpellier.iut.groupe1.view;

import fr.umontpellier.iut.commun.data.Layout;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;

public class Step {
    private final StepID id;
    private final Parent node;

    public Step(StepID id, Layout layout) {
        this.id = id;

        node = layout.getRoot();
    }

    private void init(){
        setVisible(true);
    }

    public Parent open(){
        init();
        return node;
    }

    public StepID getId() {
        return id;
    }

    public void setVisible(boolean visible) {
        node.setVisible(visible);
    }
}
