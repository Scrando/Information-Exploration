/**
* @param args the command line arguments
*/
package informationexploration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The search engine, each version of search will call this method 
 * @author Connor
 */
public class SearchEngine {
      
    //These are our earch terms
    //The are null if we are not searching in them
    //storage:             Searchbar:        
    String cPrize;         //"Prize",
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
    Map<Integer,List<String>> ExecuteSearch(){
        int num = 0;
       
        Map<Integer,List<String>> results = new HashMap(); //ask about this, also make sure no dups
        Extract Database = DB;
       
        //Name
        if(cName == null){} else{     
            //Check if name in first
            if(Database.firstNameDB.containsKey(cName)){
                SearchByName nameFSearch = new SearchByName (Database.firstNameDB, cName);
                results = nameFSearch.Execute();
            }else{ //ask about better way for this
            //Check if name in second
            if(Database.surNameDB.containsKey(cName)){
               SearchByName nameLSearch = new SearchByName (Database.surNameDB, cName);
               results = nameLSearch.Execute();
            } 
            } 
        }
        //Gender
        if(cGender == null){} else{
        if(Database.genderDB.containsKey(cGender)){
          SearchByGender genderSearch  = new SearchByGender(Database.genderDB,cGender);
          results = genderSearch.Execute();
        }    
        }
        //Prize
        if(cPrize == null){} else{
        if(Database.prizeCategoryDB.containsKey(cPrize)){
            SearchByPrize catPrizeSearch = new SearchByPrize(Database.prizeCategoryDB, cPrize);        
            results = catPrizeSearch.Execute();
        }else{
        if(Database.prizeYearDB.containsKey(cPrize)){
            SearchByPrize yearPrizeSearch = new SearchByPrize(Database.prizeYearDB, cPrize);        
            results = yearPrizeSearch.Execute();              
        }
        }
        }
        //Birth Country
        if(cCountryBirth == null){} else{
        if(Database.bornCountryDB.containsKey(cCountryBirth)){
            SearchByBCountry countryBornSearch = new SearchByBCountry(Database.bornCountryDB,cCountryBirth);
            results = countryBornSearch.Execute();
        }  
        }
        //Death Country
        if(cCountryDeath == null){} else{
        if(Database.diedCountryDB.containsKey(cCountryDeath)){
           SearchByDCountry countryDiedSearch = new SearchByDCountry(Database.diedCountryDB,cCountryDeath);
            results = countryDiedSearch.Execute();            
        }  
        }
        //Birth Year
        if(cBYear == null){} else{
        if(Database.bornDB.containsKey(cBYear)){
            SearchByBYear searchBorn = new SearchByBYear(Database.bornDB,cBYear);
            results = searchBorn.Execute();
        }  
        }
        if(cDYear == null){} else{
        if(Database.diedDB.containsKey(cDYear)){
               SearchByDYear searchDied = new SearchByDYear(Database.diedDB,cDYear);
               results = searchDied.Execute();
        }  
        }
       return results; //return 
    } 
    /**
    * This adds to our results
    * @param list The Search result list
    * @param thing The value 
    * @param currentTime The int for our ID
    */
    void AddToResults(Map<Integer,List<String>> list, List<String> thing,int currentTime){
       int i = currentTime;
       Integer c;
       c = i;
       list.put(c,thing);
    }
   

    /**
    * Sets in the search terms for the engine
    * IMPORTANT: Call this before you call the Execute Search 
    * @param ent SearchEntry object
    */
    void setSearchCrit(SearchEntry ent){
        cPrize = ent.getPrize();
        cName = ent.getName();       
        cGender = ent.getGender();
        cCountryBirth = ent.getCountryB();
        cCountryDeath = ent.getCountryD();
        cBYear = ent.getBYear();
        cDYear = ent.getDYear(); 
    } 
    
    
} 
