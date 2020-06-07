package fr.umontpellier.iut.groupe1.thread;


import javafx.application.Platform;
import javafx.scene.control.Label;

public class ThreadTimer implements Runnable{

    private int secondes = 20, minutes = 5;
    private final Label label;

    public ThreadTimer(Label label){
        this.label = label;
    }

    @Override
    public synchronized void run() {

        while (minutes > -1){

            if(secondes<10 && secondes > 0){
                Platform.runLater(() -> label.setText(minutes + ":0" + secondes));
                try {
                    this.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else if(secondes == 0 ) {
                Platform.runLater(() -> label.setText(minutes + ":0" + secondes));

                try {
                    this.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                minutes--;
                secondes = 60;
            }else {
                Platform.runLater(() -> label.setText(minutes + ":" + secondes));
                try {
                    this.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            secondes--;
        }
    }
}
