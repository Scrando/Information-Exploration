package informationexploration;

/**
 *
 * @author Brandon
 */
public class Entry {
    private String[] keys = {"N/A","N/A","N/A","N/A","N/A","N/A","N/A","N/A","N/A","N/A","N/A","N/A"};
    
    public Entry(){
        return;
    }
    
    public String[] getKeys(){
        return keys;
    }
    
    public String getYear(){
        return keys[0];
    }
    
    public void setYear(String s){
        keys[0] = s;
        return;
    }
    
    public String getPrize(){
        return keys[1];
    }
    
    public void setPrize(String s){
        keys[1] = s;
        return;
    }
    
    public String getName(){
        return keys[2];
    }
    
    public void setName(String s){
        keys[2] = s;
        return;
    }
    
    public String getLongname(){
        return keys[3];
    }
    
    public void setLongname(String s){
        keys[3] = s;
        return;
    }
    
    public String getGender(){
        return keys[4];
    }
    
    public void setGender(String s){
        keys[4] = s;
        return;
    }
    
    public String getPhoto(){
        return keys[5];
    }
    
    public void setPhoto(String s){
        keys[5] = s;
        return;
    }
    
    public String getCountry(){
        return keys[6];
    }
    
    public void setCountry(String s){
        keys[6] = s;
        return;
    }
    
    public String getAffiliation(){
        return keys[7];
    }
    
    public void setAffiliation(String s){
        keys[7] = s;
        return;
    }
    
    public String getBirthyear(){
        return keys[8];
    }
    
    public void setBirthyear(String s){
        keys[8] = s;
        return;
    }
    
    public String getDeathyear(){
        return keys[9];
    }
    
    public void setDeathyear(String s){
        keys[9] = s;
        return;
    }
    
    public String getBiography(){
        return keys[10];
    }
    
    public void setBiography(String s){
        keys[10] = s;
        return;
    }
    
    public String getLecture(){
        return keys[11];
    }
    
    public void setLecture(String s){
        keys[11] = s;
        return;
    }
}
