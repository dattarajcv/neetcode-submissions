class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        var result = new ArrayList<List<Integer>>();
        // [-1,0,1,2,-1,-4]
        int n = nums.length;
        // sort array to use two pointer approach
        Arrays.sort(nums);

        // iterate from first element to last - 2
        for (int i = 0; i < n - 2; i++) {
            // if previous element was same, skip processing for current element
            // to avoid duplicates.
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(List.of(nums[i], nums[left], nums[right]));

                    // skip duplicates
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right - 1] == nums[right]) right--;
                    // for same i, move to new left and right
                    left++;
                    right--;

                } else if (sum < 0) {
                    // if sum is less than 0 move towards higher value
                    left++;
                } else {
                    // if sum is more than 0 move towards lesser value
                    right--;
                }
            }
        }
        return result;
    }
}
