package RemoveDuplicatesFromSortedList;

/**
 * 2014.11.7
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node = head.next;
        ListNode pre = head;
        while (node != null) {
            if (pre.val == node.val) {
                node = node.next;
            } else {
                pre.next = node;
                pre = node;
                node = pre.next;
            }
        }
        pre.next = node;
        return head;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
