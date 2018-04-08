/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informationexploration;

import java.util.List;
import java.util.Map;

/**
 * Search by our country of death
 * @author Connor
 */
public class SearchByDCountry extends SearchCommand { 
    private String country;
    
    /**
     * Sets up search
     * @param data 
     * @param dCountry 
     */
    public SearchByDCountry (Map<String,List<String>> data, String dCountry) {
        super (data);
        country = dCountry;
    }
    /**
     * includes our search term
     * @param value
     * @return 
     */
    public boolean include (String value) {
        return value.equals (country);
    }
    
}
