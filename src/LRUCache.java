import java.util.HashMap;
import java.util.Map;

/** LeetCode 146: LRU Cache. O(1) average get and put. */
public class LRUCache {
    private static final class Node {
        int key;
        int value;
        Node previous;
        Node next;
        Node(int key, int value) { this.key = key; this.value = value; }
    }

    private final int capacity;
    private final Map<Integer, Node> entries = new HashMap<>();
    private final Node head = new Node(0, 0);
    private final Node tail = new Node(0, 0);

    public LRUCache(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("capacity must be positive");
        this.capacity = capacity;
        head.next = tail;
        tail.previous = head;
    }

    public int get(int key) {
        Node node = entries.get(key);
        if (node == null) return -1;
        moveToFront(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node existing = entries.get(key);
        if (existing != null) {
            existing.value = value;
            moveToFront(existing);
            return;
        }
        Node added = new Node(key, value);
        entries.put(key, added);
        addAfterHead(added);
        if (entries.size() > capacity) {
            Node oldest = tail.previous;
            remove(oldest);
            entries.remove(oldest.key);
        }
    }

    private void moveToFront(Node node) {
        remove(node);
        addAfterHead(node);
    }

    private void remove(Node node) {
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }

    private void addAfterHead(Node node) {
        node.next = head.next;
        node.previous = head;
        head.next.previous = node;
        head.next = node;
    }
}
