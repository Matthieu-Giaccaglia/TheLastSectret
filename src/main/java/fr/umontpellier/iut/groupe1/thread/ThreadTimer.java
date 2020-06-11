package fr.umontpellier.iut.groupe1.thread;

import javafx.application.Platform;
import javafx.scene.control.Label;

public class ThreadTimer extends Thread implements Runnable{

    private int secondes = 20, minutes = 5;
    private final Label label;
    private boolean running, stopped;

    public ThreadTimer(Label label){
        this.label = label;

        running = false;
        stopped = false;
    }

    @Override
    public synchronized void start() {
        super.start();
    }

    @Override
    public synchronized void run() {
        super.run();

        while (!stopped && minutes > -1){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(running){
                if(secondes<10 && secondes > 0){
                    Platform.runLater(() -> label.setText(minutes + ":0" + secondes));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else if(secondes == 0 ) {
                    Platform.runLater(() -> label.setText(minutes + ":0" + secondes));

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    minutes--;
                    secondes = 60;
                }else {
                    Platform.runLater(() -> label.setText(minutes + ":" + secondes));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                secondes--;
            }
        }
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public boolean isStopped() {
        return stopped;
    }

    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }
}
