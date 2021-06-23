package eastplain;

/**
 * @author EastPlain
 * @create 2021-4-01 15:09
 */
public class LCOF22 {
}


class GetKthFromEnd {

    public ListNode method(ListNode head, int k) {

        if (head == null) {
            return head;
        }

        ListNode temp = head;
        int length = 1;

        while (temp.next != null) {
            temp = temp.next;
            length += 1;
        }

        ListNode ans = head;
        int count = 0;

        while (count < length - k) {
            ans = head.next;
            count += 1;
        }

        return ans;
    }
}
