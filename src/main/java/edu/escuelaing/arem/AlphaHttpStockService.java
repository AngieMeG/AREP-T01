package edu.escuelaing.arem;

public class AlphaHttpStockService extends HttpStockService {
    String stock = "fb";
    private static final String  API_KEY = "0OZUG5LOLD7C1F9N";

    @Override
    public String getDailyURL() {
        return "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=" + stock +"&apikey=" + API_KEY;
    }

    @Override
    public String getIntraDayURL() {
        return "https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=" + stock + "&interval=5min&apikey=" + API_KEY;
    }

    @Override
    public String getWeeklyURL() {
        return "https://www.alphavantage.co/query?function=TIME_SERIES_WEEKLY&symbol=" + stock + "&apikey=" + API_KEY;
    }

    @Override
    public String getMonthlyURL() {
        return "https://www.alphavantage.co/query?function=TIME_SERIES_MONTHLY&symbol=" + stock + "&apikey=" + API_KEY;
    }    

    @Override
    public void setStock(String stock) {
        this.stock = stock;
    }
}
