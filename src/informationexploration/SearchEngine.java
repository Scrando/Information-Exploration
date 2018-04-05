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
    
   void ExicuteSearchByWord(){
       Map   results = new HashMap();
       Map<String,List<Entry>> Searchbase = CDataBase;
        //Check if search area is null 
        //search each
        //CPrize
        if(CPrize == null){
        //don't search here 
        }else{
            for(String key: Searchbase.keySet()){
               List<Entry> n = Searchbase.get(key);
               for( Entry i: n){
                   String check = i.getPrize().toString();
                   System.out.println(check);
                   if(CPrize.contentEquals(check)){
                   //this is where we add to set    
                   }
               }     
            }
        }
        //CName
        if(CName == null){
        //don't search here 
        }else{
            for(String key: Searchbase.keySet()){
               List<Entry> n = Searchbase.get(key);
               for( Entry i: n){
                   String check = i.getName().toString();
                   System.out.println(check); //test
                   if(CName.contentEquals(check)){
                   //this is where we add to set    
                   }
               }     
            }
        }
        //CLongName
        if(CLongName == null){
        //don't search here 
        }else{
            for(String key: Searchbase.keySet()){
               List<Entry> n = Searchbase.get(key);
               for( Entry i: n){
                   String check = i.getLongname().toString();
                   System.out.println(check); //test
                   if(CLongName.contentEquals(check)){
                   //this is where we add to set    
                   }
               }     
            }
        }
        //CGender
        if(CGender == null){
        //don't search here 
        }else{
            for(String key: Searchbase.keySet()){
               List<Entry> n = Searchbase.get(key);
               for( Entry i: n){
                   String check = i.getGender().toString();
                   System.out.println(check); //test
                   if(CGender.contentEquals(check)){
                   //this is where we add to set    
                   }
               }     
            }
        }
        //CCountry
        if(CCountry == null){
        //don't search here 
        }else{
            for(String key: Searchbase.keySet()){
               List<Entry> n = Searchbase.get(key);
               for( Entry i: n){
                   String check = i.getCountry().toString();
                   System.out.println(check); //test
                   if(CCountry.contentEquals(check)){
                   //this is where we add to set    
                   }
               }     
            }
        }
        //CAffil
        if(CGender == null){
        //don't search here 
        }else{
            for(String key: Searchbase.keySet()){
               List<Entry> n = Searchbase.get(key);
               for( Entry i: n){
                   String check = i.getGender().toString();
                   System.out.println(check); //test
                   if(CGender.contentEquals(check)){
                   //this is where we add to set    
                   }
               }     
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



