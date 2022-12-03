package org.example.scheresteinpapier.Model;

import javafx.scene.control.ProgressBar;

public class ProgressBarHandler extends Thread {
    static double barFill = 0.0;

    static Thread myThread = new Thread();

    public static void loadProgressBar(ProgressBar bar) throws InterruptedException {
        for (int i = 0; i <= 10; i++) {
            barFill += 0.10;
            bar.setProgress(barFill);
            myThread.sleep(5);
        }
    }
}
