import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Day 3 - A doubly linked list inside java.util: LinkedHashMap.
 * LinkedHashMap = HashMap + a doubly linked list through all entries.
 * With accessOrder = true, every get() moves the entry to the END of that list,
 * so the FIRST entry is always the least recently used one.
 * Override removeEldestEntry() and you have an LRU cache in a few lines.
 */
public class LRUCacheDemo {

    static class LRUCache<K, V> extends LinkedHashMap<K, V> {
        private final int capacity;

        LRUCache(int capacity) {
            super(16, 0.75f, true);            // true = access order (not insertion order)
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > capacity;          // evict the least recently used entry
        }
    }

    public static void main(String[] args) {
        LRUCache<String, String> cache = new LRUCache<>(3);
        cache.put("home", "<html>home</html>");
        cache.put("about", "<html>about</html>");
        cache.put("login", "<html>login</html>");
        System.out.println("put home, about, login      : " + cache.keySet() + "   (oldest ... newest)");

        cache.get("home");
        System.out.println("get home (moved to the end) : " + cache.keySet());

        cache.put("cart", "<html>cart</html>");
        System.out.println("put cart (evicts the LRU)   : " + cache.keySet() + "   'about' was evicted");
    }
}
