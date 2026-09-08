class Solution {
    public int characterReplacement(String s, int k) {
        int strLen = s.length();
        int[] charFreq = new int[26];
        int maxFreq =0, maxLength=0;

        int left =0;
        int right =0;

        while(right < strLen){
            charFreq[s.charAt(right) - 'A']++;

            maxFreq = Math.max(maxFreq, charFreq[s.charAt(right) - 'A']);

            if((right - left + 1) - maxFreq > k){
                charFreq[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}
