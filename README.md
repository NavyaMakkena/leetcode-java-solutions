# LeetCode 146 — LRU Cache (Java)

[Problem statement](https://leetcode.com/problems/lru-cache/)

## Approach

A `HashMap<Integer, Node>` provides average constant-time lookup. A doubly linked list maintains recency order: the node immediately after the head is the most recently used, and the node immediately before the tail is the least recently used. Dummy head and tail nodes simplify insertion and removal.

- `get`: find the node, move it to the front, return its value; otherwise return `-1`.
- `put`: update an existing node and move it to the front, or insert a new node. If capacity is exceeded, remove the tail's predecessor.

**Complexity:** O(1) average time per operation; O(capacity) auxiliary space.

## Run tests

Requires a JDK (Java 11 or newer):

```bash
mkdir -p out
javac -d out src/LRUCache.java tests/LRUCacheTest.java
java -cp out LRUCacheTest
```

## Edge cases covered

- Standard LeetCode eviction sequence
- Missing keys
- Capacity of one
- Updating a key without evicting it
- Recency changes after an update
- Rejecting nonpositive capacity (local input validation)

## Notes

This is a standalone learning implementation, not production cache infrastructure. The cache is not thread-safe, has no TTL, and does not persist data.
