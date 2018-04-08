package informationexploration;

import java.util.List;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Search by our name
 * @author Connor
 */
public class SearchByName  extends SearchCommand { 
    private String name;
    
    /**
     * Sets up search
     * @param data
     * @param nm 
     */
    public SearchByName (Map<String,List<String>> data, String nm) {
        super (data);
        name = nm;
    }
    /**
     * includes our search term
     * @param value
     * @return 
     */
    public boolean include (String value) {
        return value.equals (name);
    }
    
}
