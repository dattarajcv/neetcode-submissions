class Solution {
    public boolean isAnagram(String s, String t) {

        int[] space = new int[26];

        if(s.length() != t.length()) return false;

        if(s.length() ==1 && s.charAt(0) != t.charAt(0)) return false;

        for(char c: s.toCharArray()){
            space[c - 'a']++;
        }

        for(char c: t.toCharArray()){
            space[c - 'a']--;
        }

        for(int num: space){
            if(num !=0) return false;
        }

        return true;
    }
}
