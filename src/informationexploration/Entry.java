package informationexploration;

import java.util.*;

/**
 * Entry class for the Nobel Database
 * Contains a hash map with key value pairs with a variety
 * of information for each Nobel entry
 * @author Brandon, Nathan
 */
public class Entry {
        private Map keys;
    
    /**
     * Creator for Entry object
     */
    public Entry(){
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
     * getter for year
     * @return - object mapped to year
     */
    public Object getYear(){
        return this.keys.get("year");
    }
    
    /**
     * setter for year
     * @param value - year of Nobel prize
     */
    public void setYear(String value){
        this.keys.put("year", value);
    }
    
    /**
     * getter for prize
     * @return - object mapped to prize
     */
    public Object getPrize(){
        return this.keys.get("prize");
    }
    
    /**
     * setter for prize
     * @param value  - Nobel prize
     */
    public void setPrize(String value){
        this.keys.put("prize", value);
    }
    
    /**
     * getter for name
     * @return - object mapped to name
     */
    public Object getName(){
        return this.keys.get("name");
    }
    
    /**
     * setter for name
     * @param value - name of prize winner
     */
    public void setName(String value){
        this.keys.put("name", value);
    }
    
    /**
     * getter for long name
     * @return - object mapped to long name
     */
    public Object getLongname(){
        return this.keys.get("longname");
    }
    
    /**
     * setter for long name
     * @param value - long name of prize winner
     */
    public void setLongname(String value){
        this.keys.put("longname", value);
    }
    
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
    
    /**
     * getter for photo
     * @return - object mapped to photo
     */
    public Object getPhoto(){
        return this.keys.get("photo");
    }
    
    /**
     * setter for photo
     * @param value - url for photo of prize winner
     */
    public void setPhoto(String value){
        this.keys.put("photo", value);
    }
    
    /**
     * getter for country
     * @return - object mapped to country
     */
    public Object getCountry(){
        return this.keys.get("country");
    }
    
    /**
     * setter for country
     * @param value - country of prize winner
     */
    public void setCountry(String value){
        this.keys.put("country", value);
    }
    
    /**
     * getter for affiliation
     * @return - object mapped to affiliation
     */
    public Object getAffiliation(){
        return this.keys.get("affiliation");
    }
    
    /**
     * setter for affiliation
     * @param value - affiliation of prize winner
     */
    public void setAffiliation(String value){
        this.keys.put("affiliation", value);
    }
    
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
    
    /**
     * getter for biography
     * @return - object mapped to biography
     */
    public Object getBiography(){
        return this.keys.get("biography");
    }
    
    /**
     * setter for biography
     * @param value - biography for prize winner
     */
    public void setBiography(String value){
        this.keys.put("biography", value);
    }
    
    /**
     * getter for lecture
     * @return - object mapped to lecture
     */
    public Object getLecture(){
        return this.keys.get("lecture");
    }
    
    /**
     * setter for lecture
     * @param value - lecture matched to prize winner
     */
    public void setLecture(String value){
        this.keys.put("lecture", value);
    }
}