class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int[] maxLeftHeight = new int[n]; // stores max height left of an index
        int[] maxRightHeight = new int[n]; // stores max height right of an index

        // max height left of first element is 0
        maxLeftHeight[0]= 0;

        // max height right of last element is 0
        maxRightHeight[n -1]= 0;
    

        for(int i = 1; i < n ;i++){
            if(height[i-1] > maxLeftHeight[i-1]){
                maxLeftHeight[i] = height[i-1];
            }else{
                maxLeftHeight[i] = maxLeftHeight[i-1];
            }
        }

        for(int j = n-2; j>=0 ; j--){
            if(height[j+1] > maxRightHeight[j+1]){
                maxRightHeight[j] = height[j+1];
            }else{
                maxRightHeight[j] = maxRightHeight[j+1];
            }
        }

        int waterStored = 0;

        for(int k = 0; k< n;k++){
            int val = Math.min(maxLeftHeight[k],maxRightHeight[k]) - height[k];

            if(val > 0){
                waterStored += val;
            }
        }

        return waterStored;

    }
}
