class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int s1Len = s1.length();
        int s2Len = s2.length();

        /**
        Permutation of s1 in s2 cannot exists 
        as s1 is longer than s2
        */
        if(s1Len > s2Len){
            return false;
        }

        int[] freq = new int[26];

        // Build Frequency array
        for(int i =0; i< s1Len; i++){
            freq[s1.charAt(i) - 'a']++;
        }

        // sliding window
        int left = 0, right=0;

        // total element count in s1
        int count = s1Len;

        while( right < s2Len){
            // if char of s1 is found in s2 window
            // reduce count and update frequency map as well
            if(freq[s2.charAt(right) - 'a']-- > 0){
                count--;
            }

            // if current window length exceeds s1
            // shrink the window from left 
            // and add back the char count in freq map
            if(right - left + 1 > s1Len){
                if(freq[s2.charAt(left) - 'a']++ >=0){
                    count++;
                }
                left++;
            }
            

            right++;

            if(count ==0) return true;

        }
        
        return false;
    }
}
