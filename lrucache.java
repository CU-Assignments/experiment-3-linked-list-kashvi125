import java.util.*;

class LRUCache {
    private final int capacity;
    private final Map<Integer, Integer> cache;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }
    
    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        cache.put(key, value);
    }
    
    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);
        lru.put(1, 10);
        lru.put(2, 20);
        System.out.println(lru.get(1)); // Output: 10
        lru.put(3, 30);
        System.out.println(lru.get(2)); // Output: -1 (Evicted)
        lru.put(4, 40);
        System.out.println(lru.get(1)); // Output: -1 (Evicted)
        System.out.println(lru.get(3)); // Output: 30
        System.out.println(lru.get(4)); // Output: 40
    }
}
