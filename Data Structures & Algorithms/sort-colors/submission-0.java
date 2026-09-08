class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n;
        for(int i=0; i < n;i++){
            if(nums[i] == 0){
                left++;
            }else if(nums[i] == 2){
                right--;
            }
        }

        for(int i =0; i< left; i++){
            nums[i] = 0;
        }

        for(int i = left; i < right; i++){
            nums[i] = 1;
        }

        for(int i = right; i < n; i++){
            nums[i] = 2;
        }
    }
}