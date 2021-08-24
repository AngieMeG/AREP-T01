package edu.escuelaing.arem;

/**
 * Simple cache structure
 * @version 1.0
 * @author Angie Medina
 * @author Help by https://www.javatpoint.com/lru-cache-implementation-in-java
 */
public class Cache {
    String key;
    String value;
    Cache(String key, String value){
        this.key = key;
        this.value = value;
    }
}
