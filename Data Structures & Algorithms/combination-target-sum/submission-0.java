class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    private int target = 0;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        this.target = target;
        dfs(0,nums,new ArrayList<>(), 0, target);
        return result;
    }

    public void dfs(int index,int[] nums, List<Integer> curr, int total, int target){

        if(total == target){
            result.add(new ArrayList<>(curr));
            return;
        }

        if(index > nums.length -1 || total > target){
            return;
        }


        curr.add(nums[index]);
        dfs(index,nums, curr, total + nums[index],target);
        curr.remove(curr.size() -1);
        dfs(index + 1,nums, curr, total ,target);

        
    }
}
