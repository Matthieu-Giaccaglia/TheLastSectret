package fr.umontpellier.iut.groupe1.view;

import fr.umontpellier.iut.groupe1.data.Layout;
import fr.umontpellier.iut.groupe1.data.Openable;
import fr.umontpellier.iut.groupe1.utils.Callback;
import javafx.scene.Parent;

public class Step<T extends Parent> {
    private final Layout<T> layout;
    private final StepID id;

    public Step(StepID id, Layout<T> layout) {
        this.id = id;
        this.layout = layout;
    }

    private void init(){
        setVisible(true);
        //if(layout.getController() != null && layout.getController() instanceof Openable) ((Openable) layout.getController()).open();
    }

    public T open(){
        init();
        return layout.getRoot();
    }

    public Layout<T> getLayout() {
        return layout;
    }

    public StepID getId() {
        return id;
    }

    public void setVisible(boolean visible) {
        layout.getRoot().setVisible(visible);
    }
}
