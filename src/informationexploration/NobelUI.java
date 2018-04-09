/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informationexploration;

import com.sun.javafx.application.LauncherImpl;
import java.util.List;
import java.util.Map;
import javafx.application.Application;
import javafx.application.Preloader;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
    
    //Width and height of window
    private static final double WIDTH = 800;
    private static final double HEIGHT = 600;
    private Stage applicationStage;
    Extract DB = new Extract();
    SearchEngine searchEngine = new SearchEngine();
    
    //Initialization of Database and preloader call
    @Override
    public void init() throws Exception {
        DB.Extract(this);
        searchEngine.addDatabase(DB);
        LauncherImpl.notifyPreloader(this, new Preloader.ProgressNotification(100));
    }
    
    //Start runtime for application
    @Override
    public void start(Stage primaryStage) {

        applicationStage = primaryStage;
        
        //set label
        Label title = new Label("Nobel Prize Search");
        title.setFont(new Font("Arial", 30));
        title.setTextAlignment(TextAlignment.CENTER);

        //set vbox and alignment
        VBox root = new VBox(title);
        root.setAlignment(Pos.CENTER);
        
        //Defining the Name text field
        final TextField entry = new TextField();
        entry.setPromptText("Enter your search term.");
        entry.setPrefColumnCount(10);
        entry.getText();
        root.getChildren().add(entry);
        
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
            "Prize",
            "Year of Prize"
        );
        root.getChildren().add(searchFields);
        
        //Defining the Submit button
        Button search = new Button("Search");
        root.getChildren().add(search);
        search.setOnAction(searchButtonOnActionEventHandler);
        
        //Defining the Clear button
        Button clear = new Button("Clear");
        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                entry.clear();
            }
        });
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
    
    EventHandler<ActionEvent> searchButtonOnActionEventHandler = 
        new EventHandler<ActionEvent>() {
            
        @Override
        public void handle(ActionEvent e) {
            System.out.println("We here1");
            SearchEntry ent = new SearchEntry();
            ent.addCountryB("Denmark");
            searchEngine.setSearchCrit(ent);
            Map<Integer,List<String>> results = searchEngine.ExecuteSearch();
            for(int entry: results.keySet()) {
                System.out.println(entry);
                System.out.println(results.toString());
            }
            System.out.println("We here2");
            
        }
    };
    
}
