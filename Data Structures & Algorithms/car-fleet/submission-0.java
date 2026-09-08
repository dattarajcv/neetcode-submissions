class Solution {

    class Pair<A,B>{
        A position;
        B time;

        public Pair(A pos, B t){
            position = pos;
            time = t;
        }

    }
    public int carFleet(int target, int[] position, int[] speed) {
        Deque<Pair<Integer,Double>> stack = new ArrayDeque<>();
        List<Pair<Integer,Double>> list= new ArrayList<>();
        int n = position.length;

        for(int i=0;i < n; i++){

            list.add(new Pair<Integer, Double>(position[i],(double) (target - position[i])/speed[i]));
        }

        list.sort(Comparator.comparing((Pair<Integer,Double> p) -> p.position).reversed());

        for(Pair<Integer, Double> pair: list){
            
            if (stack.isEmpty() || pair.time > stack.peek().time) {
                stack.push(pair);
            }
        }

        return stack.size();
    }
}
