package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // This line loads the main window layout from the "CurrencyConverterUI.fxml" file.
        // It's like taking the design blueprint from the file to show on the screen.
        Parent root = FXMLLoader.load(getClass().getResource("CurrencyConverterUI.fxml"));

        Scene scene = new Scene(root);
        primaryStage.setTitle("Currency Converter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}