package edu.escuelaing.arem;
import spark.Request;
import spark.Response;
import static spark.Spark.*;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Java Spark Client
 * @author Angie Medina
 * @version 2.0
 */
public class App {

    /**
     * This main method uses SparkWeb static methods and lambda functions to
     * create a simple web app. It maps the lambda function to the
     * /consult relative URL having a response parsed to JSON
     * @param args .
     */
    public static void main(String[] args){
        port(getPort());
        // root is 'src/main/resources', so put files in 'src/main/resources/public'
        staticFiles.location("/public"); // Static files
        get("/consult", "application/json", (req, res) -> consultAPI(req, res));

    }

    /**
     * This method extracts the parameters of the request and using a http service
     * consults an api
     * @param req request of the /consult relative URL
     * @param res parsed to JSON response for a certain request
     * @return The corresponding output of the conu
     */
    private static String consultAPI(Request req, Response res){
        res.type("application/json");
        String stock = req.queryParams("id");
        String variation = req.queryParams("var");
        String response = "None";
        HttpStockService stockService = CurrentServiceInstance.getInstance().getService();
        if(stock != null && !stock.equals("")){
            stockService.setStock(stock);
        }
        String url = stockService.resolveRequest(variation);
        String cacheResponse = LRUCache.getInstance().getElementFromCache(url);
        if(!cacheResponse.equals("Not exists")){
            response = cacheResponse;
        } else{
            try {
                response = stockService.timeSeries(variation);
                LRUCache.getInstance().putElementInCache(url, response);
            } catch (IOException e) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return response;
    }

    /**
     * This method reads the default port as specified by the PORT variable in
     * the environment.
     *
     * Heroku provides the port automatically so you need this to run the
     * project on Heroku.
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }
}
