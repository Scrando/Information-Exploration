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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 *
 * @author Nathaniel Groenewold;
 */
public class NobelUI extends Application {
    
    private static final double WIDTH = 800;
    private static final double HEIGHT = 600;
    private Stage applicationStage;
    
     @Override
    public void init() throws Exception {
        Extract Ex = new Extract();
        Ex.Extract(this);
        LauncherImpl.notifyPreloader(this, new Preloader.ProgressNotification(100));
    }
    
    @Override
    public void start(Stage primaryStage) {

        applicationStage = primaryStage;

        Label title = new Label("Nobel Prize Search");
        title.setFont(new Font("Arial", 30));
        title.setTextAlignment(TextAlignment.CENTER);

        VBox root = new VBox(title);
        root.setAlignment(Pos.CENTER);
        
        //Defining the Name text field
        final TextField name = new TextField();
        name.setPromptText("Enter your search term.");
        name.setPrefColumnCount(10);
        name.getText();
        root.getChildren().add(name);
        
        //Defining the Last Name text field
        final ComboBox searchFields = new ComboBox();
        searchFields.setPromptText("Chose your search category");
        searchFields.getItems().addAll(
            "Name",
            "Year of Birth",
            "Year of Death",
            "Birthplace",
            "Place of Death",
            "Gender",
            "Prize"
        );
        root.getChildren().add(searchFields);
        
        //Defining the Submit button
        Button submit = new Button("Search");
        root.getChildren().add(submit);
        
        //Defining the Clear button
        Button clear = new Button("Clear");
        root.getChildren().add(clear);

        // Create scene and show application stage.
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        applicationStage.setScene(scene);
        primaryStage.setTitle("Nobel Prize Database");
        applicationStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LauncherImpl.launchApplication(NobelUI.class, NobelPreload.class, args);
    }   
}
