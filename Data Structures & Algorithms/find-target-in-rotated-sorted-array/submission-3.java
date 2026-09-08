class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;

        int left = 0;
        int right = n -1;

        while(left <= right){
            int mid = left + (right - left)/2;

            // found element return element
            if(nums[mid] == target){
                return mid;
            }

            // left half is sorted
            if(nums[left] <= nums[mid]){
                // element exists in the left sorted array
                if(nums[left] <= target && target < nums[mid]){
                    right = mid -1;
                }else{ // element exists in non sorted right array
                    left = mid +1;
                }
            }else{ // right half is sorted
                if(nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                }else{
                    right = mid -1;
                }
            }
        }

        return -1;
    }
}
