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
public class SearchEngineRevised {
      
    //These are our earch terms
    //The are null if we are not searching in them
    //storage:             Searchbar:        
    String CPrize;         //"Prize",
    String CName;          //"Name",
    String CGender;        //"Gender",
    String CCountryBirth;  //"Birthplace",, 
    String CCountryDeath;  //"Place of Death"
    String CBYear;         //"Year of Birth",
    String CDYear;         //"Year of Death",
   
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
        if(CName == null){} else{     
            //Check if name in first
            if(Database.firstNameDB.containsKey(CName)){
                SearchByName nameFSearch = new SearchByName (Database.firstNameDB, CName);
                nameFSearch.Execute();
            }else{ //ask about better way for this
            //Check if name in second
            if(Database.surNameDB.containsKey(CName)){
               SearchByName nameLSearch = new SearchByName (Database.surNameDB, CName);
               nameLSearch.Execute();
            } 
            } 
        }
        //Gender
        if(CGender == null){} else{
        if(Database.genderDB.containsKey(CGender)){
          SearchByGender genderSearch  = new SearchByGender(Database.genderDB,CGender);
          results = genderSearch.Execute();
        }    
        }
        //Prize
        if(CPrize == null){} else{
        if(Database.prizeCategoryDB.containsKey(CPrize)){
            SearchByPrize catPrizeSearch = new SearchByPrize(Database.prizeCategoryDB, CPrize);        
            results = catPrizeSearch.Execute();
        }else{
        if(Database.prizeYearDB.containsKey(CPrize)){
            SearchByPrize yearPrizeSearch = new SearchByPrize(Database.prizeYearDB, CPrize);        
            results = yearPrizeSearch.Execute();              
        }
        }
        }
        //Birth Country
        if(CCountryBirth == null){} else{
        if(Database.bornCountryDB.containsKey(CCountryBirth)){
            SearchByBCountry countryBornSearch = new SearchByBCountry(Database.bornCountryDB,CCountryBirth);
            results = countryBornSearch.Execute();
        }  
        }
        //Death Country
        if(CCountryDeath == null){} else{
        if(Database.diedCountryDB.containsKey(CCountryDeath)){
           SearchByDCountry countryDiedSearch = new SearchByDCountry(Database.diedCountryDB,CCountryDeath);
            results = countryDiedSearch.Execute();            
        }  
        }
        //Birth Year
        if(CBYear == null){} else{
        if(Database.bornDB.containsKey(CBYear)){
            SearchByBYear searchBorn = new SearchByBYear(Database.bornDB,CBYear);
            results = searchBorn.Execute();
        }  
        }
        if(CDYear == null){} else{
        if(Database.diedDB.containsKey(CDYear)){
               SearchByDYear searchDied = new SearchByDYear(Database.diedDB,CDYear);
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
        CPrize = ent.getPrize();
        CName = ent.getName();       
        CGender = ent.getGender();
        CCountryBirth = ent.getCountryB();
        CCountryDeath = ent.getCountryD();
        CBYear = ent.getBYear();
        CDYear = ent.getDYear(); 
    } 
    
    
} 
