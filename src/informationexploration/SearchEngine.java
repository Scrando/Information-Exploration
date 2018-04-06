/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informationexploration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The search engine, each version of search will call this method 
 * @author Connor
 */
public class SearchEngine {
    // These are our  
    
    //storage:             Searchbar:        
    String CPrize;         //"Prize",
    String CName;          //"Name",!
    String CLongName;      //!
    String CGender;        //"Gender",
    String CCountryBirth;  //"Birthplace",, 
    String CCountryDeath;  //"Place of Death"
    String CBYear;         //"Year of Birth",
    String CDYear;         //"Year of Death",
    String CAffil;   
    
    
    
    Extract CurDataBase;//currently saved database
      /**
      * Initiates our search engine   
      */
    public static void SearchEngine() {
        System.out.println("Search Engine online");
        
    }
   //add the database we are looking for 
   void addDatabase(Extract DB){
        CurDataBase = DB;     
   }
   Map ExicuteSearch(){
       int num = 0;
       Map<Integer,List<String>> results = new HashMap(); //ask about this, also make sure no dups
       Extract Database = CurDataBase;
       
       
       if(CName == null){
           System.out.println("No name to search for."); 
       }else{    
           System.out.println("Searching");
           //Check if name in first
           if(Database.firstNameDB.containsKey(CName)){
               for(String n : Database.firstNameDB.keySet()){
                    if(n.equals(CName)){
                        ++num;
                        AddToResults(results,Database.firstNameDB.get(n),num); //This is problem
                        
                    }

               }
               
           }
           //Check if name in second
           if(Database.surNameDB .containsKey(CName)){
               for(String n : Database.surNameDB.keySet()){
                   if(n.equals(CName)){
                       ++num;
                       AddToResults(results,Database.firstNameDB.get(n),num);
                   }
               }
           }
            //for(String n: Database.firstNameDB.containsKey(num)){
               
           //}
       }
       if(CGender == null){}
       if(CPrize == null){}
       if(CPrize == null){}
       if(CPrize == null){}
       if(CPrize == null){}
       if(CPrize == null){}
       if(CPrize == null){}
       if(CPrize == null){}
       
       
       return results; //return 
   } 
   /**
    * This adds to our results
    * @param list
    * @param thing
    * @param currentTime 
    */
   void AddToResults(Map<Integer,List<String>> list, List<String> thing,int currentTime){
       int i = currentTime;
       Integer c;
       c = i;
       list.put(c,thing);
   }
   

   
    void setSearchCrit(SearchEntry ent){
        CPrize = ent.getPrize();
        CName = ent.getName();
        CLongName = ent.getLNName();
        CGender = ent.getGender();
        CCountryBirth = ent.getCountryB();
        CCountryDeath = ent.getCountryD();
        CBYear = ent.getBYear();
        CDYear = ent.getDYear();
        CAffil = ent.getAff();
       
   }
   
    
} 





