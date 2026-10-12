import java.util.HashMap;
import java.util.Map;

public class P0003LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        int start = 0, best = 0;
        for (int end = 0; end < s.length(); end++) {
            char current = s.charAt(end);
            if (lastSeen.containsKey(current)) start = Math.max(start, lastSeen.get(current) + 1);
            lastSeen.put(current, end);
            best = Math.max(best, end - start + 1);
        }
        return best;
    }
}
