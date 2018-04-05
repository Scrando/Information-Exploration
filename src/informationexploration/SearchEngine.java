/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informationexploration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Entry has 
id
first name
last name
long name
birth year
death year
born country
born city
death country
death city
gender
prize list
prize years
prize categories
*/




/**
 * The search engine, each version of search will call this method 
 * @author Connor
 */
public class SearchEngine {
    // These are our  
    
    //Current search !!NEED TO EXPAND!!
    String CPrize;
    String CName;
    String CLongName;
    String CGender;
    String CCountry;
    String CBYear;
    String CDYear;
    String CAffil;
    Map<String,List<Entry>> CDataBase; //currently saved database
    
      /**
      * Initiates our search engine   
      */
    public static void SearchEngine() {
        System.out.println("Search Engine online");
        
    }
   //add the database we are looking for 
   void addDatabase(Map<String,List<Entry>> DB){
        CDataBase = DB;     
   }
   Map ExicuteSearch(){
       int num = 0;
       Map<Integer,Entry> results = new HashMap(); //ask about this, also make sure no dups
       Map<String,List<Entry>> Searchbase = CDataBase;
       if(CName == null){
        //don't search here 
        }else{
            for(String key: Searchbase.keySet()){
               List<Entry> n = Searchbase.get(key);
               for( Entry currentData: n){
                   String check = currentData.getLongname().toString();  //Prizes or prize?
                   System.out.println(check);
                   
                   //here we go into 
                   
                   if(CPrize.equals(check)){
                    ++num;   
                    //this is where we add to set  
                    AddToResults(results,currentData,num);  
                   }
               }     
            }
        }
       
       
       
       
       return results; //return 
   } 
   /**
    * This adds to our results
    * @param list
    * @param thing
    * @param currentTime 
    */
   void AddToResults(Map<Integer,Entry> list, Entry thing,int currentTime){
       int i = currentTime;
       Integer c;
       c = i;
       list.put(c, thing);
   }
   

   
    void setSearchCrit(SearchEntry ent){
        CPrize = ent.getPrize();
        CName = ent.getName();
        CLongName = ent.getLNName();
        CGender = ent.getGender();
        CCountry = ent.getCountry();
        CBYear = ent.getBYear();
        CDYear = ent.getDYear();
        CAffil = ent.getAff();
       
   }
   
    
} 
