package eastplain;

import java.util.ArrayList;
import java.util.List;

public class LC0141 {
}


class HasCycle {

    public boolean method(ListNode head) {
        List<ListNode> list = new ArrayList<>();

        if (head == null) {
            return false;
        }

        ListNode node = head;
        while (node.next != null) {
            node = node.next;
            if (list.contains(node)) {
                return true;
            }
            list.add(node);
        }

        return false;
    }
}
