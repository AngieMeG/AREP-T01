package edu.escuelaing.arem;

/**
 * Http Service that consults with an url (relative to the IEX CLOUD API) that
 * makes a connection and gets a response
 * @author Angie Medina
 * @version 3.0
 */
public class IEXHttpStockService extends HttpStockService{

    private static final String  API_KEY = "pk_97a04fc5241142baa4613ff96836e266";

    @Override
    public String resolveRequest(String resolution){
        return "https://cloud.iexapis.com/stable/tops?token=" + API_KEY +"&symbols=" + stock;
    }
    
}
