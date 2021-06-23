package eastplain;

/**
 * @author EastPlain
 * @create 2021-4-07 17:01
 */
public class LC0021 {
}


class MergeTwoLists {

    public ListNode method(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }

        else if (l2 == null) {
            return l1;
        }

        else if (l1.val < l2.val) {
            l1.next = method(l1.next, l2);
            return l1;
        }

        else {
            l2.next = method(l2.next, l1);
            return l2;
        }
    }
}
