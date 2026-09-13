class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            switch (c) {
                case '(', '{', '[' -> stack.push(c);
                case ')' -> {
                    if (!check(stack, '('))
                        return false;
                }
                case '}' -> {
                    if (!check(stack, '{'))
                        return false;
                }
                case ']' -> {
                    if (!check(stack, '['))
                        return false;
                }
            }
        }
        if (!stack.empty())
            return false;

        return true;
    }

    public boolean check(Stack<Character> stack, char expected) {
        if (stack.empty())
            return false;
        return stack.pop() == expected;
    }
}
