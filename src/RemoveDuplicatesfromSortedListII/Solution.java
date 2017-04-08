package RemoveDuplicatesfromSortedListII;

/**
 * Created by sunsun on 15/3/7.
 */
public class Solution {
    //TODO not done yet
    public ListNode deleteDuplicates(ListNode head) {
        ListNode lastAvailable;
        ListNode cur = head;

        if (cur == null) {
            return null;
        }

        while (cur.next != null) {
            if (cur.val == cur.next.val) {
            }
        }

        return null;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}