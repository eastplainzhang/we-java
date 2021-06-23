package eastplain;

/**
 * @author EastPlain
 * @create 2021-4-07 17:38
 */
public class LC0083 {
}


class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode node = head;

        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
            }
            else {
                node = node.next;
            }
        }

        return head;
    }
}
