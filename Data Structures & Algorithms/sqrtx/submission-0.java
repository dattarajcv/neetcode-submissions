class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        
        int left = 1;
        int right = x / 2;
        
        // Find the largest number whose square <= x
        while (left < right) {
            int mid = left + (right - left + 1) / 2;  // Round up!
            
            if (mid <= x / mid) {
                // mid is valid, try to find larger
                left = mid;
            } else {
                // mid is too large
                right = mid - 1;
            }
        }
        
        return left;
    }
}