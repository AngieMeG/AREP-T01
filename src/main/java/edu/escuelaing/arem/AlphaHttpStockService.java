package edu.escuelaing.arem;

public class AlphaHttpStockService extends HttpStockService {
    String stock = "fb";

    @Override
    public String getURL() {
        return "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=" + stock +"&apikey=0OZUG5LOLD7C1F9N";
    }

    @Override
    public void setStock(String stock) {
        this.stock = stock;
        
    }
    
}
