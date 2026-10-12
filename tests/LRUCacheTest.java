public class LRUCacheTest {
    private static int checks = 0;
    private static void eq(int actual, int expected) {
        checks++;
        if (actual != expected) throw new AssertionError("Expected " + expected + " but got " + actual);
    }
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        eq(cache.get(1), 1);
        cache.put(3, 3);
        eq(cache.get(2), -1);
        cache.put(4, 4);
        eq(cache.get(1), -1);
        eq(cache.get(3), 3);
        eq(cache.get(4), 4);

        LRUCache single = new LRUCache(1);
        single.put(7, 10);
        single.put(7, 11);
        eq(single.get(7), 11);
        single.put(8, 12);
        eq(single.get(7), -1);
        eq(single.get(8), 12);

        LRUCache update = new LRUCache(2);
        update.put(1, 1);
        update.put(2, 2);
        update.put(1, 99);
        update.put(3, 3);
        eq(update.get(1), 99);
        eq(update.get(2), -1);

        boolean rejected = false;
        try { new LRUCache(0); } catch (IllegalArgumentException e) { rejected = true; }
        if (!rejected) throw new AssertionError("Zero capacity must be rejected");
        checks++;
        System.out.println("PASS: " + checks + " assertions");
    }
}
