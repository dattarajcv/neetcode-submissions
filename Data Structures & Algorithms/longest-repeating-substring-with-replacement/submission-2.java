class Solution {
    public int characterReplacement(String s, int k) {
        int start = 0, res = 0, n = s.length();

        Map<Character, Integer> chFreq = new HashMap<>();

        for (int end = 0; end < n; end++) {
            char c = s.charAt(end);
            chFreq.put(c, chFreq.getOrDefault(c, 0) + 1);

            int maxFreq = mostFrequent(chFreq);
            int windowSize = end - start + 1;

            while (windowSize - maxFreq > k) {
                c = s.charAt(start);
                chFreq.put(c, chFreq.get(c) - 1);
                maxFreq = mostFrequent(chFreq);
                start++;
                windowSize = end - start + 1;
            }

            res = Math.max(res, windowSize);
        }

        return res;
    }

    public int mostFrequent(Map<Character, Integer> map) {
        if (map == null || map.isEmpty()) {
            return 0; // or throw
        }

        int bestFreq = 0;
        for (int freq : map.values()) {
            bestFreq = Math.max(bestFreq, freq);
        }
        return bestFreq;
    }
}
