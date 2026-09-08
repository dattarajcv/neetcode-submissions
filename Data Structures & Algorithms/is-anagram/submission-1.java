class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
        return false;

        long prodS = 1L, prodT = 1L;

        s = s.toUpperCase();
        t = t.toUpperCase();
        for(char c : s.toCharArray()){
            prodS *= c;
        }

        for(char z : t.toCharArray()){
            prodT *= z;
        }
        System.out.println(prodS);
        System.out.println(prodT);
        return prodS == prodT;
    }
}
