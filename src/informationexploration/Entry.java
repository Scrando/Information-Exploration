package informationexploration;

import java.util.*;

/**
 * Entry class for the Nobel Database
 * Contains a hash map with key value pairs with a variety
 * of information for each Nobel entry
 * @author Brandon, Nathan
 */
public class Entry {
    private final Map keys;
    private final List<Prize> prizes;
    
    /**
     * Creator for Entry object
     */
    public Entry(){
        this.keys = new HashMap();
        this.prizes = new ArrayList();
    }
    
    /**
     * Getter for all keys
     * @return - Set of all keys in this entry
     */
    public Set getKeys(){
        return keys.keySet();
    }
    
    // ---------------------------------------------------------------- ID
    
    /**
     * getter for id
     * @return - object mapped to id
     */
    public Object getId(){
        return this.keys.get("id");
    }
    
    /**
     * setter for id
     * @param value - id of Nobel prize entry
     */
    public void setId(String value){
        this.keys.put("id", value);
    }
    
    // ---------------------------------------------------------------- NAME
    
    /**
     * getter for first name
     * @return - object mapped to first name
     */
    public Object getFirstName(){
        return this.keys.get("firstname");
    }
    
    /**
     * setter for first name
     * @param value - name of prize winner
     */
    public void setFirstName(String value){
        this.keys.put("firstname", value);
    }
    
    /**
     * getter for last name
     * @return - object mapped to first name
     */
    public Object getLastName(){
        return this.keys.get("lastname");
    }
    
    /**
     * setter for last name
     * @param value - name of prize winner
     */
    public void setLastName(String value){
        this.keys.put("lastname", value);
    }
    
    /**
     * getter for long name
     * @return - object mapped to long name
     */
    public Object getLongname(){
        return this.keys.get("firstname") + " " + this.keys.get("lastname");
    }
    
    // ---------------------------------------------------------------- BIRTH/DEATH YEARS
    
    /**
     * getter for birth year
     * @return - object mapped to birth year
     */
    public Object getBirthyear(){
        return this.keys.get("birthyear");
    }
    
    /**
     * setter for birth year
     * @param value - birth year of prize winner
     */
    public void setBirthyear(String value){
        this.keys.put("birthyear", value);
    }
    
    /**
     * getter for death year
     * @return - object mapped to death year
     */
    public Object getDeathyear(){
        return this.keys.get("deathyear");
    }
    
    /**
     * setter for death year
     * @param value - death year of prize winner
     */
    public void setDeathyear(String value){
        this.keys.put("deathyear", value);
    }
    
    // ---------------------------------------------------------------- BIRTH PLACE
    
    /**
     * getter for born country
     * @return - object mapped to born country
     */
    public Object getBornCountry(){
        return this.keys.get("borncountry");
    }
    
    /**
     * setter for born country
     * @param value - birth country of prize winner
     */
    public void setBornCountry(String value){
        this.keys.put("borncountry", value);
    }
    
    /**
     * getter for born country code
     * @return - object mapped to born country code
     */
    public Object getBornCountryCode(){
        return this.keys.get("borncountrycode");
    }
    
    /**
     * setter for born country code
     * @param value - birth country code of prize winner
     */
    public void setBornCountryCode(String value){
        this.keys.put("borncountrycode", value);
    }
    
    /**
     * getter for born city
     * @return - object mapped to born city
     */
    public Object getBornCity(){
        return this.keys.get("borncity");
    }
    
    /**
     * setter for born city
     * @param value - birth city of prize winner
     */
    public void setBornCity(String value){
        this.keys.put("borncity", value);
    }
    
    // ---------------------------------------------------------------- DEATH PLACE
    
    /**
     * getter for death country
     * @return - object mapped to death country
     */
    public Object getDeathCountry(){
        return this.keys.get("deathcountry");
    }
    
    /**
     * setter for death country
     * @param value - death country of prize winner
     */
    public void setDeathCountry(String value){
        this.keys.put("deathcountry", value);
    }
    
    /**
     * getter for death country code
     * @return - object mapped to death country code
     */
    public Object getDeathCountryCode(){
        return this.keys.get("deathcountrycode");
    }
    
    /**
     * setter for death country code
     * @param value - death country code of prize winner
     */
    public void setDeathCountryCode(String value){
        this.keys.put("deathcountrycode", value);
    }
    
    /**
     * getter for death city
     * @return - object mapped to death city
     */
    public Object getDeathCity(){
        return this.keys.get("deathcity");
    }
    
    /**
     * setter for death city
     * @param value - death city of prize winner
     */
    public void setDeathCity(String value){
        this.keys.put("deathcity", value);
    }
    
    // ---------------------------------------------------------------- GENDER
    
    /**
     * getter for gender
     * @return - object mapped to gender
     */
    public Object getGender(){
        return this.keys.get("gender");
    }
    
    /**
     * setter for gender
     * @param value - gender of prize winner
     */
    public void setGender(String value){
        this.keys.put("gender", value);
    }
    
    // ---------------------------------------------------------------- PRIZE
    
    /**
     * adds a premade prize object to the prize list
     * @param prize - prize object already created
     */
    public void addPrize(Prize prize){
        prizes.add(prize);
    }
    
    /**
     * returns a prize object
     * @param index
     * @return - prize at index index
     */
    public Prize getPrize(int index){
        return prizes.get(index);
    }
    
    /**
     * returns a list of prizes
     * @return - list of Prizes
     */
    public List<Prize> getPrizes(){
        return prizes;
    }
    
    /**
     * returns length of prizes
     * @return - length of prizes list
     */
    public int prizeLength(){
        return prizes.size();
    }
    
    // ---------------------------------------------------------------- SEARCH KEYS
    /**
     * returns a list of prize years for the current entry
     * @return - list of prize years
     */
    public List<String> getPrizeYears(){
        List<String> years = new ArrayList();
        for(Prize prize : prizes){
            String tmpString = prize.getPrizeYear().toString();
            if (!years.contains(tmpString)){
                years.add(tmpString);
            }
        }
        return years;
    }
    
    /**
     * returns a list of prize categories for the current entry
     * @return - list of prize categories
     */
    public List<String> getPrizeCats(){
        List<String> cats = new ArrayList();
        for(Prize prize : prizes){
            String tmpString = prize.getPrizeCat().toString();
            if (!cats.contains(tmpString)){
                cats.add(tmpString);
            }
        }
        return cats;
    }
}