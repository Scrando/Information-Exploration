
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
    String prize;         //"Prize",
    String prizeYear;     //"Prize Year"
    String name;          //"Name",
    String gender;        //"Gender",
    String countryBirth;  //"Birthplace",, 
    String countryDeath;  //"Place of Death"
    String bYear;         //"Year of Birth",
    String dYear;         //"Year of Death",
   
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
       
        //Name
        if(name != null){     
            //Check if name in first
            if(DB.firstNameDB.containsKey(name)){
                SearchBy nameFSearch = new SearchBy (DB.firstNameDB, name);
                results.addAll(nameFSearch.Execute());
            } else{

            //Check if name in second
            if(DB.surNameDB.containsKey(name)){
               SearchBy nameLSearch = new SearchBy (DB.surNameDB, name);
               results = nameLSearch.Execute();
            } 
            } 
        }
        //Gender
        if(gender != null){
            if(DB.genderDB.containsKey(gender)){
                SearchBy genderSearch  = new SearchBy(DB.genderDB,gender);
                results = genderSearch.Execute();
            }    
        }
        //Prize
        if(prize != null){
            if(DB.prizeCategoryDB.containsKey(prize)){
                SearchBy prizeSearch = new SearchBy(DB.prizeCategoryDB, prize);        
                results = prizeSearch.Execute();

            }
        }
        if (prizeYear != null){
            if(DB.prizeYearDB.containsKey(prizeYear)){
                SearchBy yearPrizeSearch = new SearchBy(DB.prizeYearDB, prizeYear);        
                results = yearPrizeSearch.Execute();              
            }
        }
        //Birth Country
        if(countryBirth != null){
            if(DB.bornCountryDB.containsKey(countryBirth)){
                SearchBy countryBornSearch = new SearchBy(DB.bornCountryDB,countryBirth);
                results = countryBornSearch.Execute();
            }  
        }
        //Death Country
        if(countryDeath != null){
            if(DB.diedCountryDB.containsKey(countryDeath)){
                SearchBy countryDiedSearch = new SearchBy(DB.diedCountryDB,countryDeath);
                results = countryDiedSearch.Execute();            
            }  
        }
        //Birth Year
        if(bYear != null){
            if(DB.bornYearDB.containsKey(bYear)){
                SearchBy searchBorn = new SearchBy(DB.bornYearDB,bYear);
                results = searchBorn.Execute();
            }  
        }
        if(dYear != null){
            if(DB.diedYearDB.containsKey(dYear)){
                SearchBy searchDied = new SearchBy(DB.diedYearDB,dYear);
                results = searchDied.Execute();
            }  
        }
       return results; //return 
    } 
    
    /**
     * For use when refining a previous search
     * Operates on a set of IDs, searching for the searchCriteria within 
     * The entry objects matching the ids
     * @param IDs - set of ids from a previous search
     * @return  - results, set of ids that match this search
     */
    Set<String> ExecuteSetSearch(Set<String> IDs){
       
        Set<String> results = new HashSet<>();
        String temp;
        
        //Name
        if(name != null){     
            //Check if name in first
            if(DB.firstNameDB.containsKey(name)){
                for (String ID: IDs) {
                    temp = ((String) DB.idDB.get(ID).getFirstName()).toLowerCase();
                    if (temp.equals(name))
                        results.add(ID);
                }
            }
            //Check if name in second
            if(DB.surNameDB.containsKey(name)){
               for (String ID: IDs) {
                    temp = ((String) DB.idDB.get(ID).getLastName()).toLowerCase();;
                    if (temp.equals(name))
                        results.add(ID);
                }
            } 
        }
        //Gender
        if(gender != null){
            if(DB.genderDB.containsKey(gender)){
                for (String ID: IDs) {
                    temp = ((String) DB.idDB.get(ID).getGender()).toLowerCase();
                    if (temp.equals(gender))
                        results.add(ID);
                }
            }    
        }
        //Prize
        if(prize != null){
            for (String ID: IDs) {
                List<Prize> prizes = DB.idDB.get(ID).getPrizes();
                for(Prize i: prizes) {
                    temp = ((String) i.getPrizeCat()).toLowerCase();
                    if (temp.equals(prize))
                        results.add(ID);
                }
            }
        }
        if (prizeYear != null){
            for (String ID: IDs) {
                List<Prize> prizes = DB.idDB.get(ID).getPrizes();
                for(Prize i: prizes) {
                    temp = ((String) i.getPrizeYear()).toLowerCase();
                    if (temp.equals(prizeYear))
                        results.add(ID);
                }
            }              
        }
        //Birth Country
        if(countryBirth != null){
            if(DB.bornCountryDB.containsKey(countryBirth)){
                for (String ID: IDs) {
                    temp = ((String) DB.idDB.get(ID).getBornCountry()).toLowerCase();
                    if (temp.equals(countryBirth))
                        results.add(ID);
                }
            }  
        }
        //Death Country
        if(countryDeath != null){
            if(DB.diedCountryDB.containsKey(countryDeath)){
                for (String ID: IDs) {
                    temp = ((String) DB.idDB.get(ID).getDeathCountry()).toLowerCase();
                    System.out.println(temp);
                    if (temp.equals(countryDeath))
                        results.add(ID);
                }          
            }  
        }
        //Birth Year
        if(bYear != null){
            for (String ID: IDs) {
                temp = ((String) DB.idDB.get(ID).getBirthyear()).toLowerCase().substring(0, 4);
                System.out.println(temp);
                if (temp.equals(bYear))
                    results.add(ID);
            } 
        }
        if(dYear != null){
            for (String ID: IDs) {
                temp = ((String) DB.idDB.get(ID).getDeathyear()).toLowerCase().substring(0, 4);
                if (temp.equals(dYear))
                    results.add(ID);
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
        prize = ent.getPrize();
        prizeYear = ent.getPrizeYear();
        name = ent.getName();       
        gender = ent.getGender();
        countryBirth = ent.getCountryB();
        countryDeath = ent.getCountryD();
        bYear = ent.getBYear();
        dYear = ent.getDYear(); 
    }  
}
