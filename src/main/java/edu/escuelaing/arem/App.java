package edu.escuelaing.arem;
import spark.Request;
import spark.Response;
import static spark.Spark.*;

import java.io.IOException;
/**
 * Hello world!
 *
 */
public class App {
    /**
     * This main method uses SparkWeb static methods and lambda functions to
     * create a simple Hello World web app. It maps the lambda function to the
     * /hello relative URL.
     */
    public static void main( String[] args ){
        port(getPort());
        // root is 'src/main/resources', so put files in 'src/main/resources/public'
        staticFiles.location("/public"); // Static files
        get("/getfb", (req, res) -> getFBData(req, res));
    }

    private static String getFBData(Request req, Response res){
        String response = "None";
        try {
            response = HttpConnection.getFBData();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
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
