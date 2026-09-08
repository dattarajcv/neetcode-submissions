class Solution {
    private List<List<Integer>> result;
    private int target;

    public List<List<Integer>> combinationSum2(int[] candidates, int tar) {
        result = new ArrayList<>();
        target = tar;

        Arrays.sort(candidates);

        backtrack(candidates, new ArrayList<>(),0,0);
        return result;
    }

    public void backtrack(int[] candidates, List<Integer> current, 
    int index, int total){
        
        if(total == target){
            result.add(new ArrayList<>(current));
            return;
        }

        if(total > target){
            return;
        }

        for(int i = index; i< candidates.length; i++){
            
            if(i> index && candidates[i] == candidates[i-1]){
                continue;
            }

            current.add(candidates[i]);
            backtrack(candidates, current, i +1, total + candidates[i]);
            current.remove(current.size()-1);
        }

    }
}
