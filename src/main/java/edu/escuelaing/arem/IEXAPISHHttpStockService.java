package edu.escuelaing.arem;

public class IEXAPISHHttpStockService extends HttpStockService {

    String stock = "fb";
    
    @Override
    public String getDailyURL() {
        return "https://cloud.iexapis.com/stable/tops?token=YOUR_TOKEN_HERE&symbols="+stock;
    }

    @Override
    public void setStock(String stock) {
        this.stock = stock;
        
    }

    @Override
    public String getIntraDayURL() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getWeeklyURL() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getMonthlyURL() {
        // TODO Auto-generated method stub
        return null;
    }
}
