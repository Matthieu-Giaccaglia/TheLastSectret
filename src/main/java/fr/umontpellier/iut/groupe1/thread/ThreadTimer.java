package fr.umontpellier.iut.groupe1.thread;

import javafx.application.Platform;
import javafx.scene.control.Label;

public class ThreadTimer extends Thread implements Runnable{

    private int secondes = 130;
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

        while (!stopped && secondes > 0){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(running){
                if(secondes%60 <10 && secondes%60 > 0){
                    Platform.runLater(() -> label.setText(secondes/60 + ":0" + secondes%60));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else if(secondes == 0 ) {
                    Platform.runLater(() -> label.setText(secondes/60 + ":0" + secondes%60));

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }else {
                    Platform.runLater(() -> label.setText(secondes/60 + ":" + secondes%60));
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
