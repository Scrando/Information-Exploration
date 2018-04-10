/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informationexploration;

import com.sun.javafx.application.LauncherImpl;
import java.util.List;
import java.util.Set;
import javafx.application.Application;
import javafx.application.Preloader;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
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
    private TextField entry;
    private ComboBox searchFields;
    private String searchTerm;
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
        entry = new TextField();
        entry.setPromptText("Enter your search term.");
        entry.setPrefColumnCount(10);
        entry.getText();
        root.getChildren().add(entry);
        
        //Defining the Last Name text field
        searchFields = new ComboBox();
        searchFields.setPromptText("Chose your search category");
        searchFields.getItems().addAll(
            "Name",
            "Prize",
            "Year of Prize",
            "Year of Birth",
            "Year of Death",
            "Country of Birth",
            "Gender",
            "Country of Death"  
        );
        root.getChildren().add(searchFields);
        
        //Defining the Submit button
        Button search = new Button("Search");
        root.getChildren().add(search);
        search.setOnAction(searchButtonOnActionEventHandler);
        
        //Defining the Clear button
        Button clear = new Button("Clear");
        clear.setOnAction((ActionEvent e) -> {
            entry.clear();
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
            searchTerm = entry.getText();
            SearchEntry ent = new SearchEntry();
            String searchField = (String) searchFields.getValue();
            if (searchField == null) {System.out.println("Please select a search category!"); return;}
            switch(searchField) {
                case "Name": ent.addName(searchTerm.toLowerCase());
                            break;  
                case "Year of Birth": ent.addBYear(searchTerm.toLowerCase());
                            break;
                case "Year of Death": ent.addDYear(searchTerm.toLowerCase());
                            break;
                case "Country of Birth": ent.addCountryB(searchTerm.toLowerCase());
                            break;
                case "Country of Death": ent.addCountryD(searchTerm.toLowerCase());
                            break;
                case "Gender": ent.addGender(searchTerm.toLowerCase());
                            break;
                case "Prize": ent.addPrize(searchTerm.toLowerCase());
                            break;
                case "Year of Prize": ent.addPrizeYear(searchTerm.toLowerCase());
                            break;
            }
            searchEngine.setSearchCrit(ent);
            searchTerm = searchTerm + " (" + searchField + ") ";
            Set<String> results = searchEngine.ExecuteSearch();
            System.out.println(searchTerm);
            System.out.println(results.toString()); 
            displayResults(results);
        }
    };
    
    private void displayResults(Set<String> results) {
        
        BorderPane borderpane = new BorderPane();
        Insets insets = new Insets(25);
        
        //set label
        Label title = new Label("Nobel Prize Search Results");
        title.setFont(new Font("Arial", 25));
        title.setTextAlignment(TextAlignment.CENTER);
        
        Label search = new Label("Search Term(s): " + searchTerm);
        search.setFont(new Font("Arial", 15));
        search.setTextAlignment(TextAlignment.CENTER);
        
        VBox root = new VBox(title, search);
        root.setAlignment(Pos.TOP_CENTER);
        
        GridPane displayResults = new GridPane();
        displayResults.setHgap(10);
        
        if (results.isEmpty()) {
            Label result = new Label("No Results Found");
            displayResults.add(result, 0 ,0);
        }
        int i = 0;
        for (String ID: results) {
            displayResults.add(createNameLabel(ID), 0, i);
            displayResults.add(createPrizeLabel(ID), 1, i);
            i++;
        }
        
        
        borderpane.setTop(root);
        borderpane.setMargin(root, insets);
        
        borderpane.setCenter(displayResults);
        borderpane.setMargin(displayResults, insets);
        
        Stage stage = new Stage();
        stage.setTitle("Search Results");
        stage.setScene(new Scene(borderpane, WIDTH - 100, HEIGHT));
        stage.show();
    }
    
    private Label createNameLabel(String ID) {
        Entry result = DB.idDB.get(ID);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(result.getFirstName()).append(" ").append(result.getLastName());
        return new Label(stringBuilder.toString());
    }

    private Label createPrizeLabel(String ID) {
        List<Prize> result = DB.idDB.get(ID).getPrizes();
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for(Prize prize: result) {
            if (i > 0)
                stringBuilder.append(", ");
            stringBuilder.append(prize.getPrizeCat()).append(" ").append(prize.getPrizeYear());
        }
        return new Label(stringBuilder.toString());
    }
}