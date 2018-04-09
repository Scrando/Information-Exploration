/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informationexploration;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Owner
 */
public abstract class SearchCommand {
    private final Map<String,List<String>> Data;
    Set<String> results;
    
    public SearchCommand (Map<String,List<String>> data) {
        Data = data;
    }
    
    abstract boolean include (String CValue);
    
    public Set<String> Execute() {
        results = new HashSet<>();
        for(String n : Data.keySet()){
            if(include(n)) {
                results.addAll(Data.get(n));
            }
        }
        return results;
    }
}