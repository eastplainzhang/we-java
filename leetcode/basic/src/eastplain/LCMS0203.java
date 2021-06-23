package eastplain;

public class LCMS0203 {
}


class DeleteNode {

    public void method(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;
    }
}