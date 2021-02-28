package _experience;

import _shared.ListNode;

public class MergeKSortedList {

    public static void main(String[] args) {
        ListNode n11 = new ListNode(4);
        ListNode n1 = new ListNode(1, n11);

        ListNode n22 = new ListNode(3);
        ListNode n2 = new ListNode(1, n22);

        new Solution().mergeKLists(new ListNode[]{n1, n2});
    }
}

class Solution {

    private ListNode findMin(ListNode[] lists) {
        ListNode min = null;
        int idx = -1;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) {
                continue;
            }
            if (min == null || (lists[i].val < min.val)) {
                min = lists[i];
                idx = i;
            }
        }
        if (idx >= 0) {
            lists[idx] = lists[idx].next;
        }
        return min;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        // find head
        ListNode head = findMin(lists);
        ListNode last = head;

        if (last == null) {
            return head;
        }

        ListNode minNode = null;
        while ((minNode = findMin(lists)) != null) {
            last.next = minNode;
            last = minNode;
            last.next = null;
        }

        return head;
    }
}