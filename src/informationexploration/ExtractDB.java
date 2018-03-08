package informationexploration;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Brandon
 */
public class ExtractDB {
    
    private Map<String,List<Entry>> DB = new HashMap();
    
	/**
	 * 
	 * @param filename
	 * @return 
	 */
    public Map ExtractDB(String filename){
        readFile(filename);
        return DB;
    }
	
	/**
	 * 
	 * @param filename 
	 */
	private void readFile(String filename){
        try {
            Scanner inFile = new Scanner (Paths.get(filename));
			String[] keyArray = {"N/A","N/A","N/A","N/A","N/A","N/A","N/A","N/A","N/A","N/A","N/A","N/A"};
            while (inFile.hasNextLine()) {
				String line = inFile.nextLine();
				if(line.equals("")){ // Check if blank line
					Entry tempEntry = new Entry();
					for (String key : keyArray){
						tempEntry.add(key);
					}
                                        
                                        /**
                                         * Test Code
                                         * System.out.println("----------------------------------");
                                         * for (int i = 0; i < keyArray.length; i++){
                                         *  System.out.println(keyArray[i]);
                                         * }
                                         */
					
					addToMap(tempEntry);
					
					for (int i = 0; i < keyArray.length; i++){
						keyArray[i] = "N/A";
					}
					
					}else{
					// More elegant solution than this?
					String[] parts = line.split(" ");
					
                                        String entString = "";
                                        for(int i = 1; i<parts.length; i++){
                                            if (!entString.equals("")){
                                                entString = entString+" "+parts[i];
                                            }else{
                                                entString = parts[i];
                                            }
                                        }
					
					if (parts[0].equals("year:")){
						keyArray[0] = entString;
					}else if (parts[0].equals("prize:")){
						keyArray[1] = entString;
					}else if (parts[0].equals("name:")){
						keyArray[2] = entString;
					}else if (parts[0].equals("longname:")){
						keyArray[3] = entString;
					}else if (parts[0].equals("gender:")){
						keyArray[4] = entString;
					}else if (parts[0].equals("photo:")){
						keyArray[5] = entString;
					}else if (parts[0].equals("country:")){
						keyArray[6] = entString;
					}else if (parts[0].equals("affiliation:")){
						keyArray[7] = entString;
					}else if (parts[0].equals("birthyear:")){
						keyArray[8] = entString;
					}else if (parts[0].equals("deathyear:")){
						keyArray[9] = entString;
					}else if (parts[0].equals("biography:")){
						keyArray[10] = entString;
					}else if (parts[0].equals("lecture:")){
						keyArray[11] = entString;
					}
					
				}
            }
            return;
        } catch (IOException ex) {
            System.out.println ("No Database Found.");
            return;
        }
	}
	
	private void addToMap(Entry ent){
		/**
		 * THIS CLASS IS VERY LONG
		 * Could use input on how
		 * to shorten it.
		 */
		
		String tmpStr = "Affiliation";
		if (!ent.getAffiliation().equals("N/A")){
			List<Entry> tempList = DB.get(tmpStr);
			if (tempList == null){
				tempList = new ArrayList<Entry>();
				DB.put(tmpStr, tempList);
			}
			DB.get(tmpStr).add(ent);
		}
		
		tmpStr = "Biography";
		if (!ent.getBiography().equals("N/A")){
			List<Entry> tempList = DB.get(tmpStr);
			if (tempList == null){
				tempList = new ArrayList<Entry>();
				DB.put(tmpStr, tempList);
			}
			DB.get(tmpStr).add(ent);
		}
		
		tmpStr = "Birth Year";
		if (!ent.getBirthyear().equals("N/A")){
			List<Entry> tempList = DB.get(tmpStr);
			if (tempList == null){
				tempList = new ArrayList<Entry>();
				DB.put(tmpStr, tempList);
			}
			DB.get(tmpStr).add(ent);
		}
		
		tmpStr = "Country";
		if (!ent.getCountry().equals("N/A")){
			List<Entry> tempList = DB.get(tmpStr);
			if (tempList == null){
				tempList = new ArrayList<Entry>();
				DB.put(tmpStr, tempList);
			}
			DB.get(tmpStr).add(ent);
		}
		
		tmpStr = "Death Year";
		if (!ent.getDeathyear().equals("N/A")){
			List<Entry> tempList = DB.get(tmpStr);
			if (tempList == null){
				tempList = new ArrayList<Entry>();
				DB.put(tmpStr, tempList);
			}
			DB.get(tmpStr).add(ent);
		}
		
		tmpStr = "Gender";
		if (!ent.getGender().equals("N/A")){
			List<Entry> tempList = DB.get(tmpStr);
			if (tempList == null){
				tempList = new ArrayList<Entry>();
				DB.put(tmpStr, tempList);
			}
			DB.get(tmpStr).add(ent);
		}
		
		tmpStr = "Lecture";
		if (!ent.getLecture().equals("N/A")){
			List<Entry> tempList = DB.get(tmpStr);
			if (tempList == null){
				tempList = new ArrayList<Entry>();
				DB.put(tmpStr, tempList);
			}
			DB.get(tmpStr).add(ent);
		}
		
		tmpStr = "Long Name";
		if (!ent.getLongname().equals("N/A")){
			List<Entry> tempList = DB.get(tmpStr);
			if (tempList == null){
				tempList = new ArrayList<Entry>();
				DB.put(tmpStr, tempList);
			}
			DB.get(tmpStr).add(ent);
		}
		
		tmpStr = "Name";
		if (!ent.getName().equals("N/A")){
			List<Entry> tempList = DB.get(tmpStr);
			if (tempList == null){
				tempList = new ArrayList<Entry>();
				DB.put(tmpStr, tempList);
			}
			DB.get(tmpStr).add(ent);
		}
		
		tmpStr = "Photo";
		if (!ent.getPhoto().equals("N/A")){
			List<Entry> tempList = DB.get(tmpStr);
			if (tempList == null){
				tempList = new ArrayList<Entry>();
				DB.put(tmpStr, tempList);
			}
			DB.get(tmpStr).add(ent);
		}
		
		tmpStr = "Prize";
		if (!ent.getPrize().equals("N/A")){
			List<Entry> tempList = DB.get(tmpStr);
			if (tempList == null){
				tempList = new ArrayList<Entry>();
				DB.put(tmpStr, tempList);
			}
			DB.get(tmpStr).add(ent);
		}
		
		tmpStr = "Year";
		if (!ent.getYear().equals("N/A")){
			List<Entry> tempList = DB.get(tmpStr);
			if (tempList == null){
				tempList = new ArrayList<Entry>();
				DB.put(tmpStr, tempList);
			}
			DB.get(tmpStr).add(ent);
		}
		
		return;
	}
}
