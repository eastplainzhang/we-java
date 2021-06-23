package eastplain;

import java.util.Stack;

public class LC0150 {

    public static void main(String[] args) {

        String[] demo = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(new EvalRPN().evalRPN(demo));
    }
}


class EvalRPN {

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (String s : tokens) {
            System.out.println(stack);
            if (!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/")) {
                stack.push(Integer.parseInt(s));
            }
            else {
                int n1 = stack.pop();
                int n2 = stack.pop();
                if (s.equals("+")) {
                    stack.push(n2 + n1);
                }
                else if (s.equals("-")) {
                    stack.push(n2 - n1);
                }
                else if (s.equals("*")) {
                    stack.push(n2 * n1);
                }
                else {
                    stack.push(n2 / n1);
                }
            }
        }

        return stack.get(0);
    }
}
