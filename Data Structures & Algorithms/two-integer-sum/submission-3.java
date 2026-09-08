class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int[] res = new int[2];


        for(int i = 0; i< n; i++){
            if(!map.containsKey(target - nums[i])){
                map.put(nums[i],i);
            }else{
                res[0] = map.get(target - nums[i]);
                res[1] = i;
            }
        }

        return res;
    }
}
