package eastplain;

/**
 * @author EastPlain
 * @create 2021-4-01 15:29
 */
public class LCOF18 {
}


class DeleteNode {

    public ListNode method(ListNode head, int val) {

        if (head == null) {
            return head;
        }

        if (val == head.val) {
            return head.next;
        }

        ListNode node = head;
        while (node.next != null) {
            if (val == node.next.val) {
                node.next = node.next.next;
                return head;
            }
            node = node.next;
        }

        return head;
    }
}
