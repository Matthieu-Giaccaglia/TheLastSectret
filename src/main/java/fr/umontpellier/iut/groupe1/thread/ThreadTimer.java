package fr.umontpellier.iut.groupe1.thread;

import javafx.application.Platform;
import javafx.scene.control.Label;

public class ThreadTimer extends Thread implements Runnable{

    private int secondes;
    private final Label label;
    private boolean running, stopped;
    long now = System.currentTimeMillis(), delta;

    public ThreadTimer(Label label, int secondes){
        this.label = label;
        this.secondes = secondes;

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

                // Tes appels à tout ce que tu veux

                delta = -now + (now = System.currentTimeMillis());
                if(delta < 16){//60 FPS --> environ 16ms par frame
                    try {
                        Thread.sleep(16-delta);
                        now += 16-delta; // ou now = System.currentTimeMillis(), ou n'importe quoi qui fasse le même truc
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                //System.out.println(delta);

                if(secondes%60 <10 && secondes%60 >= 0){
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
        //TODO image momie si pas gagné
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
