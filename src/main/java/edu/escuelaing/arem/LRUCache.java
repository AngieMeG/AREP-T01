package edu.escuelaing.arem;

import java.util.*;

/**
 * Simple implementation of a LRU Cache
 * @version 1.0
 * @author Angie Medina
 * @author Help by https://www.javatpoint.com/lru-cache-implementation-in-java
 */
public class LRUCache{
    private static LRUCache _instance = new LRUCache();
    private Deque<String> queue;
    private Map<String, Cache> map;
    private int CACHE_SIZE = 100;
    
    private LRUCache(){
        queue = new LinkedList<>();
        map = new HashMap<>();
    }
    /**
     * 
     * @return the current instance of the service
     */
    public static LRUCache getInstance() {
        return _instance;
    }

    /**
     * If the key already exists, fetch data from the cache.
     * @param key String search data
     * @return "Not exists" if the key is not in the cache
     *          Value if the key is in the cache
     */
    public String getElementFromCache(String key) {
        String response = "Not exists";
        if(map.containsKey(key)){
            Cache current = map.get(key);
            queue.remove(current.key);
            queue.addFirst(current.key);
            response = current.value;
        }
        return response;
    }

    /**
     * Add the element with the given key an value to the cache structure
     * @param key String identifier data
     * @param value String fetch to the key
     */
    public void putElementInCache(String key, String value) {
        if(map.containsKey(key)){
            Cache current = map.get(key);
            queue.remove(current.key);
        } else{
            if(queue.size() == CACHE_SIZE){
                String temp = queue.removeLast();
                map.remove(temp);
            }
        }
        Cache newItem = new Cache(key, value);
        queue.addFirst(newItem.key);
        map.put(key, newItem);
    }
}

