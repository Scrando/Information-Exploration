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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
    private Label error;
    private Label lastSearch;
    private String searchTerm = "";
    Extract DB = new Extract();
    SearchEngine searchEngine = new SearchEngine();
    Set<String> searchResults;
    
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
            "Country of Death", 
            "Gender"
        );
        root.getChildren().add(searchFields);
        
        //Defining the Submit button
        Button search = new Button("New Search");
        search.setOnAction(searchButtonOnActionEventHandler);
        
        //Defining the Submit button
        Button refine = new Button("Refine Last Search");
        refine.setOnAction(refineButtonOnActionEventHandler);
        
        //Place search buttons alongside eachother
        HBox hbox = new HBox(search, refine);
        hbox.setAlignment(Pos.CENTER);
        root.getChildren().add(hbox);
        
        //Defining the Clear button
        Button clear = new Button("Clear");
        clear.setOnAction((ActionEvent e) -> {
            entry.clear();
        });
        root.getChildren().add(clear);
        
        //set error
        error = new Label("");
        error.setFont(new Font("Arial", 15));
        error.setTextAlignment(TextAlignment.CENTER);
        root.getChildren().add(error);
        
        //set last search
        lastSearch = new Label("");
        lastSearch.setFont(new Font("Arial", 15));
        lastSearch.setTextAlignment(TextAlignment.CENTER);
        root.getChildren().add(lastSearch);

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
    
    /**
     * display results of a search
     * @param results - resulting ids from search in a set
     */
    private void displayResults(Set<String> results) {
        
        //create borderpane and an inset object for padding
        BorderPane borderpane = new BorderPane();
        Insets insets = new Insets(25);
        
        //set scene label
        Label title = new Label("Nobel Prize Search Results");
        title.setFont(new Font("Arial", 25));
        title.setTextAlignment(TextAlignment.CENTER);
        
        //Display current search terms
        Label search = new Label("Search Term(s): " + searchTerm);
        search.setFont(new Font("Arial", 15));
        search.setTextAlignment(TextAlignment.CENTER);
        
        //add labels to vbox
        VBox root = new VBox(title, search);
        root.setAlignment(Pos.TOP_CENTER);
        
        //create grid with horizontal padding of 10
        GridPane displayResults = new GridPane();
        displayResults.setHgap(10);
        
        ScrollPane scrollPane = new ScrollPane(displayResults);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);
        
        //write no results found is applicable
        if (results.isEmpty()) {
            Label result = new Label("No Results Found...");
            result.setFont(new Font("Arial", 15));
            displayResults.add(result, 1 ,0);
        } else {
        
            //Display grid titles and a blank row
            displayResults.addRow(0, new Label("Prize Winners"), 
                                     new Label("Prize, Year"), 
                                     new Label("Press button with the entries ID to view details")
            );
            displayResults.addRow(1, new Label(" "));
        
            //iterate through all results display names and prizes
            int i = 2;
            for (String ID: results) {
                displayResults.addRow(i, 
                        createNameLabel(ID), 
                        createPrizeLabel(ID),
                        createEntryButton(ID)
                );
                i++;
            }
        }
        //place vbox and grid into borderpane with margins
        borderpane.setTop(root);
        BorderPane.setMargin(root, insets);
        
        borderpane.setCenter(scrollPane);
        BorderPane.setMargin(scrollPane, insets);
        
        //create and show stage
        Stage stage = new Stage();
        stage.setTitle("Search Results");
        stage.setScene(new Scene(borderpane, WIDTH - 100, HEIGHT));
        stage.show();
    }
    
    private void displayEntryPage(String ID) {
        //create borderpane and an inset object for padding
        BorderPane borderpane = new BorderPane();
        Insets insets = new Insets(50);
        Entry winnerEntry = DB.idDB.get(ID);
        
        //Label for name
        Label nameLabel = createNameLabel(ID);
        nameLabel.setFont(new Font("Arial", 20));
        nameLabel.setTextAlignment(TextAlignment.CENTER);
        
        //Title vbox
        VBox title = new VBox(nameLabel);
        title.setAlignment(Pos.TOP_CENTER); 
        
        //Gender
        String gender = (String) winnerEntry.getGender();
        StringBuilder genderStr = new StringBuilder();
        genderStr.append(gender.substring(0,1).toUpperCase())
                 .append(gender.substring(1).toLowerCase()
        );
        VBox entryInfo = new VBox(new Label(genderStr.toString()));
        
        //Birth info
        StringBuilder bInfo = new StringBuilder();
        bInfo.append("Born ")
             .append(winnerEntry.getBirthyear())
             .append(" in ")
             .append(winnerEntry.getBornCity())
             .append(", ")
             .append(winnerEntry.getBornCountry())
             .append(".")
        ;
        
        entryInfo.getChildren().add(new Label(bInfo.toString()));
        
        //Death info
        if (!winnerEntry.getDeathyear().equals("")) {
            StringBuilder dInfo = new StringBuilder();
            dInfo.append("Died ")
                 .append(winnerEntry.getDeathyear())
                 .append(" in ")
                 .append(winnerEntry.getDeathCity())
                 .append(", ")
                 .append(winnerEntry.getDeathCountry())
                 .append(".")        
            ;
            entryInfo.getChildren().add(new Label(dInfo.toString()));
        }
        
        //Prize info
        //open ID database and access prize list for ID
        List<Prize> result = DB.idDB.get(ID).getPrizes();

        for(Prize prize: result) {
            StringBuilder prizes = new StringBuilder();
            //Capitalize the prize and append the year
            String value = (String) prize.getPrizeCat();
            prizes.append("Nobel ")
                  .append(value.substring(0,1).toUpperCase())
                  .append(value.substring(1).toLowerCase())
                  .append(" Prize in ")
                  .append(prize.getPrizeYear()
            );
            entryInfo.getChildren().add(new Label(prizes.toString()));
        }
        
        borderpane.setTop(title);
        BorderPane.setMargin(title, insets);
        
        borderpane.setCenter(entryInfo);
        BorderPane.setMargin(entryInfo, insets);
        
        //create and show stage
        Stage stage = new Stage();
        stage.setTitle(nameLabel.getText());
        stage.setScene(new Scene(borderpane, WIDTH - 300, HEIGHT - 200));
        stage.show();
    }
    
    /**
     * Create and return a label with the name for the given nobel ID
     * @param ID - string ID of nobel winner
     * @return - LAbel object with name as text
     */
    private Label createNameLabel(String ID) {
        
        //open ID database
        Entry result = DB.idDB.get(ID);
        
        //append names into string builder and return
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(result.getFirstName())
                     .append(" ")
                     .append(result.getLastName()
        );
        return new Label(stringBuilder.toString());
    }

    /**
     * Create and return a label with the prizes and years for a given nobel ID
     * @param ID - string ID of Nobel winner
     * @return 
     */
    private Label createPrizeLabel(String ID) {
        
        //open ID database and access prize list for ID
        List<Prize> result = DB.idDB.get(ID).getPrizes();
        
        //using stringbuilder write the prize or prizes of the nobel winner
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for(Prize prize: result) {
            if (i > 0)
                stringBuilder.append(". ");
            //Capitalize the prize and append the year
            String value = (String) prize.getPrizeCat();
            stringBuilder.append(value.substring(0,1).toUpperCase())
                         .append(value.substring(1).toLowerCase())
                         .append(", ")
                         .append(prize.getPrizeYear());
            i++;
        }
        return new Label(stringBuilder.toString());
    }
    
    private Button createEntryButton(String ID) {
        //Defining the  button
        Button entryView = new Button(ID);
        entryView.setOnAction((ActionEvent e) -> {
            displayEntryPage(((Button)(e.getSource())).getText());
        });
        return entryView;
    }
    
    EventHandler<ActionEvent> searchButtonOnActionEventHandler = 
        new EventHandler<ActionEvent>() {
            
        @Override
        public void handle(ActionEvent e) {
            
            //Get search term from box and create searchEntry
            String term = entry.getText();
            SearchEntry ent = new SearchEntry();
            
            //Error check that search category is chosen and set into searchEntry
            String searchField = (String) searchFields.getValue();
            if (searchField == null) {error.setText("Please select a search category!"); return;}
            switch(searchField) {
                case "Name": ent.addName(term.toLowerCase());
                            break;  
                case "Year of Birth": ent.addBYear(term.toLowerCase());
                            break;
                case "Year of Death": ent.addDYear(term.toLowerCase());
                            break;
                case "Country of Birth": ent.addCountryB(term.toLowerCase());
                            break;
                case "Country of Death": ent.addCountryD(term.toLowerCase());
                            break;
                case "Gender": ent.addGender(term.toLowerCase());
                            break;
                case "Prize": ent.addPrize(term.toLowerCase());
                            break;
                case "Year of Prize": ent.addPrizeYear(term.toLowerCase());
                            break;
            }
            
            //Set search criteria in search engine
            searchEngine.setSearchCrit(ent);
            
            //Update text on main search window
            searchTerm = term + " (" + searchField + ") ";
            lastSearch.setText("Last Search: " + searchTerm);
            error.setText(" ");
            
            //execute search and display in new window
            searchResults = searchEngine.ExecuteSearch();
            displayResults(searchResults);
        }
    };
    
    EventHandler<ActionEvent> refineButtonOnActionEventHandler = 
        new EventHandler<ActionEvent>() {
            
        @Override
        public void handle(ActionEvent e) {
            if (searchTerm.equals(""))
                error.setText("No previous search to refine!");
            
            //Get search term from box and create searchEntry
            String term = entry.getText();
            SearchEntry ent = new SearchEntry();
            
            //Error check that search category is chosen and set into searchEntry
            String searchField = (String) searchFields.getValue();
            System.out.println(searchField);
            if (searchField == null) {error.setText("Please select a search category!"); return;}
            switch(searchField) {
                case "Name": ent.addName(term.toLowerCase());
                            break;  
                case "Year of Birth": ent.addBYear(term.toLowerCase());
                            break;
                case "Year of Death": ent.addDYear(term.toLowerCase());
                            break;
                case "Country of Birth": ent.addCountryB(term.toLowerCase());
                            break;
                case "Country of Death": ent.addCountryD(term.toLowerCase());
                            break;
                case "Gender": ent.addGender(term.toLowerCase());
                            break;
                case "Prize": ent.addPrize(term.toLowerCase());
                            break;
                case "Year of Prize": ent.addPrizeYear(term.toLowerCase());
                            break;
            }
            
            //Set search criteria in search engine
            searchEngine.setSearchCrit(ent);
            
            //Update text on main search window
            searchTerm = searchTerm + " + " + term + " (" + searchField + ") ";
            lastSearch.setText("Last Search: " + searchTerm);
            error.setText(" ");
            
            System.out.println(searchResults.toString());
            //execute search and display in new window
            searchResults = searchEngine.ExecuteSetSearch(searchResults);
            System.out.println(searchResults.toString());
            displayResults(searchResults);
        }
    };
}