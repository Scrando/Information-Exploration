/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informationexploration;

import javafx.application.Platform;
import javafx.application.Preloader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 * Simple Preloader Using progress notifications from database extraction
 *
 * @author Nathaniel Groenewold;
 */
public class NobelPreload extends Preloader {
    
    //Preloader specs
    private static final double WIDTH = 400;
    private static final double HEIGHT = 400;

    private Stage preloaderStage;
    private Scene scene;

    private Label progress;
    
    @Override
    public void init() throws Exception {

        // Preload initialization
        Platform.runLater(() -> {
            Label title = new Label("Extracting Nobel Database!\nLoading, please wait...");
            title.setTextAlignment(TextAlignment.CENTER);
            progress = new Label("0%");

            VBox root = new VBox(title, progress);
            root.setAlignment(Pos.CENTER);

            scene = new Scene(root, WIDTH, HEIGHT);
        });
    }
    
    //preload runtime
    @Override
    public void start(Stage primaryStage) throws Exception {

        // Set preloader scene and show stage.
        this.preloaderStage = primaryStage;
        preloaderStage.setScene(scene);
        preloaderStage.show();
    }
    
    //handle notifications to change progress
    @Override
    public void handleApplicationNotification(PreloaderNotification info) {
        if (info instanceof ProgressNotification) {
            progress.setText(((ProgressNotification) info).getProgress() + "%");
        }
    }
}
