public class n234_Palindrome_Linked_List {

    public static class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
 }

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast != null){ //如果链表元素个数为奇数个，则slow指针要后移
            slow = slow.next;
        }

        slow = reverse(slow);
        while(slow != null) {
            if(slow.val != head.val) {
                return false;
            }
            slow = slow.next;
            head = head.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null, next = null;
        while(head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
