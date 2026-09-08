class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int area = Integer.MIN_VALUE;

        for(int i = 0; i< n; i++){
            for(int j = i + 1; j< n;j++){
                int newArea = (j - i) * Math.min(heights[i],heights[j]);

                area = Math.max(area, newArea);
            }
        }

        return area;
    }
}
