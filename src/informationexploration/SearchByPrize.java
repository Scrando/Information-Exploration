/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informationexploration;

import java.util.List;
import java.util.Map;

/**
 * Search object for Prize
 * @author Connor
 */
public class SearchByPrize extends SearchCommand { 
    private String prize;
    
    /**
     * set up search
     * @param data
     * @param pz 
     */
    public SearchByPrize (Map<String,List<String>> data, String pz) {
        super (data);
        prize = pz;
    }
    /**
     * include the search term
     * @param value
     * @return 
     */
    public boolean include (String value) {
        return value.equals (prize);
    }
}
