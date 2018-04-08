/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informationexploration;

import java.util.List;
import java.util.Map;

/**
 * Search by our death year
 * @author Connor
 */
public class SearchByDYear  extends SearchCommand { 
    private String year;
    
    /**
     * Sets up search
     * @param data
     * @param yr 
     */
    public SearchByDYear (Map<String,List<String>> data, String yr) {
        super (data);
        year = yr;
    }
    /**
     * includes our search term
     * @param value
     * @return 
     */
    public boolean include (String value) {
        return value.equals (year);
    }
    
}

