class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        var freqMap = new HashMap<Integer, Integer>();

        // Create frequency map for array elements.
        for(int num: nums){
            freqMap.put(num,freqMap.getOrDefault(num,0) + 1);
        }

        // Use minHeap
        var minHeap = new PriorityQueue<Map.Entry<Integer, Integer>>((a,b) -> a.getValue() - b.getValue());

        for(var entry: freqMap.entrySet()){
            minHeap.add(entry);

            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        int[] result = new int[k];
        int i =0;
        
        for(var node: minHeap){
            result[i] = node.getKey();
            i++;
        }

        return result;
    }
}
