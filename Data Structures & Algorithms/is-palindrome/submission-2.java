class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        
        if(n == 1) return true;
        s = s.toLowerCase();
        int front = 0;
        int back = n-1;

        while(front < back){
            char f = s.charAt(front);
            char b = s.charAt(back);
            if(!Character.isLetterOrDigit(f)){
                front++;
                continue;
            }
            if(!Character.isLetterOrDigit(b)){
                back--;
                continue;
            }
            if(s.charAt(front) != s.charAt(back)) return false;
            front++;
            back--;
        }
        return true;
    }
}
