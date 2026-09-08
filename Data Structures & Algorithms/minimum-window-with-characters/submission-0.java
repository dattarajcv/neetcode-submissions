class Solution {
    public String minWindow(String s, String t) {
        int sLen = s.length();

        // Base case: when t string has more elements than s
        if (sLen < t.length()) {
            return "";
        }

        // Keep a map of character and it's frequency in t string
        Map<Character, Integer> needTCharFreq = new HashMap<>();

        for (char c : t.toCharArray()) {
            needTCharFreq.put(c, needTCharFreq.getOrDefault(c, 0) + 1);
        }

        // number of distinct chars in t string
        int required = needTCharFreq.size();
        // will keep track of number of chars found in our window in s
        // which match char and frequency in t string
        int formed = 0;
        // sliding window start and end pointers
        int left = 0, right = 0;
        // pointer to keep track of start of result substring
        int start = 0;
        // length of the resulting substring
        int minLen = Integer.MAX_VALUE;

        // Frequency of char found in sliding window.
        Map<Character, Integer> windowCharFreq = new HashMap<>();

        while (right < sLen) {
            // Update the char frequency in the sliding window
            char c = s.charAt(right);
            windowCharFreq.put(c, windowCharFreq.getOrDefault(c, 0) + 1);

            // If a char present in sliding window matches
            // with the char present in t and it's frequency we 
            // increment update by 1.
            if(needTCharFreq.containsKey(c) && 
            needTCharFreq.get(c).intValue() == windowCharFreq.get(c).intValue()){
                formed++;
            }
            
            // Run below loop if we find all the chars present in the sliding window
            while(left <= right && formed == required){
                // if window is found with required chars and freq
                // Calculate it's length and update start and size of it
                // if it is smaller than the existing substring
                if(right - left + 1 < minLen){
                    minLen = right - left + 1;
                    start = left;
                }
                // Start shrinking the window to find the smallest substring
                char winStartChar = s.charAt(left);
                windowCharFreq.put(winStartChar,windowCharFreq.get(winStartChar) - 1);
                // While shrinking if we remove a char which was required to 
                // satisfy our condition we reduce formed.
                if(needTCharFreq.containsKey(winStartChar) &&
                windowCharFreq.get(winStartChar) < needTCharFreq.get(winStartChar)){
                    formed--;
                }

                left++;
            }

            right++;

        }

        return minLen == Integer.MAX_VALUE ? "" :
        s.substring(start, start + minLen);

    }
}
