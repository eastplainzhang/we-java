package eastplain;

import java.util.Stack;

public class LCOF09 {

}


class CQueue {

    Stack<Integer> s1;
    Stack<Integer> s2;

    public CQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void appendTail(int value) {
        s1.add(value);
    }

    public int deleteHead() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        if (s2.isEmpty()) {
            return -1;
        }
        else {
            return s2.pop();
        }

    }

}