/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informationexploration;

import java.util.List;
import java.util.Map;






/**
 * The search engine, each version of search will call this method 
 * @author Connor
 */
public class SearchEngine {
    // These are our  
    
    //Current search
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
    
   void ExicuteSearch(){
       Map<String,List<Entry>> Searchbase = CDataBase;
        //Check if search area is null 
        //search each
        if(CPrize == null){
        //don't search here 
        }else{
            for(String key: Searchbase.keySet()){
                //if 
                
               
            }
        }
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



