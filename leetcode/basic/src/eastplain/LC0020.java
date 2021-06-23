package eastplain;

import java.util.Stack;

public class LC0020 {

    public static void main(String[] args) {

        System.out.println(new IsValid().isValid("(]"));
    }
}


class IsValid {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        char[] c = s.toCharArray();

        stack.add(c[0]);

        for (int i = 1; i < c.length; ++i) {
            if (c[i] == '(' || c[i] == '[' || c[i] == '{') {
                stack.add(c[i]);
            }
            else if (c[i] == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false;
                }
                stack.pop();
            }
            else if (c[i] == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return false;
                }
                stack.pop();
            }
            else {
                if (stack.isEmpty() || stack.peek() != '{') {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
