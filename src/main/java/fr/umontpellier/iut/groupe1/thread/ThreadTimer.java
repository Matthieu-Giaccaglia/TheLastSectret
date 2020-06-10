package fr.umontpellier.iut.groupe1.thread;


import javafx.application.Platform;
import javafx.scene.control.Label;

public class ThreadTimer extends Thread implements Runnable{

    private int secondes = 20, minutes = 5;
    private final Label label;
    private boolean running;

    public ThreadTimer(Label label){
        this.label = label;

        running = false;
    }

    @Override
    public synchronized void start() {
        super.start();
        running = true;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public synchronized void run() {
        super.run();

        while (running && minutes > -1){

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
