class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map store = new HashMap<Integer, Integer>();
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if (store.containsKey(target - nums[i])) {
                result[0] = (int) store.get(target - nums[i]);
                result[1] = i;

                return result;
            }else{
                store.put(nums[i],i);
            }
        }

        return result;
    }
}
