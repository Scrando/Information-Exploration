/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informationexploration;

import com.sun.javafx.application.LauncherImpl;
import javafx.application.Application;
import javafx.application.Preloader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 *
 * @author Nathaniel Groenewold;
 */
public class NobelUI extends Application {
    
    private static final double WIDTH = 800;
    private static final double HEIGHT = 600;

    private static int stepCount = 1;

    // Used to demonstrate step couns.
    public static String STEP() {
        return stepCount++ + ". ";
    }
    
    private Stage applicationStage;
    
    public NobelUI() {
        // Constructor is called after BEFORE_LOAD.
        System.out.println(NobelUI.STEP() + "MyApplication constructor called, thread: " + Thread.currentThread().getName());
    }
    
     @Override
    public void init() throws Exception {
        System.out.println(NobelUI.STEP() + "MyApplication#init (doing some heavy lifting), thread: " + Thread.currentThread().getName());

        Extract Ex = new Extract();
        Ex.Extract(this);
        LauncherImpl.notifyPreloader(this, new Preloader.ProgressNotification(100));

    }
    
    @Override
    public void start(Stage primaryStage) {
        System.out.println(NobelUI.STEP() + "MyApplication#start (initialize and show primary application stage), thread: " + Thread.currentThread().getName());

        applicationStage = primaryStage;

        Label title = new Label("This is your application!");
        title.setTextAlignment(TextAlignment.CENTER);

        VBox root = new VBox(title);
        root.setAlignment(Pos.CENTER);

        // Create scene and show application stage.
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        applicationStage.setScene(scene);
        applicationStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LauncherImpl.launchApplication(NobelUI.class, NobelPreload.class, args);
    }
    
}
