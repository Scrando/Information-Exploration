
/**
* @param args the command line arguments
*/
package informationexploration;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The search engine, each version of search will call this method 
 * @author Connor
 */
public class SearchEngine {
      
    //These are our search terms
    //The are null if we are not searching in them
    //storage:             Searchbar:        
    String cPrize;         //"Prize",
    String cPrizeYear;     //"Prize Year"
    String cName;          //"Name",
    String cGender;        //"Gender",
    String cCountryBirth;  //"Birthplace",, 
    String cCountryDeath;  //"Place of Death"
    String cBYear;         //"Year of Birth",
    String cDYear;         //"Year of Death",
   
    Extract DB;//currently saved database

    /**
    * Loads our current database
    * IMPORTANT: Do this BEFORE searching First!
    * @param DB Database object
    */ 
    void addDatabase(Extract DB){
        this.DB = DB;     
   }
   
   /**
    * Searches the given database for given terms
    * Important: Execute after everything is set!
    * @return Map<Integer,List<String>> of resulting Integers and IDs 
    */
    Set<String> ExecuteSearch(){
       
        Set<String> results = new HashSet<>();
        Extract Database = DB;
       
        //Name
        if(cName != null){     
            //Check if name in first
            if(Database.firstNameDB.containsKey(cName)){
                SearchBy nameFSearch = new SearchBy (Database.firstNameDB, cName);
                results.addAll(nameFSearch.Execute());
            } else{

            //Check if name in second
            if(Database.surNameDB.containsKey(cName)){
               SearchBy nameLSearch = new SearchBy (Database.surNameDB, cName);
               results = nameLSearch.Execute();
            } 
            } 
        }
        //Gender
        if(cGender != null){
            if(Database.genderDB.containsKey(cGender)){
                SearchBy genderSearch  = new SearchBy(Database.genderDB,cGender);
                results = genderSearch.Execute();
            }    
        }
        //Prize
        if(cPrize != null){
            if(Database.prizeCategoryDB.containsKey(cPrize)){
                SearchBy prizeSearch = new SearchBy(Database.prizeCategoryDB, cPrize);        
                results = prizeSearch.Execute();

            }
        }
        if (cPrizeYear != null){
            if(Database.prizeYearDB.containsKey(cPrizeYear)){
                SearchBy yearPrizeSearch = new SearchBy(Database.prizeYearDB, cPrize);        
                results = yearPrizeSearch.Execute();              
            }
        }
        //Birth Country
        if(cCountryBirth != null){
            if(Database.bornCountryDB.containsKey(cCountryBirth)){
                SearchBy countryBornSearch = new SearchBy(Database.bornCountryDB,cCountryBirth);
                results = countryBornSearch.Execute();
            }  
        }
        //Death Country
        if(cCountryDeath != null){
            if(Database.diedCountryDB.containsKey(cCountryDeath)){
                SearchBy countryDiedSearch = new SearchBy(Database.diedCountryDB,cCountryDeath);
                results = countryDiedSearch.Execute();            
            }  
        }
        //Birth Year
        if(cBYear != null){
            if(Database.bornDB.containsKey(cBYear)){
                SearchBy searchBorn = new SearchBy(Database.bornDB,cBYear);
                results = searchBorn.Execute();
            }  
        }
        if(cDYear != null){
            if(Database.diedDB.containsKey(cDYear)){
                SearchBy searchDied = new SearchBy(Database.diedDB,cDYear);
                results = searchDied.Execute();
            }  
        }
       return results; //return 
    } 
   
    /**
    * Sets in the search terms for the engine
    * IMPORTANT: Call this before you call the Execute Search 
    * @param ent SearchEntry object
    */
    void setSearchCrit(SearchEntry ent){
        cPrize = ent.getPrize();
        cPrizeYear = ent.getPrizeYear();
        cName = ent.getName();       
        cGender = ent.getGender();
        cCountryBirth = ent.getCountryB();
        cCountryDeath = ent.getCountryD();
        cBYear = ent.getBYear();
        cDYear = ent.getDYear(); 
    }  
}
