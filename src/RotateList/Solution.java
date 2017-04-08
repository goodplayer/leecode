package RotateList;

/**
 * Created by sunsun on 15/3/7.
 */
public class Solution {
    //TODO not done yet
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode a = head;
        ListNode b = a;

        for (int i = 0; i < n; i++) {
            b = b.next;
            if (b == null && i < n - 1) {
                return head;
            }
        }

        if (b == null) {
            return head;
        }


        while (b.next != null) {
            a = a.next;
            b = b.next;
        }

        b.next = head;
        head = a.next;
        a.next = null;
        return head;
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
