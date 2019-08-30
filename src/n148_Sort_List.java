public class n148_Sort_List {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    //补充：归并排序，自顶向下：Time:O(nlogn)，Space:O(logn)
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = sortList(slow.next);
        slow.next = null;
        ListNode left = sortList(head);
        return mergeSort(left, right);
    }

    private ListNode mergeSort(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode result = new ListNode(0);
        ListNode cur = result;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return result.next;
    }

    //补充：并不严格的快速排序：Time:O(nlogn)，Space:O(n)
    public ListNode sortList2(ListNode head) {
        quickSort(head, null);
        return head;
    }

    private void quickSort(ListNode head, ListNode end){
        if(head == end || head.next == end) return;
        int privot = head.val;
        ListNode slow = head, fast = head.next;
        while(fast != end) {
            if(fast.val <= privot) {
                slow = slow.next;
                swap(slow, fast);
            }
            fast = fast.next;
        }
        swap(head, slow);
        quickSort(head, slow);
        quickSort(slow.next, end);
    }

    private void swap(ListNode l1, ListNode l2) {
        int temp = 0;
        temp = l1.val;
        l1.val = l2.val;
        l2.val = temp;
    }
}