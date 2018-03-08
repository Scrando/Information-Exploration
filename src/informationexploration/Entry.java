package informationexploration;

/**
 * Test
 * @author Brandon
 */
public class Entry {
	int index = 0;
    private String[] keys = new String[12];
    
    public Entry(){
        return;
    }
    
    public String[] getKeys(){
        return keys;
    }
	
	public void add(String s){
		keys[this.index] = s;
		index++;
		return;
	}
    
	/**
	 * Gets the Year string and returns it.
	 * @return Returns the Year string.
	 */
    public String getYear(){
        return keys[0];
    }
    
    public void setYear(String s){
        keys[0] = s;
        return;
    }
    
	/**
	 * Gets the Year string and returns it.
	 * @return Returns the Year string.
	 */
    public String getPrize(){
        return keys[1];
    }
    
    public void setPrize(String s){
        keys[1] = s;
        return;
    }
    
	/**
	 * Gets the Year string and returns it.
	 * @return Returns the Year string.
	 */
    public String getName(){
        return keys[2];
    }
    
    public void setName(String s){
        keys[2] = s;
        return;
    }
    
	/**
	 * Gets the Year string and returns it.
	 * @return Returns the Year string.
	 */
    public String getLongname(){
        return keys[3];
    }
    
    public void setLongname(String s){
        keys[3] = s;
        return;
    }
    
	/**
	 * Gets the Year string and returns it.
	 * @return Returns the Year string.
	 */
    public String getGender(){
        return keys[4];
    }
    
    public void setGender(String s){
        keys[4] = s;
        return;
    }
    
	/**
	 * Gets the Year string and returns it.
	 * @return Returns the Year string.
	 */
    public String getPhoto(){
        return keys[5];
    }
    
    public void setPhoto(String s){
        keys[5] = s;
        return;
    }
    
	/**
	 * Gets the Year string and returns it.
	 * @return Returns the Year string.
	 */
    public String getCountry(){
        return keys[6];
    }
    
    public void setCountry(String s){
        keys[6] = s;
        return;
    }
    
	/**
	 * Gets the Year string and returns it.
	 * @return Returns the Year string.
	 */
    public String getAffiliation(){
        return keys[7];
    }
    
    public void setAffiliation(String s){
        keys[7] = s;
        return;
    }
    
	/**
	 * Gets the Year string and returns it.
	 * @return Returns the Year string.
	 */
    public String getBirthyear(){
        return keys[8];
    }
    
    public void setBirthyear(String s){
        keys[8] = s;
        return;
    }
    
	/**
	 * Gets the Year string and returns it.
	 * @return Returns the Year string.
	 */
    public String getDeathyear(){
        return keys[9];
    }
    
    public void setDeathyear(String s){
        keys[9] = s;
        return;
    }
    
	/**
	 * Gets the Year string and returns it.
	 * @return Returns the Year string.
	 */
    public String getBiography(){
        return keys[10];
    }
    
    public void setBiography(String s){
        keys[10] = s;
        return;
    }
    
	/**
	 * Gets the Lecture string and returns it.
	 * @return Returns the Lecture string.
	 */
    public String getLecture(){
        return keys[11];
    }
    
    public void setLecture(String s){
        keys[11] = s;
        return;
    }
}
