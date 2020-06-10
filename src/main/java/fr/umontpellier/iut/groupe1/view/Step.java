package fr.umontpellier.iut.groupe1.view;

import fr.umontpellier.iut.groupe1.data.Layout;
import fr.umontpellier.iut.groupe1.utils.Callback;
import javafx.scene.Parent;

public class Step<T extends Parent> {
    private final StepID id;
    private final T node;
    private Callback onStart;

    public Step(StepID id, Layout<T> layout) {
        this.id = id;

        node = layout.getRoot();
    }

    private void init(){
        setVisible(true);
        if(onStart != null) onStart.done();
    }

    public T open(){
        init();
        return node;
    }

    public void setOnStart(Callback onStart){
        this.onStart = onStart;
    }

    public StepID getId() {
        return id;
    }

    public void setVisible(boolean visible) {
        node.setVisible(visible);
    }
}
