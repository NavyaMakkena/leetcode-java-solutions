import java.util.*;

public class SolutionTests {
    static int checks = 0;
    static void check(boolean condition, String label) {
        checks++;
        if (!condition) throw new AssertionError(label);
    }
    static int[] list(ListNode node) {
        List<Integer> values = new ArrayList<>();
        while (node != null) { values.add(node.val); node = node.next; }
        return values.stream().mapToInt(Integer::intValue).toArray();
    }
    static ListNode nodes(int... values) {
        ListNode head = null;
        for (int i = values.length - 1; i >= 0; i--) head = new ListNode(values[i], head);
        return head;
    }
    public static void main(String[] args) {
        check(Arrays.equals(new P0001TwoSum().twoSum(new int[]{2,7,11,15},9), new int[]{0,1}), "two sum");
        check(Arrays.equals(new P0001TwoSum().twoSum(new int[]{3,3},6), new int[]{0,1}), "two sum duplicates");
        check(new P0121BestTimeToBuySellStock().maxProfit(new int[]{7,1,5,3,6,4}) == 5, "stock profit");
        check(new P0121BestTimeToBuySellStock().maxProfit(new int[]{7,6,4,3,1}) == 0, "stock decline");
        List<List<String>> groups = new P0049GroupAnagrams().groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        check(groups.size() == 3 && groups.stream().map(g -> new HashSet<>(g)).anyMatch(g -> g.equals(Set.of("eat","tea","ate"))), "anagrams");
        check(new P0049GroupAnagrams().groupAnagrams(new String[]{""}).size() == 1, "empty anagram");
        check(new P0003LongestSubstring().lengthOfLongestSubstring("abcabcbb") == 3, "substring");
        check(new P0003LongestSubstring().lengthOfLongestSubstring("bbbbb") == 1, "substring repeated");
        check(new P0003LongestSubstring().lengthOfLongestSubstring("") == 0, "substring empty");
        check(Arrays.equals(list(new P0021MergeTwoSortedLists().mergeTwoLists(nodes(1,2,4),nodes(1,3,4))),new int[]{1,1,2,3,4,4}), "merge lists");
        check(Arrays.equals(list(new P0021MergeTwoSortedLists().mergeTwoLists(null,nodes(1))),new int[]{1}), "merge empty");
        check(Arrays.equals(list(new P0206ReverseLinkedList().reverseList(nodes(1,2,3))),new int[]{3,2,1}), "reverse list");
        check(new P0206ReverseLinkedList().reverseList(null) == null, "reverse empty");
        TreeNode tree = new TreeNode(3,new TreeNode(9),new TreeNode(20,new TreeNode(15),new TreeNode(7)));
        check(new P0104MaximumDepth().maxDepth(tree) == 3, "tree depth");
        check(new P0104MaximumDepth().maxDepth(null) == 0, "empty depth");
        check(new P0102LevelOrderTraversal().levelOrder(tree).equals(List.of(List.of(3),List.of(9,20),List.of(15,7))), "level order");
        check(new P0102LevelOrderTraversal().levelOrder(null).isEmpty(), "empty levels");
        check(new P0200NumberOfIslands().numIslands(new char[][]{{'1','1','0'},{'0','1','0'},{'1','0','1'}}) == 3, "islands");
        check(new P0200NumberOfIslands().numIslands(new char[][]{}) == 0, "empty islands");
        check(new P0207CourseSchedule().canFinish(2,new int[][]{{1,0}}), "acyclic courses");
        check(!new P0207CourseSchedule().canFinish(2,new int[][]{{1,0},{0,1}}), "cyclic courses");
        check(new P0207CourseSchedule().canFinish(0,new int[][]{}), "zero courses");
        System.out.println("PASS: " + checks + " assertions across 10 problems");
    }
}
