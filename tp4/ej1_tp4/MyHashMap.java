package ej1_tp4;

import java.util.HashMap;

public class MyHashMap<K, V> {
	
	private HashMap<K, V> hashMap;

    public MyHashMap() {
        this.hashMap = new HashMap<>();
    }
    
    public void put(K key, V value) {
    	this.hashMap.put(key, value);
    }
    
    public V get(K key) {
    	return hashMap.get(key);
    }
    
    public boolean containsKey(K key) {
    	return hashMap.containsKey(key);
    }
    
    public void remove(K key) {
        hashMap.remove(key);
    }

    public int size() {
        return hashMap.size();
    }

    public boolean isEmpty() {
        return hashMap.isEmpty();
    }
}
