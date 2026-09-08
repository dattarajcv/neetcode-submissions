class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // add empty list as it is valid
        result.add(new ArrayList<>());

        for(int num: nums){
            int size = result.size(); 

            for(int i = 0; i< size;i++){
                List<Integer> subSet = new ArrayList<>(result.get(i));
                subSet.add(num); // add the element to subset
                result.add(subSet); // add subset to result
            }

        }

        return result;
    }
}
