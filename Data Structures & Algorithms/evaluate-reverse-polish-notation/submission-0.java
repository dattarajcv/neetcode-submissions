class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for(String c: tokens){

            // Not operands
            if(!(c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/"))){
                System.out.println(c);
                stack.push(Integer.parseInt(c));
            }else{
                int b = stack.pop();
                int a = stack.pop();

                if(c.equals("+")){
                    stack.push(a +b);
                }else if(c.equals("*")){
                    stack.push(a * b);

                }else if(c.equals("-")){
                    stack.push(a - b);
                }else{
                    stack.push( a/b);
                }
            }

        }

        return stack.pop();
    }
}
