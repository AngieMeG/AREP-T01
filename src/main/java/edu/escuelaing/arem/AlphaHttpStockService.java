package edu.escuelaing.arem;

/**
 * Http Service that consults with an url (relative to the ALPHA VENTAHGE API) that
 * makes a connection and gets a response
 * @author Angie Medina
 * @version 3.0
 */
public class AlphaHttpStockService extends HttpStockService {
    private static final String  API_KEY = "0OZUG5LOLD7C1F9N";

    @Override
    public String resolveRequest(String resolution){
        String url = "";
        if(resolution.equals("Daily")) url = getDailyURL();
        else if(resolution.equals("IntraDay")) url = getIntraDayURL();
        else if(resolution.equals("Weekly")) url = getWeeklyURL();
        else if(resolution.equals("Monthly")) url = getMonthlyURL();
        return url;
    }

    /**
     * @return the correct url to the Daily resolution of the Alpha Ventage API
     */
    public String getDailyURL() {
        return "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=" + stock +"&apikey=" + API_KEY;
    }

    /**
     * @return the correct url to the Intra Day resolution of the Alpha Ventage API
     */
    public String getIntraDayURL() {
        return "https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=" + stock + "&interval=5min&apikey=" + API_KEY;
    }

    /**
     * @return the correct url to the Weekly resolution of the Alpha Ventage API
     */
    public String getWeeklyURL() {
        return "https://www.alphavantage.co/query?function=TIME_SERIES_WEEKLY&symbol=" + stock + "&apikey=" + API_KEY;
    }

    /**
     * @return the correct url to the Monthly resolution of the Alpha Ventage API
     */
    public String getMonthlyURL() {
        return "https://www.alphavantage.co/query?function=TIME_SERIES_MONTHLY&symbol=" + stock + "&apikey=" + API_KEY;
    }    
}
