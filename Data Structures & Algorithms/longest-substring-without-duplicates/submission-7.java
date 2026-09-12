class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int n = s.length(); // 3
        // sliding window
        int start = 0, end = 0;

        Map<Character, Integer> lastSeen = new HashMap<>();

        while (end < n) {
            if (lastSeen.containsKey(s.charAt(end))) {
                Character c = s.charAt(end);
                int lastSeenPos = lastSeen.get(c);
                start = lastSeenPos + 1 > start ? lastSeenPos + 1 : start;
                lastSeen.put(s.charAt(end), end);
            }
            lastSeen.put(s.charAt(end), end);
            res = (end - start + 1) > res ? (end - start + 1) : res;
            end++;
        }
        return res;
    }
}
