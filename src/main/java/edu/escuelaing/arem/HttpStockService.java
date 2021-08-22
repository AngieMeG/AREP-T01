package edu.escuelaing.arem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public abstract class HttpStockService{
    private static final String USER_AGENT = "Mozilla/5.0";

    public String timeSeries(String variation) throws IOException{
        String stringResponse = "None";
        String url = "";
        if(variation.equals("Daily")) url = getDailyURL();
        else if(variation.equals("IntraDay")) url = getIntraDayURL();
        else if(variation.equals("Weekly")) url = getWeeklyURL();
        else if(variation.equals("Monthly")) url = getMonthlyURL();
        URL obj = new URL(url);
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

            // print result
            stringResponse = response.toString();
        } else {
            stringResponse = "GET request not worked";
        }
        return stringResponse;
    }

    public abstract String getDailyURL();

    public abstract String getIntraDayURL();

    public abstract String getWeeklyURL();

    public abstract String getMonthlyURL();

    public abstract void setStock(String stock);
}