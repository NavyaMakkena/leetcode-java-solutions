# Java Algorithm Practice

Ten LeetCode problems with Java 21 solutions and a standalone test harness. These are study implementations, not claims of independent authorship or accepted LeetCode submissions.

## Run tests

```bash
mkdir -p out
javac -d out src/*.java tests/*.java
java -cp out SolutionTests
```

For LeetCode submission, copy the relevant method into the platform-provided `Solution` class and use its `ListNode`/`TreeNode` definitions where applicable.

| Problem | Category | Difficulty | Time | Extra space |
|---|---|---|---|---|
| [P0001TwoSum](src/P0001TwoSum.java) | Arrays / Hash Maps | Easy | O(n) | O(n) |
| [P0121BestTimeToBuySellStock](src/P0121BestTimeToBuySellStock.java) | Arrays | Easy | O(n) | O(1) |
| [P0049GroupAnagrams](src/P0049GroupAnagrams.java) | Hash Maps / Strings | Medium | O(n k log k) | O(n k) |
| [P0003LongestSubstring](src/P0003LongestSubstring.java) | Sliding Window / Hash Maps | Medium | O(n) | O(min(n, alphabet size)) |
| [P0021MergeTwoSortedLists](src/P0021MergeTwoSortedLists.java) | Linked Lists | Easy | O(n + m) | O(1) |
| [P0206ReverseLinkedList](src/P0206ReverseLinkedList.java) | Linked Lists | Easy | O(n) | O(1) |
| [P0104MaximumDepth](src/P0104MaximumDepth.java) | Trees | Easy | O(n) | O(h) |
| [P0102LevelOrderTraversal](src/P0102LevelOrderTraversal.java) | Trees / BFS | Medium | O(n) | O(w) |
| [P0200NumberOfIslands](src/P0200NumberOfIslands.java) | Graphs / DFS | Medium | O(rows * cols) | O(rows * cols) |
| [P0207CourseSchedule](src/P0207CourseSchedule.java) | Graphs / Topological Sort | Medium | O(V + E) | O(V + E) |

## Approach notes

### P0001TwoSum
Store each previously seen value and index; look up the complement before inserting the current value.

### P0121BestTimeToBuySellStock
Track the minimum price seen so far and the best profit available on each day.

### P0049GroupAnagrams
Sorted letters form a canonical key for anagrams. n is the number of strings and k their maximum length.

### P0003LongestSubstring
Move the left boundary past a repeated character, never backwards. This implementation treats Java UTF-16 chars as units.

### P0021MergeTwoSortedLists
Reuse existing nodes and advance the pointer belonging to the smaller head.

### P0206ReverseLinkedList
Reverse pointers iteratively while saving the next node before changing its link.

### P0104MaximumDepth
Depth is one plus the maximum depth of the left and right subtrees; h is recursion depth.

### P0102LevelOrderTraversal
Breadth-first search processes exactly the current queue size for each level; w is maximum tree width.

### P0200NumberOfIslands
Count connected components using iterative DFS. Marks visited cells in place, so the input grid is modified.

### P0207CourseSchedule
Kahn’s algorithm repeatedly removes nodes with no remaining prerequisites; a cycle prevents processing all nodes.

## Publishing responsibly

Run the tests yourself, understand the trade-offs, and record your own changes. Do not describe these as independently authored or officially accepted on LeetCode unless that is accurate.
