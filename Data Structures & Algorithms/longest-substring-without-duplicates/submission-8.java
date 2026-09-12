class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0, start = 0;
        Map<Character, Integer> lastSeen = new HashMap<>();

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);

            if (lastSeen.containsKey(c)) {
                start = Math.max(start, lastSeen.get(c) + 1);
            }

            lastSeen.put(c, end);
            res = Math.max(res, end - start + 1);
        }
        return res;
    }
}