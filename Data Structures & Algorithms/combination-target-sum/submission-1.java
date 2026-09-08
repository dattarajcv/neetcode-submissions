class Solution {
    List<List<Integer>> result;
    int target;
    public List<List<Integer>> combinationSum(int[] candidates, int tar) {
        result = new ArrayList<>();
        target = tar;
        backtrack(candidates, new ArrayList<>(), 0, 0);
        return result;
    }

    public void backtrack(int[] candidates, List<Integer> current, int index, int total) {

        // found solution
        if (total == target) {
            result.add(new ArrayList<>(current));
            return;
        } 
        
        // break recurssion
        if (index >= candidates.length || total > target) {
            return;
        }

        
        // include value at index in subset
        current.add(candidates[index]);
        backtrack(candidates, current, index, total + candidates[index]);
        current.remove(current.size() - 1);
        backtrack(candidates, current, index + 1, total);

    }

}