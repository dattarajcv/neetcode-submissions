class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // any subset is acceptable. including empty
        result.add(new ArrayList<>());

        for(int num: nums){
            
            int size = result.size();

            for(int i = 0; i< size; i++){
                var subset = new ArrayList<>(result.get(i));
                subset.add(num);
                result.add(subset);
            }
        }

        return result;
    }

}
