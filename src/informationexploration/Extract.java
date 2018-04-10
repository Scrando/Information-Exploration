package informationexploration;

import com.sun.javafx.application.LauncherImpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.application.Preloader;
import org.json.*;
import javafx.application.Application;

/**
 * Extracts all Entries from the Nobel Prize database, creates Entry Objects out
 * of them, then adds them to a number of maps to be used for searching
 * @author Brandon
 */
public class Extract {
    public Map<String,Entry> idDB = new HashMap();
    public Map<String,List<String>> firstNameDB = new HashMap();
    public Map<String,List<String>> surNameDB = new HashMap();
    public Map<String,List<String>> bornDB = new HashMap();
    public Map<String,List<String>> diedDB = new HashMap();
    public Map<String,List<String>> bornYearDB = new HashMap();
    public Map<String,List<String>> diedYearDB = new HashMap();
    public Map<String,List<String>> bornCountryDB = new HashMap();
    public Map<String,List<String>> diedCountryDB = new HashMap();
    public Map<String,List<String>> genderDB = new HashMap();
    public Map<String,List<String>> prizeYearDB = new HashMap();
    public Map<String,List<String>> prizeCategoryDB = new HashMap();
    
    /**
     * Creates the Entry objects and calls addToMaps
     * @param NobelUI - application object for call to preload loading screen updates
     */
    public void Extract(Application NobelUI){
        try{
            
            //progress output for preload screen
            int progress = 5;
            LauncherImpl.notifyPreloader(NobelUI, new Preloader.ProgressNotification(progress));
            
            // Opens JSON website and creates a JSON object 
            URL url = new URL("http://api.nobelprize.org/v1/laureate.json");
            URLConnection con = url.openConnection();
            InputStream is =con.getInputStream();
            
            //progress output for preload screen
            progress += 5;
            LauncherImpl.notifyPreloader(NobelUI, new Preloader.ProgressNotification(progress));
            
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = new String();
            String tempLine;
            while ((tempLine = br.readLine()) != null) {
                line += tempLine;
            }
            br.close();
            
            //progress output for preload screen
            progress += 5;
            LauncherImpl.notifyPreloader(NobelUI, new Preloader.ProgressNotification(progress));
            
            JSONObject obj = new JSONObject(line);
            // Find number of Array entries
            int len = obj.getJSONArray("laureates").length();
            
            // Create all DB entries and append them to the maps using addToMaps
            for (int i = 0; i<len; i++){
                
                
                progress = ((i*100)/len);
                LauncherImpl.notifyPreloader(NobelUI, new Preloader.ProgressNotification(progress));
                Entry tmpEntry = new Entry();
                
                // Add id to Entry
                tmpEntry.setId(obj.getJSONArray("laureates").getJSONObject(i).getString("id"));
                
                // Check if the Array at index i has the firstname key
                if(obj.getJSONArray("laureates").getJSONObject(i).has("firstname")){
                    tmpEntry.setFirstName(obj.getJSONArray("laureates").getJSONObject(i).getString("firstname"));
                }else{
                    tmpEntry.setFirstName("");
                }
                
                // Check if the Array at index i has the surname key
                if(obj.getJSONArray("laureates").getJSONObject(i).has("surname")){
                    tmpEntry.setLastName(obj.getJSONArray("laureates").getJSONObject(i).getString("surname"));
                }else{
                    tmpEntry.setLastName("");
                }
                
                // Check if Death year is blank (When the winner is an institution)
                if(obj.getJSONArray("laureates").getJSONObject(i).getString("born").equals("0000-00-00")){
                    tmpEntry.setBirthyear("");
                }else{
                    tmpEntry.setBirthyear(obj.getJSONArray("laureates").getJSONObject(i).getString("born"));
                }
                
                // Check if Death year is blank (When the winner is an institution)
                if(obj.getJSONArray("laureates").getJSONObject(i).getString("died").equals("0000-00-00")){
                    tmpEntry.setDeathyear("");
                }else{
                    tmpEntry.setDeathyear(obj.getJSONArray("laureates").getJSONObject(i).getString("died"));
                }
                
                // Add born Country, Country Code, and City
                // Check if the Array at index i has the bornCountry key (When the winner is an institution)
                if(obj.getJSONArray("laureates").getJSONObject(i).has("bornCountry")){ 
                    tmpEntry.setBornCountry(obj.getJSONArray("laureates").getJSONObject(i).getString("bornCountry"));
                }else{
                    tmpEntry.setBornCountry("");
                }
                // Check if the Array at index i has the bornCountryCode key (When the winner is an institution)
                if(obj.getJSONArray("laureates").getJSONObject(i).has("bornCountryCode")){
                    tmpEntry.setBornCountryCode(obj.getJSONArray("laureates").getJSONObject(i).getString("bornCountryCode"));
                }else{
                    tmpEntry.setBornCountryCode("");
                }
                // Check if the Array at index i has the bornCity key (When the winner is an institution)
                if(obj.getJSONArray("laureates").getJSONObject(i).has("bornCity")){
                    tmpEntry.setBornCity(obj.getJSONArray("laureates").getJSONObject(i).getString("bornCity"));
                }else{
                    tmpEntry.setBornCity("");
                }
                
                // Add death Country, Country Code, and City
                // Check if the Array at index i has the diedCountry key (When the winner is an institution)
                if(obj.getJSONArray("laureates").getJSONObject(i).has("diedCountry")){
                    tmpEntry.setDeathCountry(obj.getJSONArray("laureates").getJSONObject(i).getString("diedCountry"));
                }else{
                    tmpEntry.setDeathCountry("");
                }
                // Check if the Array at index i has the diedCountryCode key (When the winner is an institution)
                if(obj.getJSONArray("laureates").getJSONObject(i).has("diedCountryCode")){
                    tmpEntry.setDeathCountryCode(obj.getJSONArray("laureates").getJSONObject(i).getString("diedCountryCode"));
                }else{
                    tmpEntry.setDeathCountryCode("");
                }
                // Check if the Array at index i has the diedCity key (When the winner is an institution)
                if(obj.getJSONArray("laureates").getJSONObject(i).has("diedCity")){
                    tmpEntry.setDeathCity(obj.getJSONArray("laureates").getJSONObject(i).getString("diedCity"));
                }else{
                    tmpEntry.setDeathCity("");
                }
                
                // Add gender to Entry
                tmpEntry.setGender(obj.getJSONArray("laureates").getJSONObject(i).getString("gender"));
                
                try{
                    // Must now loop through prize Array
                    JSONArray prizeArray = obj.getJSONArray("laureates").getJSONObject(i).getJSONArray("prizes");
                    // Find number of Prize entries
                    int tempLen = prizeArray.length();
                    for (int n = 0; n<tempLen; n++){
                        Prize tmpPrize = new Prize();

                        // Add Year to Prize
                        if(prizeArray.getJSONObject(n).has("year")){
                            tmpPrize.setPrizeYear(prizeArray.getJSONObject(n).getString("year"));
                        }else{
                            tmpPrize.setPrizeYear("");
                        }

                        // Add Category to Prize
                        if(prizeArray.getJSONObject(n).has("category")){
                            tmpPrize.setPrizeCat(prizeArray.getJSONObject(n).getString("category"));
                        }else{
                            tmpPrize.setPrizeCat("");
                        }

                        // Add Motivation to Prize
                        if(prizeArray.getJSONObject(n).has("motivation")){
                            tmpPrize.setPrizeMotivation(prizeArray.getJSONObject(n).getString("motivation"));
                        }else{
                            tmpPrize.setPrizeMotivation("");
                        }
                        try{
                            // Must now loop through affiliation Array
                            JSONArray affArray = prizeArray.getJSONObject(n).getJSONArray("affiliations");
                            // Find number of Prize entries
                            int tempLen2 = affArray.length();
                            for (int z = 0; z<tempLen2; z++){
                                Affiliation tmpAff = new Affiliation();

                                // Add Name to Affiliation
                                if(affArray.getJSONObject(z).has("name")){
                                    tmpAff.setAffiliationName(affArray.getJSONObject(z).getString("name"));
                                }else{
                                    tmpAff.setAffiliationName("");
                                }

                                // Add City to Affiliation
                                if(affArray.getJSONObject(z).has("city")){
                                    tmpAff.setAffiliationCity(affArray.getJSONObject(z).getString("city"));
                                }else{
                                    tmpAff.setAffiliationCity("");
                                }

                                // Add Country to Affiliation
                                if(affArray.getJSONObject(z).has("country")){
                                    tmpAff.setAffiliationName(affArray.getJSONObject(z).getString("country"));
                                }else{
                                    tmpAff.setAffiliationCountry("");
                                }

                                tmpPrize.addAffiliation(tmpAff);
                            }
                        } catch(JSONException e){
                            // Blank Affiliation Array
                        }
                        tmpEntry.addPrize(tmpPrize);
                    }
                }catch (JSONException e){
                    // Blank Prize Array
                }
                // Entry should be fully created
                
                addToMaps(tmpEntry);
                
            }
            
            
            
        } catch (IOException e){
            System.err.println("Caught IOException: " + e.getMessage());
        }
    }
    
    /**
     * Adds entry ent to the maps defined at the top of the class
     * @param ent - Entry object
     */
    private void addToMaps(Entry ent){
        // idDB
        if (!ent.getId().equals("")){
            idDB.put(ent.getId().toString(), ent);
        }
        
        // firstNameDB
        String tmpStr = ent.getFirstName().toString().toLowerCase();
        if (!tmpStr.equals("")){
            List<String> tmpList = firstNameDB.get(tmpStr);
            if (tmpList == null){
                tmpList = new ArrayList<>();
                firstNameDB.put(tmpStr, tmpList);
            }
            firstNameDB.get(tmpStr).add(ent.getId().toString());
        }
        
        // surNameDB
        tmpStr = ent.getLastName().toString().toLowerCase();
        if (!tmpStr.equals("")){
            List<String> tmpList = surNameDB.get(tmpStr);
            if (tmpList == null){
                tmpList = new ArrayList<>();
                surNameDB.put(tmpStr, tmpList);
            }
            surNameDB.get(tmpStr).add(ent.getId().toString());
        }
        
        // bornDB
        tmpStr = ent.getBirthyear().toString().toLowerCase();
        if (!tmpStr.equals("")){
            List<String> tmpList = bornDB.get(tmpStr);
            if (tmpList == null){
                tmpList = new ArrayList<>();
                bornDB.put(tmpStr, tmpList);
            }
            bornDB.get(tmpStr).add(ent.getId().toString());
        }
        
        // diedDB
        tmpStr = ent.getDeathyear().toString().toLowerCase();
        if (!tmpStr.equals("")){
            List<String> tmpList = diedDB.get(tmpStr);
            if (tmpList == null){
                tmpList = new ArrayList<>();
                diedDB.put(tmpStr, tmpList);
            }
            diedDB.get(tmpStr).add(ent.getId().toString());
        }
        
        // bornYearDB
        tmpStr = ent.getSmallBirthyear().toString();
        if (!tmpStr.equals("")){
            List<String> tmpList = bornYearDB.get(tmpStr);
            if (tmpList == null){
                tmpList = new ArrayList<>();
                bornYearDB.put(tmpStr, tmpList);
            }
            bornYearDB.get(tmpStr).add(ent.getId().toString());
        }
        
        // diedYearDB
        tmpStr = ent.getSmallDeathyear().toString();
        if (!tmpStr.equals("")){
            List<String> tmpList = diedYearDB.get(tmpStr);
            if (tmpList == null){
                tmpList = new ArrayList<>();
                diedYearDB.put(tmpStr, tmpList);
            }
            diedYearDB.get(tmpStr).add(ent.getId().toString());
        }
        
        // bornCountryDB
        tmpStr = ent.getBornCountry().toString().toLowerCase();
        if (!tmpStr.equals("")){
            List<String> tmpList = bornCountryDB.get(tmpStr);
            if (tmpList == null){
                tmpList = new ArrayList<>();
                bornCountryDB.put(tmpStr, tmpList);
            }
            bornCountryDB.get(tmpStr).add(ent.getId().toString());
        }
        
        // diedCountryDB
        tmpStr = ent.getDeathCountry().toString().toLowerCase();
        if (!tmpStr.equals("")){
            List<String> tmpList = diedCountryDB.get(tmpStr);
            if (tmpList == null){
                tmpList = new ArrayList<>();
                diedCountryDB.put(tmpStr, tmpList);
            }
            diedCountryDB.get(tmpStr).add(ent.getId().toString());
        }
        
        // genderDB
        tmpStr = ent.getGender().toString().toLowerCase();
        if (!tmpStr.equals("")){
            List<String> tmpList = genderDB.get(tmpStr);
            if (tmpList == null){
                tmpList = new ArrayList<>();
                genderDB.put(tmpStr, tmpList);
            }
            genderDB.get(tmpStr).add(ent.getId().toString());
        }
        
        // prizeYearDB
        if (ent.getPrizeYears() != null){
            List<String> years = ent.getPrizeYears();
            for (String year : years){
                List<String> tmpList = prizeYearDB.get(year);
                if (tmpList == null){
                    tmpList = new ArrayList<>();
                    prizeYearDB.put(year, tmpList);
                }
                prizeYearDB.get(year).add(ent.getId().toString());
            }
        }
        // prizeCategoryDB
        if (ent.getPrizeCats() != null){
            List<String> cats = ent.getPrizeCats();
            for (String cat : cats){
                List<String> tmpList = prizeCategoryDB.get(cat);
                if (tmpList == null){
                    tmpList = new ArrayList<>();
                    prizeCategoryDB.put(cat, tmpList);
                }
                prizeCategoryDB.get(cat).add(ent.getId().toString());
            }
        }
    }
}
