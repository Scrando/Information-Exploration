/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informationexploration;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Returns ID objects
 * @author Connor
 */
public abstract class SearchSetID {
    private final Map<String,Entry> Data;
    private Set<String> IDs;
    Set<Entry> results;
    
    public SearchSetID (Map<String,Entry> data) {
        Data = data;
    }
    
    abstract boolean include (Set<String> IDs);
    
    public Set<Entry> Execute() {
        results = new HashSet<>();
         for(String n : IDs){
            for(String s: Data.keySet()){
                if(s.equals(n)) {
                results.add(Data.get(n));
                }
                
            }
            
        }
        return results;
    }
}