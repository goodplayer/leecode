package AddTwoNumbers;

/**
 * 2014.11.5
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode pre = null;
        ListNode curNode = head;
        int toAdd = 0;

        while (l1 != null && l2 != null) {
            curNode.val = l1.val + l2.val + toAdd;
            if (curNode.val >= 10) {
                toAdd = 1;
                curNode.val -= 10;
            } else {
                toAdd = 0;
            }
            curNode.next = new ListNode(0);
            pre = curNode;
            curNode = curNode.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l2 != null) {
            l1 = l2;
        }
        while (l1 != null) {
            curNode.val = l1.val + toAdd;
            if (curNode.val >= 10) {
                toAdd = 1;
                curNode.val -= 10;
            } else {
                toAdd = 0;
            }
            curNode.next = new ListNode(0);
            pre = curNode;
            curNode = curNode.next;
            l1 = l1.next;
        }

        if (toAdd > 0) {
            curNode.val = toAdd;
        } else {
            pre.next = null;
        }

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
