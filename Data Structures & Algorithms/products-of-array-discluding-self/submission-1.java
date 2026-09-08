class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        

        prefix[0] = 1;

        for(int i=1; i< nums.length; i++){
            prefix[i] = nums[i-1] * prefix[i-1];
        }
        int suffix = 1;
        for(int i = nums.length -1; i>=0; i--){
            int val = prefix[i] * suffix; 
            suffix = nums[i] * suffix;
            nums[i] = val;
        }
       
        return nums;
    }
}  
