public class n2_Add_Two_Numbers {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0, x = 0, y = 0, sum = 0;
        ListNode res = new ListNode(0);
        ListNode head = res;
        while(l1 != null || l2 != null) {
            x = l1 == null ? 0 : l1.val;
            y = l2 == null ? 0 : l2.val;

            sum = x + y + carry;

            carry = sum / 10;

            head.next = new ListNode(sum % 10);
            head = head.next;

            if(l1 != null) {
                l1 = l1.next;
            }

            if(l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry == 1) {
            head.next = new ListNode(carry);
        }

        return res.next;
    }
}
