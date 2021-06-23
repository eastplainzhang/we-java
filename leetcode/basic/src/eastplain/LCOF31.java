package eastplain;

import java.util.Stack;

public class LCOF31 {
}


class ValidateStackSequences {

    public boolean method(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();

        int i = 0;

        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i += 1;
            }
        }

        return stack.isEmpty();
    }
}
