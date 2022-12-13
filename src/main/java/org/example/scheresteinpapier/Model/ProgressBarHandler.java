/*-----------------------------------------------------------------------------
 *              Hoehere Technische Bundeslehranstalt STEYR
 *----------------------------------------------------------------------------*/
/**
 * Kurzbeschreibung
 *
 * @author  : Dino Kupinic, Max Wöss
 * @date    : 13.12.2022
 *
 * @details
 *   Class to handle the progress bar
 */

package org.example.scheresteinpapier.Model;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.control.ProgressBar;
import org.example.scheresteinpapier.Controller.SSPController;

public class ProgressBarHandler extends Thread {
    /**
     * create a new thread and load the progress bar
     * @param bar the FXML progress bar
     */
    public void loadProgressBar(ProgressBar bar, SSPController controller) {
        final Task<Void> task = new Task<>() {
            final int ITERATIONS = 100;
            @Override
            protected Void call() throws Exception {
                controller.disablePickButtonOnRoundEnd();
                for (int i = 0; i < ITERATIONS; i++) {
                    updateProgress(i + 1, ITERATIONS);
                    Thread.sleep(5);
                }
                Platform.runLater(() -> {
                    controller.showResult();
                    controller.updateScore();
                });
                return null;
            }
        };

        bar.progressProperty().bind(task.progressProperty());

        final Thread thread = new Thread(task, "task-thread");
        thread.setDaemon(true);
        thread.start();
    }
}
