package RemoveNthNodeFromEndOfList;

/**
 * 2014.11.2
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode last = head;
        ListNode pre = null;

        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            pre = last;
            last = last.next;
        }

        if (pre != null) {
            pre.next = last.next;
            return head;
        } else {
            // first is deleted
            return last.next;
        }

    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        listNode.next = listNode1;

        Solution solution = new Solution();
        solution.removeNthFromEnd(listNode, 2);

        System.out.println(solution.removeNthFromEnd(listNode, 2));
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
