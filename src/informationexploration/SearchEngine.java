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
    * IMPORTANT: Do this BEFORE First!
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
                for(String n : Database.firstNameDB.keySet()){
                    if(n.equals(CName)){
                        ++num;
                        AddToResults(results,Database.firstNameDB.get(n),num);  
                    }
                }    
            }
            //Check if name in second
            if(Database.surNameDB.containsKey(CName)){
                for(String n : Database.surNameDB.keySet()){
                    if(n.equals(CName)){
                       ++num;
                       AddToResults(results,Database.surNameDB.get(n),num);
                    }
                }   
            }      
        }
        //Gender
        if(CGender == null){} else{
        if(Database.genderDB.containsKey(CGender)){
            for(String n : Database.genderDB.keySet()){
                if(n.equals(CGender)){
                    ++num;
                    AddToResults(results,Database.genderDB.get(n),num);   
                }
            }            
        }    
        }
        //Prize
        if(CPrize == null){} else{
        if(Database.prizeCategoryDB.containsKey(CPrize)){
            for(String n : Database.prizeCategoryDB.keySet()){
                if(n.equals(CPrize)){
                    ++num;
                    AddToResults(results,Database.prizeCategoryDB.get(n),num); 
                        
                }
            }               
        }
        if(Database.prizeYearDB.containsKey(CPrize)){
            for(String n : Database.prizeYearDB.keySet()){
                if(n.equals(CPrize)){
                    ++num;
                    AddToResults(results,Database.prizeYearDB.get(n),num);     
                }
            }              
        }       
        }
        //Birth Country
        if(CCountryBirth == null){} else{
        if(Database.bornCountryDB.containsKey(CCountryBirth)){
            for(String n : Database.bornCountryDB.keySet()){
                if(n.equals(CCountryBirth)){
                    ++num;
                    AddToResults(results,Database.bornCountryDB.get(n),num);   
                }
            } 
        }  
        }
        //Death Country
        if(CCountryDeath == null){} else{
        if(Database.diedCountryDB.containsKey(CCountryDeath)){
            for(String n : Database.diedCountryDB.keySet()){
                if(n.equals(CCountryDeath)){
                    ++num;
                    AddToResults(results,Database.diedCountryDB.get(n),num);   
                }
            }            
        }  
        }
        //Birth Year
        if(CBYear == null){} else{
        if(Database.bornDB.containsKey(CBYear)){
            for(String n : Database.bornDB.keySet()){
                if(n.equals(CBYear)){
                    ++num;
                    AddToResults(results,Database.bornDB.get(n),num);  
                }
            } 
        }  
        }
        if(CDYear == null){} else{
        if(Database.diedDB.containsKey(CDYear)){
            for(String n : Database.diedDB.keySet()){
                if(n.equals(CDYear)){
                    ++num;
                    AddToResults(results,Database.diedDB.get(n),num);   
                }
            }    
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
    

