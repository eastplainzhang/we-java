package eastplain;

/**
 * @author EastPlain
 * @create 2021-4-01 15:16
 *
 * 反转链表
 */
public class LCOF24 {
}


class ReverseList {

    public ListNode method(ListNode head) {

        ListNode previous = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }
}
