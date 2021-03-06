/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informationexploration;

/**
 * Each search implements this
 * @author Connor
 */
class SearchEntry {
    // These are our  
    
    //What we seatch for
    int ID; 
    String Prize;
    String PrizeYear;
    String Name;
    String Gender;
    String CountryB;
    String CountryD;
    String BYear;
    String DYear;
    //ask about how we are doing date ranges
    
    /**
     * Adds an ID 
     * @param IDent 
     */
    public void addID(int IDent){
        ID = IDent;
    }
    /**
     * Returns the search ID
     * @return ID int
     */
    public int getID(){
        return ID;
    }
    
    /**
     * sets our prize
     * @param P 
     */
    public void addPrize(String P){
        Prize = P;
    }
    /**
     * returns our prize
     * @return Prize string
     */
    public String getPrize(){
        return Prize;
    }
    
    /**
     * sets our prize year
     * @param P 
     */
    public void addPrizeYear(String P){
        PrizeYear = P;
    }
    /**
     * returns our prize year
     * @return Prize string
     */
    public String getPrizeYear(){
        return PrizeYear;
    }
    /**
     * sets our Name
     * @param N 
     */
    public void addName(String N){
        Name = N;
    }
    /**
     * Return our name
     * @return Name string
     */
    public String getName(){
        return Name;
    }

    /**
     * sets the gender sting
     * @param G 
     */
    public void addGender(String G){
        Gender = G;
    }
    /**
     * gets the Gender
     * @return gender string
     */
    public String getGender(){
        return Gender;
    }
    /**
     * set Country
     * @param C 
     */
    public void addCountryB(String C){
        CountryB = C;
    }
    /**
     * get country
     * @return string country
     */
    public String getCountryB(){
        return CountryB;
    }
    
    /**
     * set Country
     * @param C 
     */
    public void addCountryD(String C){
        CountryD = C;
    }
    /**
     * get country
     * @return string country
     */
    public String getCountryD(){
        return CountryD;
    }
    /**
     * set birth year
     * @param B 
     */
    public void addBYear(String B){
        BYear = B;
    }
    /**
     * get birth year
     * @return string Byear
     */
    public String getBYear(){
        return BYear;
    }
    /**
     * Set Death year
     * @param D 
     */
    public void addDYear(String D){
        DYear = D;
    }
    /**
     * get death year
     * @return 
     */
    public String getDYear(){
        return DYear;
    }
}