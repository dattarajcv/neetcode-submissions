class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int s1Len = s1.length();
        int s2Len = s2.length();
        boolean match = true;
        /**
        Permutation of s1 in s2 cannot exists 
        as s1 is longer than s2
        */
        if(s1Len > s2Len){
            return false;
        }

        int[] charFreq = new int[26];

        // Build Frequency array
        for(int i =0; i< s1Len; i++){
            charFreq[s1.charAt(i) - 'a']++;
        }

        for(int j=0; j + s1Len <= s2Len; j++){
            match = true;
            String subStr = s2.substring(j, j + s1Len);

            int[] ssCharFreq = new int[26];
            for(int k = 0;k < s1Len ;k++){
                ssCharFreq[subStr.charAt(k) - 'a']++;
            }
            
            for(int k=0;k<26; k++){
                if(charFreq[k] != ssCharFreq[k]){
                    match = false;
                    break;
                }
            }
            if(match){
                return true;
            }
        }

        return match;

    }
}
