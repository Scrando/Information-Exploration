/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informationexploration;

import java.util.List;
import java.util.Map;

/**
 * Search data for object
 * @author Connor
 */
public class SearchBy extends SearchCommand { 
    private String look;
    
    /**
     * set up search
     * @param data 
     * @param lookFor 
     */
    public SearchBy (Map<String,List<String>> data, String lookFor) {
        super (data);
        look = lookFor;
    }
    /**
     * include the search term
     * @param value
     * @return 
     */
    public boolean include (String value) {
        return value.equals (look);
    }
}
