package fr.umontpellier.iut.groupe2.view;

import fr.umontpellier.iut.groupe1.data.Layout;
import javafx.scene.Parent;

public class Step<T extends Parent> {
    private final StepID id;
    private final T node;

    public Step(StepID id, Layout<T> layout) {
        this.id = id;

        node = layout.getRoot();
    }

    private void init(){
        setVisible(true);
    }

    public T open(){
        init();
        return node;
    }

    public StepID getId() {
        return id;
    }

    public void setVisible(boolean visible) {
        node.setVisible(visible);
    }

    public void addChildren(){
        
    }
}
