class Solution {
    public int removeElement(int[] nums, int val) {

        int left = 0;
        int right = nums.length -1;

        while(left <= right){
            if(nums[left] == val){
                swap(nums,left,right);
                right--;
            }else{
                left++;
            }
        }

        return left; 
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}