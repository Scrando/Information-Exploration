package informationexploration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Prize class for the Nobel Database
 * Contains a hash map with key value pairs with a variety
 * of information for each Winner's Prizes
 * @author Brandon
 */
public class Prize {
    private Map keys;
    private List<Affiliation> affs;
    
    /**
     * Creator for Prize object
     */
    public Prize(){
        this.keys = new HashMap();
        this.affs = new ArrayList();
    }
    
    /**
     * Getter for all keys
     * @return - Set of all keys in this entry
     */
    public Set getKeys(){
        return keys.keySet();
    }
    
    /**
     * getter for prize year
     * @return - object mapped to prize year
     */
    public Object getPrizeYear(){
        return this.keys.get("prizeyear");
    }
    
    /**
     * setter for prize year
     * @param value - prize year of prize winner
     */
    public void setPrizeYear(String value){
        this.keys.put("prizeyear", value);
    }
    
    /**
     * getter for prize category
     * @return - object mapped to prize category
     */
    public Object getPrizeCat(){
        return this.keys.get("prizecategory");
    }
    
    /**
     * setter for prize category
     * @param value - prize category of prize winner
     */
    public void setPrizeCat(String value){
        this.keys.put("prizecategory", value);
    }
    
    /**
     * getter for prize motivation
     * @return - object mapped to prize motivation
     */
    public Object getPrizeMotivation(){
        return this.keys.get("prizemotivation");
    }
    
    /**
     * setter for prize motivation
     * @param value - prize motivation of prize winner
     */
    public void setPrizeMotivation(String value){
        this.keys.put("prizemotivation", value);
    }
    
    // ---------------------------------------------------------------- AFFILIATIONS
    
    /**
     * adds a premade affiliation object to the affs list
     * @param aff - affiliation object already created
     */
    public void addAffiliation(Affiliation aff){
        affs.add(aff);
    }
    
    /**
     * returns a affiliation object
     * @return - affiliation at index index
     */
    public Affiliation getAffiliation(int index){
        return affs.get(index);
    }
    
    /**
     * returns a list of affiliations
     * @return - list of Affiliations
     */
    public List<Affiliation> getAffiliations(){
        return affs;
    }
    
    /**
     * returns length of affs
     * @return - length of affs list
     */
    public int affLength(){
        return affs.size();
    }
}
