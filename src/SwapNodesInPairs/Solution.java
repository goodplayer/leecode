package SwapNodesInPairs;

/**
 * 2014.11.7
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode first = head;
        ListNode second = head.next;
        if (second == null) {
            return first;
        }

        head = second;
        pre = first;
        first.next = second.next;
        second.next = first;

        while (pre.next != null) {
            first = pre.next;
            second = first.next;
            if (second == null) {
                break;
            }
            pre.next = second;
            first.next = second.next;
            second.next = first;
            pre = first;
        }

        return head;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
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
