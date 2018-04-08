/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informationexploration;

import java.util.List;
import java.util.Map;

/**
 * Search by our Gender
 * @author Connor
 */
public class SearchByGender extends SearchCommand { 
    private String gender;
    
    /**
     * Sets up search
     * @param data
     * @param gend 
     */
    public SearchByGender (Map<String,List<String>> data, String gend) {
        super (data);
        gender = gend;
    }
    /**
     * includes our search term
     * @param value
     * @return 
     */
    public boolean include (String value) {
        return value.equals (gender);
    }
    
}
