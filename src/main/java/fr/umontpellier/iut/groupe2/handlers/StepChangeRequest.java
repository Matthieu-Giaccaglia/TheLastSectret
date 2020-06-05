package fr.umontpellier.iut.groupe2.handlers;

import fr.umontpellier.iut.groupe2.MainSalleGroupe2;
import fr.umontpellier.iut.groupe1.utils.Callback;
import fr.umontpellier.iut.groupe2.view.StepID;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class StepChangeRequest implements EventHandler<ActionEvent> {
    private final StepID next;
    private final Callback callback;

    public StepChangeRequest(StepID next, Callback callback){
        this.next = next;
        this.callback = callback;
    }

    @Override
    public void handle(ActionEvent e) {
        MainSalleGroupe2.stepManager.openStep(next);
        if(callback != null) callback.done();
    }
}
