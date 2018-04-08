/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informationexploration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Owner
 */
public abstract class SearchCommand {
    private Map<String,List<String>> Data;
    
    public SearchCommand (Map<String,List<String>> data) {
        Data = data;
    }
    
    abstract boolean include (String CValue);
    
    public Map<Integer,List<String>> Execute() {
        Map<Integer,List<String>> results = new HashMap<>();
        int num = 0;
        for(String n : Data.keySet()){
            if(include(n)) {
                 AddToResults(results,Data.get(n), num++);   
            }
        }
        
        return results;
    }
    
  /**
    * This adds to our results
    * @param list The Search result list
    * @param thing The value 
    * @param currentTime The int for our ID
    */
    void AddToResults(Map<Integer,List<String>> list, List<String> thing, int currentTime) {
       list.put(currentTime,thing);
    }
}
