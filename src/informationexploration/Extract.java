package informationexploration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Brandon
 */
public class Extract {
    
    public void Extract(){
        try{
            URL url = new URL("http://api.nobelprize.org/v1/laureate.json");
            URLConnection con = url.openConnection();
            InputStream is =con.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String line = null;
    
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e){
            System.err.println("Caught IOException: " + e.getMessage());
        }
        
        
    }
    
}
