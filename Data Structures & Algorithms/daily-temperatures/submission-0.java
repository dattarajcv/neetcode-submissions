class Solution {

    class Pair<A,B>{
        private A value;
        private B index;

        public Pair(A val, B ind){
            value= val;
            index = ind;
        }

        public A getValue(){
            return value;
        }

        public B getIndex(){
            return index;
        }
    }
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length, i=0;
        int[] output = new int[n];
        
        Stack<Pair<Integer, Integer>> stack = new Stack();
        
        stack.push(new Pair<Integer, Integer>(temperatures[i],i));

        i++;

        while(i < n){
            if(!stack.isEmpty() && stack.peek().getValue() < temperatures[i]){
                Pair<Integer,Integer> pair = stack.pop();

                output[pair.getIndex()] = i - pair.getIndex();
            }else{
                stack.push(new Pair<Integer, Integer>(temperatures[i],i));
                i++;
            }
        }

        while(!stack.isEmpty()){
            Pair<Integer,Integer> pair = stack.pop();
            output[pair.getIndex()] = 0;
        }

        return output;
    }
}
