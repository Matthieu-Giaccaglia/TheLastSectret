package fr.umontpellier.iut.groupe1.thread;


import javafx.scene.control.Label;

public class ThreadTimer implements Runnable{

    private int secondes = 0;
    private Label label;

    public ThreadTimer(Label label){
        this.label = label;
    }

    @Override
    public synchronized void run() {

        int minutes = 5;
        //while (minutes > -1){  }
        label.setText(minutes + ":" + secondes);
        System.out.println("ici");

        try {
            this.wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        secondes--;

        //label.setText(minutes + ":" + secondes);
        System.out.println(label.getText());
    }
}
