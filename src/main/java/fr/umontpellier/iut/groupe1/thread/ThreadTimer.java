package fr.umontpellier.iut.groupe1.thread;

import fr.umontpellier.iut.Main;
import fr.umontpellier.iut.groupe1.view.StepID;
import javafx.application.Platform;
import javafx.scene.control.Label;

public class ThreadTimer extends Thread implements Runnable{

    private int secondes;
    private final Label label;
    private boolean running, stopped;

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

        while (!stopped && secondes >= 0){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(running){

                //System.out.println(delta);

                if(secondes%60 <10 && secondes%60 >= 0){
                    Platform.runLater(() -> label.setText(secondes/60 + ":0" + secondes%60));
                }else {
                    Platform.runLater(() -> label.setText(secondes/60 + ":" + secondes%60));
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                secondes--;
            }

        }

        Platform.runLater(() -> Main.stepManager.openStep(StepID.GAMEOVER));
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
