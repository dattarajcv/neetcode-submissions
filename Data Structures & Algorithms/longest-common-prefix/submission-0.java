class Solution {
    public String longestCommonPrefix(String[] strs) {
        // base case
        if (strs.length < 1) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        int minLen = Integer.MAX_VALUE;
        int minStrIndex = -1;

        // Find smallest string in the strs as thats the max length of common prefix
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < minLen) {
                minStrIndex = i;
                minLen = strs[i].length();
            }
        }
        // If empty string then there is no possible prefix match
        if (minLen == 0 || minStrIndex == -1) {
            return "";
        }

        int index = 0;
        String prefixStr = strs[minStrIndex];
    
        int right = 1;
        while (right <= minLen) {
            for (int i = 0; i < strs.length; i++) {
                if (!prefixStr.substring(0, right).equals(strs[i].substring(0, right))) {
                    return prefixStr.substring(0, right-1);
                }
            }
            right++;
        }
        return prefixStr.substring(0, right -1);
    }
}