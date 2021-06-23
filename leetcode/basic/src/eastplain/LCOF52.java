package eastplain;

/**
 * @author EastPlain
 * @create 2021-4-01 15:48
 */
public class LCOF52 {
}


class GetIntersectionNode {

    public ListNode method(ListNode headA, ListNode headB) {

        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            if (a == null) { a = headB; }
            else { a = a.next; }
            if (b == null) { b = headA; }
            else { b = b.next; }
        }

        return a;
    }
}
