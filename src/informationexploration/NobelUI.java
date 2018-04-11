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
 * Nobel UI application that allows for searching of the nobel prize database
 * @author Nathaniel Groenewold;
 */
public class NobelUI extends Application {
    
    //Width and height of window
    private static final double WIDTH = 800;
    private static final double HEIGHT = 600;
    
    //Initialize variables that need to be accessed by event handlers
    private Stage applicationStage;
    private TextField entry;
    private ComboBox searchFields;
    private Label error;
    private Label lastSearch;
    private String searchTerm;
    private Set<String> searchResults;
    
    //Initialize database and search engine
    Extract DB = new Extract();
    SearchEngine searchEngine = new SearchEngine();
    
    /**
     * Initialization for the application
     * calls the preloader that displays loading screen
     * @throws Exception 
     */
    @Override
    public void init() throws Exception {
        DB.Extract(this);               //extract db
        searchEngine.addDatabase(DB);   // add db to searchengine
        LauncherImpl.notifyPreloader(this, new Preloader.ProgressNotification(100));
    }
    
    /**
     * Start function for application
     * Creates initial search screen with all that entails
     * @param primaryStage - stage that holds application
     */
    @Override
    public void start(Stage primaryStage) {

        applicationStage = primaryStage;
        
        //Create title label
        Label title = new Label("Nobel Prize Search");
        title.setFont(new Font("Arial", 30));
        title.setTextAlignment(TextAlignment.CENTER);

        //set title into a vbox and align it
        VBox root = new VBox(title);
        root.setAlignment(Pos.CENTER);
        
        //Defining the entry text field
        entry = new TextField();
        entry.setPromptText("Enter your search term.");
        entry.setPrefColumnCount(10);
        entry.getText();
        root.getChildren().add(entry);
        
        //Defining the search fields combobox for category selection
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
        
        //Defining the searcht button
        Button search = new Button("New Search");
        search.setOnAction(searchButtonOnActionEventHandler); 
        
        //Defining the clear button
        Button clear = new Button("Clear");
        clear.setOnAction((ActionEvent e) -> {
            entry.clear();
        });
        
        //Place buttons alongside eachother in an hbox and add to vbox
        HBox hbox = new HBox(search, clear);
        hbox.setAlignment(Pos.CENTER);
        root.getChildren().add(hbox);
        
        //set error label as initially blank
        error = new Label("");
        error.setFont(new Font("Arial", 15));
        error.setTextAlignment(TextAlignment.CENTER);
        root.getChildren().add(error);
        
        //set last search label as initially blank
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
        
        //set scene title label
        Label title = new Label("Nobel Prize Search Results");
        title.setFont(new Font("Arial", 25));
        title.setTextAlignment(TextAlignment.CENTER);
        
        //Display current search terms
        Label searchTerms = new Label("Search Term(s): " + searchTerm);
        searchTerms.setFont(new Font("Arial", 15));
        searchTerms.setTextAlignment(TextAlignment.CENTER);
        
        //Set entry text field width and add it with the combobox to an hbox
        entry.setPrefWidth(300);
        HBox hbox1 = new HBox(entry, searchFields);
        
        //Defining the search button
        Button search = new Button("New Search");
        search.setOnAction(searchButtonOnActionEventHandler); 
        
        //Defining the refine button
        Button refine = new Button("Refine Last Search");
        refine.setOnAction(refineButtonOnActionEventHandler);
        
        //Defining the clear button
        Button clear = new Button("Clear");
        clear.setOnAction((ActionEvent e) -> {
            entry.clear();
        });
        
        //add all buttons to an hbox
        HBox hbox2 = new HBox(search, refine, clear);
        
        //add labels/hboxes to vbox
        VBox root = new VBox(title, searchTerms, hbox1, hbox2);
        root.setAlignment(Pos.TOP_CENTER);
              
        //create grid with horizontal padding of 10
        GridPane displayResults = new GridPane();
        displayResults.setHgap(10);
        
        //create scroll pane to hold results
        ScrollPane scrollPane = new ScrollPane(displayResults);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);
        
        //write no results found if applicable
        if (results.isEmpty()) {
            Label result = new Label("No Results Found...");
            result.setFont(new Font("Arial", 15));
            displayResults.add(result, 1 ,0);
        } else {
        
            //Display grid titles and a blank row
            displayResults.addRow(0, new Label("Prize Winner"), 
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
        //place vbox and scrollpane into borderpane with margins
        borderpane.setTop(root);
        BorderPane.setMargin(root, insets);
        
        borderpane.setCenter(scrollPane);
        BorderPane.setMargin(scrollPane, insets);
        
        //create and show stage
        Stage stage = new Stage();
        stage.setTitle("Search Results");
        stage.setScene(new Scene(borderpane, WIDTH, HEIGHT));
        stage.show();
    }
    
    /**
     * Display a page to show more detailed info for a specific entry
     * @param ID - id of entry to show info for
     */
    private void displayEntryPage(String ID) {
        
        //create borderpane and an inset object for padding
        BorderPane borderpane = new BorderPane();
        Insets insets = new Insets(50);
        Entry winnerEntry = DB.idDB.get(ID);
        
        //label for the entrys name
        Label nameLabel = createNameLabel(ID);
        nameLabel.setFont(new Font("Arial", 20));
        nameLabel.setTextAlignment(TextAlignment.CENTER);
        
        //vbox for the name label
        VBox title = new VBox(nameLabel);
        title.setAlignment(Pos.TOP_CENTER); 
        
        //write gender info
        //change org -> organization
        StringBuilder genderStr = new StringBuilder();
        if (winnerEntry.getGender().equals("org")) {
            genderStr.append("Organization");
        } else {
            String gender = (String) winnerEntry.getGender();
            genderStr.append(gender.substring(0,1).toUpperCase())
                     .append(gender.substring(1).toLowerCase()
                     );
        }
        VBox entryInfo = new VBox(new Label(genderStr.toString()));
        
        //write birth date/place info, skips if n/a
        if (!winnerEntry.getBirthyear().equals("")) {
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
        }
        
        //write death date/place info, skips if n/a
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
        
        
        //open ID database and access prize list for ID
        List<Prize> result = DB.idDB.get(ID).getPrizes();

        //writes prize type/date info, allowing for multiples
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
        
        //defining close button
        Button close = new Button("Close");
        close.setOnAction((ActionEvent e) -> {
            ((Node)(e.getSource())).getScene().getWindow().hide();
        });
        
        //add close button to hbox for alignment
        HBox hbox = new HBox(close);
        hbox.setAlignment(Pos.CENTER);
        
        //add nodes into regions with margins
        borderpane.setTop(title);
        BorderPane.setMargin(title, insets);
        
        borderpane.setCenter(entryInfo);
        BorderPane.setMargin(entryInfo, insets);
        
        borderpane.setBottom(hbox);
        BorderPane.setMargin(hbox, insets);
        
        //create and show stage
        Stage stage = new Stage();
        stage.setTitle(nameLabel.getText());
        stage.setScene(new Scene(borderpane, WIDTH - 300, HEIGHT - 200));
        stage.show();
    }
    
    /**
     * Create and return a label with the name for the given nobel ID
     * @param ID - string ID of nobel winner
     * @return - Label object with name as text
     */
    private Label createNameLabel(String ID) {
        
        //open ID database
        Entry result = DB.idDB.get(ID);
        
        //append names into string builder and return label
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
            if (i > 0) //if not on first prize, add something to split the prizes
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
    
    /**
     * Create and return the button that applies to an entry on the results page
     * @param ID - ID of the corresponding entry
     * @return 
     */
    private Button createEntryButton(String ID) {
        //defining the button
        Button entryView = new Button(ID);
        
        //define the event handler
        //call the display function with the id listed on the button
        entryView.setOnAction((ActionEvent e) -> {
            displayEntryPage(((Button)(e.getSource())).getText());
        });
        return entryView;
    }
    
    /**
     * Event handler for search button
     */
    EventHandler<ActionEvent> searchButtonOnActionEventHandler = 
        new EventHandler<ActionEvent>() {
        
            /**
             * Handle whats happens when the search button is clicked
             * @param e - the action event
             */
        @Override
        public void handle(ActionEvent e) {
            
            //Get search term from text field and create searchEntry
            String term = entry.getText();       
            SearchEntry ent = new SearchEntry();
            
            //Error check that search category has been chosen and set that into searchEntry
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
                //special case where you can search for org under gender by typing organization            
                case "Gender": if(term.equalsIgnoreCase("Organization")) term = "org";
                            ent.addGender(term.toLowerCase());
                            break;
                case "Prize": ent.addPrize(term.toLowerCase());
                            break;
                case "Year of Prize": ent.addPrizeYear(term.toLowerCase());
                            break;
            }
            
            //Set search criteria in search engine
            searchEngine.setSearchCrit(ent);
            
            //Update label displaying current search
            searchTerm = term + " (" + searchField + ") ";
            lastSearch.setText("Last Search: " + searchTerm);
            
            //execute search and display in new window, hide old window
            searchResults = searchEngine.ExecuteSearch();
            ((Node)(e.getSource())).getScene().getWindow().hide();
            displayResults(searchResults);
        }
    };
    
    /**
     * Event handler for the refine search button
     */
    EventHandler<ActionEvent> refineButtonOnActionEventHandler = 
        new EventHandler<ActionEvent>() {
        
            /**
             * Handle what happens when the refine search button is clicked
             * @param e - the action event
             */
        @Override
        public void handle(ActionEvent e) {
            
            //Get search term from box and create searchEntry
            String term = entry.getText();
            SearchEntry ent = new SearchEntry();
            
            //Error check that search category has been chosen and set that into searchEntry
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
                //special case where you can search for org under gender by typing organization            
                case "Gender": if(term.equalsIgnoreCase("Organization")) term = "org";
                            ent.addGender(term.toLowerCase());
                            break;
                case "Prize": ent.addPrize(term.toLowerCase());
                            break;
                case "Year of Prize": ent.addPrizeYear(term.toLowerCase());
                            break;
            }
            
            //Set search criteria in search engine
            searchEngine.setSearchCrit(ent);
            
            //Update label displaying current search
            searchTerm = searchTerm + " + " + term + " (" + searchField + ") ";
            lastSearch.setText("Last Search: " + searchTerm);
            
            //execute search and display in new window, hide old window
            searchResults = searchEngine.ExecuteSetSearch(searchResults);
            ((Node)(e.getSource())).getScene().getWindow().hide();
            displayResults(searchResults);
        }
    };
}