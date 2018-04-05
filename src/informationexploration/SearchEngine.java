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
       Map<String,Entry> results = new HashMap(); //ask about this, also make sure no dups
       Map<String,List<Entry>> Searchbase = CDataBase;
       if(CPrize == null){
        //don't search here 
        }else{
            for(String key: Searchbase.keySet()){
               List<Entry> n = Searchbase.get(key);
               for( Entry i: n){
                   String check = i.getPrizes().toString();  //Prizes or prize?
                   System.out.println(check);
                   
                   //here we go into 
                   
                   if(CPrize.contentEquals(check)){
                   //this is where we add to set    
                   }
               }     
            }
        }
       
       
       
       
       return results; //return 
   } 
   
   
   
   void ExicuteSearchByWord(){} 
   void ExicuteSearchByDate(){}
   
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



