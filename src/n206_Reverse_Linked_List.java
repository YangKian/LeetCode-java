public class n206_Reverse_Linked_List {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }

    //迭代版
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode sur;
        while(cur != null) {
            sur = cur.next;
            cur.next = pre;
            pre = cur;
            cur = sur;
        }
        return pre;
    }

    //递归版
    public ListNode reverseList1(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
