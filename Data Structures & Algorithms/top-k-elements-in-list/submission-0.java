class Solution {
    class Node{
        int key;
        int score;
        public Node(int key,int score){
            this.key=key;
            this.score=score;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        var freqMap = new HashMap<Integer, Integer>();
        
        for(int i: nums){
            var count = freqMap.getOrDefault(i,0)+1;
            freqMap.put(i,count);
        }
        PriorityQueue<Node> pq=new PriorityQueue<>((a,b)->Integer.compare(a.score,b.score));

        for(Map.Entry<Integer,Integer> entry:freqMap.entrySet()){
            Node node=new Node(entry.getKey(),entry.getValue());
           if(pq.size()<k){
                pq.offer(node);
           }else{
                //System.out.println(pq.peek().score);
                if(pq.peek().score<node.score){
                    pq.poll();
                    pq.offer(node);
                }
           }
        }
        var result=new int[k];
        int j=0;
        while(!pq.isEmpty()){
            result[j++]=pq.poll().key;
        }

        return result;
    }
}
