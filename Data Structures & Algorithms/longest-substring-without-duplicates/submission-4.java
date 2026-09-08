class Solution {
    public int lengthOfLongestSubstring(String s) {

        int n = s.length();
        int maxLength = 0;

        Map<Character, Integer> seen = new HashMap<>();
        // substring pointer
        int start = 0;
        int end =0;

        // cadbzabcd
        // abba
        while(end < n){
            if(seen.containsKey(s.charAt(end))){
                int lastSeenAt = seen.get(s.charAt(end)) + 1;
                //new start
                if(lastSeenAt > start){
                    start = lastSeenAt;
                }
                
            }
            seen.put(s.charAt(end), end);
            maxLength = Math.max(maxLength, end - start + 1);
            end++;
        }
        return maxLength;
    }   
}
