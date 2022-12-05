/*-----------------------------------------------------------------------------
 *              Hoehere Technische Bundeslehranstalt STEYR
 *----------------------------------------------------------------------------*/
/**
 * Kurzbeschreibung
 *
 * @author  : Dino Kupinic, Max Wöss
 * @date    : 4.12.2022
 *
 * @details
 *   Class to handle the progress bar
 */

package org.example.scheresteinpapier.Model;

import javafx.concurrent.Task;
import javafx.scene.control.ProgressBar;

import java.util.Date;

public class ProgressBarHandler extends Thread {
    public static boolean isDone = false;
    public void loadProgressBar(ProgressBar bar) {
        final Task<Void> task = new Task<>() {
            final int ITERNATIONS = 100;

            @Override
            protected Void call() throws Exception {
                Date startDate = new Date();
                for (int i = 0; i < ITERNATIONS; i++) {
                    updateProgress(i + 1, ITERNATIONS);
                    Thread.sleep(10);
                }
                Date endDate = new Date();
                int seconds = getTimePassed(startDate, endDate);
                if (seconds == 1) isDone = true;
                return null;
            }

        };

        bar.progressProperty().bind(task.progressProperty());

        final Thread thread = new Thread(task, "task-thread");
        thread.setDaemon(true);
        thread.start();
    }

    private static int getTimePassed(Date startDate, Date endDate) {
        return (int)((endDate.getTime() - startDate.getTime()) / 1000);
    }
}
