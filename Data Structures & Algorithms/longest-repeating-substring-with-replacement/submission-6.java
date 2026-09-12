class Solution {
    public int characterReplacement(String s, int k) {
        int start = 0, maxFreq = 0, res = 0, n = s.length();

        Map<Character, Integer> chFreq = new HashMap<>();

        for (int end = 0; end < n; end++) {
            char c = s.charAt(end);
            int newCount = chFreq.getOrDefault(c, 0) + 1;
            chFreq.put(c, newCount);

            maxFreq = Math.max(maxFreq, newCount);

            while (end - start + 1 - maxFreq > k) {
                c = s.charAt(start++);
                chFreq.put(c, chFreq.get(c) - 1);
            }

            res = Math.max(res, end - start + 1);
        }

        return res;
    }
}
