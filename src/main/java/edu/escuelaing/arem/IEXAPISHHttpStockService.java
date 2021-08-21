package edu.escuelaing.arem;

public class IEXAPISHHttpStockService extends HttpStockService {

    String stock = "fb";
    
    @Override
    public String getURL() {
        return "https://cloud.iexapis.com/stable/tops?token=YOUR_TOKEN_HERE&symbols="+stock;
    }

    @Override
    public void setStock(String stock) {
        this.stock = stock;
        
    }
    
}
