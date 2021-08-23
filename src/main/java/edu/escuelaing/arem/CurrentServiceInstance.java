package edu.escuelaing.arem;


/**
 * Singleton to handle the HTTP Service
 * @author Angie Medina
 * @version 1.0
 */
public class CurrentServiceInstance {
    private static CurrentServiceInstance _instance = new CurrentServiceInstance();
    private HttpStockService service;

    /**
     * Set the kind of service
     */
    private CurrentServiceInstance(){
        service = new AlphaHttpStockService();
    }

    /**
     * @return the current instance of the service
     */
    public static CurrentServiceInstance getInstance() {
        return _instance;
    }

    /**
     * @return the current kind of service
     */
    public HttpStockService getService(){
        return service;
    }
}
