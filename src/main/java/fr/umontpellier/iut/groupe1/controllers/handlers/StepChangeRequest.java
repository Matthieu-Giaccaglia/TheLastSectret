package fr.umontpellier.iut.groupe1.controllers.handlers;

import fr.umontpellier.iut.groupe1.Main;
import fr.umontpellier.iut.groupe1.utils.Callback;
import fr.umontpellier.iut.groupe1.view.StepID;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javax.annotation.Nullable;

public class StepChangeRequest implements EventHandler<ActionEvent> {
    private final StepID next;
    private final Callback callback;

    public StepChangeRequest(StepID next, @Nullable Callback callback){
        this.next = next;
        this.callback = callback;
    }

    @Override
    public void handle(ActionEvent e) {
        Main.stepManager.openStep(next);
        if(callback != null) callback.done();
    }
}
