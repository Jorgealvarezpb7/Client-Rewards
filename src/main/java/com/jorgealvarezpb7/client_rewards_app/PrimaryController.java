package com.jorgealvarezpb7.client_rewards_app;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        System.out.println("Hola Amigs!");
        App.setRoot("secondary");
    }
}
