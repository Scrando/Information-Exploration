package informationexploration;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Affiliation class for the Nobel Database
 * Contains a hash map with key value pairs with a variety
 * of information for each Prize's Affiliation
 * @author Brandon
 */
public class Affiliation {
    private Map keys;
    
    /**
     * Creator for Affiliation object
     */
    public Affiliation(){
        this.keys = new HashMap();
    }
    
    /**
     * Getter for all keys
     * @return - Set of all keys in this entry
     */
    public Set getKeys(){
        return keys.keySet();
    }
    
    
    /**
     * getter for affiliation name
     * @return - object mapped to affiliation name
     */
    public Object getAffiliationName(){
        return this.keys.get("affname");
    }
    
    /**
     * setter for affiliation name
     * @param value - affiliation name of prize winner
     */
    public void setAffiliationName(String value){
        this.keys.put("affname", value);
    }
    
    /**
     * getter for affiliation city
     * @return - object mapped to affiliation city
     */
    public Object getAffiliationCity(){
        return this.keys.get("affcity");
    }
    
    /**
     * setter for affiliation city
     * @param value - affiliation city of prize winner
     */
    public void setAffiliationCity(String value){
        this.keys.put("affcity", value);
    }
    
    /**
     * getter for affiliation country
     * @return - object mapped to affiliation country
     */
    public Object getAffiliationCountry(){
        return this.keys.get("affcountry");
    }
    
    /**
     * setter for affiliation country
     * @param value - affiliation country of prize winner
     */
    public void setAffiliationCountry(String value){
        this.keys.put("affcountry", value);
    }
}
