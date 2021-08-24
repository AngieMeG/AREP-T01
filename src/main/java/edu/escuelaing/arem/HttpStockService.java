package edu.escuelaing.arem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Http Service that consults with an url (relative to an api)
 * makes a connection and gets a response
 * @author Angie Medina
 * @version 3.0
 */
public abstract class HttpStockService{
    private static final String USER_AGENT = "Mozilla/5.0";
    String stock = "fb";

    /**
     * 
     * @param variation Especific resolution to consult in the api 
     * @return The response of the api to the searc
     * @throws IOException MalformedURLException when the pattern of the URL is Invalid, 
     *                     if an I/O exception occurs, 
     * 
     */
    public String timeSeries(String resolution) throws IOException {
        String stringResponse = "None";
        URL obj = new URL(resolveRequest(resolution));
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        
        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            stringResponse = response.toString();
        } else {
            stringResponse = "GET request not worked";
        }
        return stringResponse;
    }

    /**
     * Resolve the reques having in mind the resolutions that are provided by the api
     * @param variation resolution desired to search on the api
     * @return the corresponding URL that it must use to search given the resolution and the stock
     */
    public abstract String resolveRequest(String resolution);

    /**
     * Set the stock symbol the application is going to search
     * @param stock the stock symbol the application is going to search
     */
    public  void setStock(String stock){
        this.stock = stock;
    }
}