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
    String Name;
    String LongName;
    String Gender;
    String Country;
    String BYear;
    String DYear;
    String Affil;
    
      /**
      * Initiates our search engine 
      * @param DB   
      */
    public static void SearchEntry() {
    }
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
     * sets our long name
     * @param L 
     */
    public void addLName(String L){
        LongName = L;
    }
    /**
     * gets the long name
     * @return long name string
     */
    public String getLNName(){
        return LongName;
    }
    /**
     * sets the gender sting
     * @param G 
     */
    public void addGender(String G){
        Name = G;
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
    public void addCountry(String C){
        Name = C;
    }
    /**
     * get country
     * @return string country
     */
    public String getCountry(){
        return Country;
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
    /**
     * Set Affilation
     * @param A 
     */
    public void addAffil(String A){
        Affil = A;
    }
    /**
     * Set Affiliation
     * @return 
     */
    public String getAff(){
        return Affil;
    }
}     

