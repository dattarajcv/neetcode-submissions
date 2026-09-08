class Solution {
    public int maxArea(int[] heights) {
      int n = heights.length;
      int left = 0;
      int right = n -1;
      int area = Integer.MIN_VALUE;

      while(left < right){
        int newArea = (right - left) * Math.min(heights[left], heights[right]);

        area = Math.max(area, newArea);

        if(heights[left] < heights[right]){
            left++;
        }else{
            right--;
        }
      }  
      return area;
    }
}
