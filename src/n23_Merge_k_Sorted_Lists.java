import java.util.Comparator;
import java.util.PriorityQueue;

public class n23_Merge_k_Sorted_Lists {

    public class ListNode {
        int val;
        n23_Merge_k_Sorted_Lists.ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, Comparator.comparingInt(l -> l.val));

        ListNode dummy = new ListNode(0);
        ListNode head = dummy;

        for(ListNode node : lists) {
            if(node != null) {
                queue.add(node);
            }
        }

        while(!queue.isEmpty()) {
            head.next = queue.poll();
            head = head.next;
            if(head.next != null) {
                queue.add(head.next);
            }
        }
        return dummy.next;
    }

}
