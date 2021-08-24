package edu.escuelaing.arem;

import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Unit test for simple App.
 * @author Angie Medina
 */
public class AppTest{
    /**
     * Test if the url of the welcome page is working
     */
    @Test
    public void shouldFindWelcomePage(){
        String urlString = "https://time-series-stock.herokuapp.com";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new URL(urlString + "/index.html").openStream()));
        } catch (IOException e) {
            fail("Resource: " + urlString + " was not found");
        }
    }

    /**
     * Test if the url of the welcome script is working
     */
    @Test
    public void shouldFindWelcomeScript(){
        String urlString = "https://time-series-stock.herokuapp.com";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new URL(urlString + "/js/indexScript.js").openStream()));
        } catch (IOException e) {
            fail("Resource: " + urlString + " was not found");
        }
    }

    /**
     * Test if the url of the consult page is working
     */
    @Test
    public void shouldFindConsultPage(){
        String urlString = "https://time-series-stock.herokuapp.com";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new URL(urlString + "/consult.html").openStream()));
        } catch (IOException e) {
            fail("Resource: " + urlString + " was not found");
        }
    }

    /**
     * Test if the url of the consult script is working
     */
    @Test
    public void shouldFindConsultScript(){
        String urlString = "https://time-series-stock.herokuapp.com";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new URL(urlString + "/js/consultScript.js").openStream()));
        } catch (IOException e) {
            fail("Resource: " + urlString + " was not found");
        }
    }

    /**
     * Test if one request is valid for the api
     */
    @Test
    public void shouldReturnInfo(){
        String urlString = "https://time-series-stock.herokuapp.com";
        String stock = "IBM";
        try {
            BufferedReader buferedReader = new BufferedReader(new InputStreamReader(new URL(urlString + "/consult?id=" + stock +"&var=Daily").openStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = buferedReader.readLine()) != null) {
                response.append(inputLine);
            }
            buferedReader.close();
            if((response.toString().indexOf("Invalid API call")) != -1){
                fail("The response is empty.");
            }
        } catch (IOException e) {
            fail("Resource: " + urlString + " was not found");
        }
    }

    /**
     * Test if one request is invalid for the api
     */
    @Test
    public void shouldNotReturnInfo(){
        String urlString = "https://time-series-stock.herokuapp.com";
        String stock = "aslhashk";
        try {
            BufferedReader buferedReader = new BufferedReader(new InputStreamReader(new URL(urlString + "/consult?id=" + stock +"&var=Daily").openStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = buferedReader.readLine()) != null) {
                response.append(inputLine);
            }
            buferedReader.close();
            if((response.toString().indexOf("Invalid API call")) == -1){
                fail("The response wasnt empty.");
            }
        } catch (IOException e) {
            fail("Resource: " + urlString + " was not found");
        }
    }

    /**
     * Test if the request was made to the Daily resolution of the api
     */
    /*
    @Test
    public void shouldConsultDailyResolution(){
        String urlString = "https://time-series-stock.herokuapp.com";
        String stock = "IBM";
        try {
            BufferedReader buferedReader = new BufferedReader(new InputStreamReader(new URL(urlString + "/consult?id=" + stock +"&var=Daily").openStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = buferedReader.readLine()) != null) {
                response.append(inputLine);
            }
            buferedReader.close();
            String responseString = response.toString();
            if((responseString.indexOf("Invalid API call")) != -1){
                fail("The response was empty.");
            }
            if((responseString.indexOf("Daily")) == -1){
                fail("The app doesn't call the Daily Series.");
            }
        } catch (IOException e) {
            fail("Resource: " + urlString + " was not found");
        }
    }
    */

    /**
     * Test if the request was made to the Intra Day resolution of the api
     */
    /*
    @Test
    public void shouldConsultIntraDayResolution(){
        String urlString = "https://time-series-stock.herokuapp.com";
        String stock = "IBM";
        try {
            BufferedReader buferedReader = new BufferedReader(new InputStreamReader(new URL(urlString + "/consult?id=" + stock +"&var=IntraDay").openStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = buferedReader.readLine()) != null) {
                response.append(inputLine);
            }
            buferedReader.close();
            String responseString = response.toString();
            if((responseString.indexOf("Invalid API call")) != -1){
                fail("The response was empty.");
            }
            if((responseString.indexOf("Intraday")) == -1){
                fail("The app doesn't call the Intraday Series.");
            }
        } catch (IOException e) {
            fail("Resource: " + urlString + " was not found");
        }
    }
    */

    /**
     * Test if the request was made to the weekly resolution of the api
     */
    /*
    @Test
    public void shouldConsultWeeklyResolution(){
        String urlString = "https://time-series-stock.herokuapp.com";
        String stock = "IBM";
        try {
            BufferedReader buferedReader = new BufferedReader(new InputStreamReader(new URL(urlString + "/consult?id=" + stock +"&var=Weekly").openStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = buferedReader.readLine()) != null) {
                response.append(inputLine);
            }
            buferedReader.close();
            String responseString = response.toString();
            if((responseString.indexOf("Invalid API call")) != -1){
                fail("The response was empty.");
            }
            if((responseString.indexOf("Weekly")) == -1){
                fail("The app doesn't call the Weekly Series.");
            }
        } catch (IOException e) {
            fail("Resource: " + urlString + " was not found");
        }
    }
    */

    /**
     * Test if the request was made to the monthly resolution of the api
     */
    /*
    @Test
    public void shouldConsultMonthlyResolution(){
        String urlString = "https://time-series-stock.herokuapp.com";
        String stock = "IBM";
        try {
            BufferedReader buferedReader = new BufferedReader(new InputStreamReader(new URL(urlString + "/consult?id=" + stock +"&var=Monthly").openStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = buferedReader.readLine()) != null) {
                response.append(inputLine);
            }
            buferedReader.close();
            String responseString = response.toString();
            System.out.println(responseString);
            if((responseString.indexOf("Invalid API call")) != -1){
                fail("The response was empty.");
            }
            if((responseString.indexOf("Monthly")) == -1){
                fail("The app doesn't call the Monthly Series.");
            }
        } catch (IOException e) {
            fail("Resource: " + urlString + " was not found");
        }
    }*/
}
