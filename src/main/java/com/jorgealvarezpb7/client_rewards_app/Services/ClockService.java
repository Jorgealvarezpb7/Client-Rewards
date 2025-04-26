package com.jorgealvarezpb7.client_rewards_app.Services;

import javafx.application.Platform;
import javafx.scene.control.Label;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ClockService {
    private final Label timeLabel;
    private final Label dateLabel;
    private final SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss a");
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("MMMMM/dd/yyyy");
    private Thread clockThread;

    public ClockService(Label timeLabel, Label dateLabel) {
        this.timeLabel = timeLabel;
        this.dateLabel = dateLabel;
    }

    public void start() {
        clockThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                String currentTime = timeFormat.format(new Date());
                String currentDate = dateFormat.format(new Date());

                Platform.runLater(() -> {
                    timeLabel.setText(currentTime);
                    dateLabel.setText(currentDate);
                });

                try {
                    Thread.sleep(1000); // Actualiza cada segundo
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        clockThread.setDaemon(true);
        clockThread.start();
    }

    public void stop() {
        if (clockThread != null) {
            clockThread.interrupt();
        }
    }
}
