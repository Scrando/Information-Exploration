/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informationexploration;

import java.util.Map;

/**
 * Search data for individual ID
 * @author Connor
 */
public class SearchByID extends SearchSetID { 
    private final String look;
    
    /**
     * set up search
     * @param data 
     * @param lookFor 
     */
    public SearchByID (Map<String,Entry> data, String lookFor) {
        super (data);
        look = lookFor;
    }
    /**
     * include the search term
     * @param value
     * @return 
     */
    @Override
    public boolean include (String value) {
        return value.equals (look);
    }
}
