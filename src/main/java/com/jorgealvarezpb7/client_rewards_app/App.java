package com.jorgealvarezpb7.client_rewards_app;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

import com.jorgealvarezpb7.client_rewards_app.Services.Authenticated;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("Views/Auth/template"), 1024, 600);
        stage.setTitle("Puntos y Descuentos");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        Platform.runLater(() -> {
            stage.show();
            Image image = new Image(App.class.getResource("Images/logoApp.png").toString());
            stage.getIcons().add(image);
        });
    }
    public static void setRoot(String fxml) throws IOException {
        Authenticated.getInstance();
        scene.setRoot(loadFXML(fxml));
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch(args);
    }

}