package eastplain;

import java.util.Stack;

public class LC0394 {

    public static void main(String[] args) {
        String s = "100[leetcode]";
        System.out.println(new DecodeString().method(s));
    }
}


class DecodeString {

    public String method(String s) {

        Stack<Character> stack = new Stack<>();
        Stack<Character> temp = new Stack<>();
        char[] array = s.toCharArray();

        for (char c : array) {
            if (c != ']') {
                stack.push(c);
            }
            else {
                while (stack.peek() != '[') {
                    temp.push(stack.pop());
                }

                stack.pop();  // '['

                StringBuilder timeBuilder = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9') {
                    timeBuilder.insert(0, stack.pop());
                }
                String timeString = timeBuilder.toString();
                int time = Integer.parseInt(timeString);

                for (int i = 0; i < time; i++) {
                    for (int j = temp.size() - 1; j >= 0; j--) {
                        stack.push(temp.get(j));
                    }
                }
                temp.clear();
            }
        }

        StringBuilder builder = new StringBuilder();
        for (char c : stack) {
            builder.append(c);
        }
        return builder.toString();
    }
}