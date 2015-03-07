package MinStack;

/**
 * Created by sunsun on 15/3/7.
 */
public class MinStack {
    class Node {
        private int e;
        private Node next;
        private Node pre;
    }

    //TODO use another stack to track minimum number

    private int cnt = 0;
    private int min;
    private Node top;

    private void findMin() {
        Node node = top;
        if (node == null) {
            return;
        }
        int min = node.e;
        node = node.pre;
        while (node != null) {
            if (min > node.e) {
                min = node.e;
            }
            node = node.pre;
        }
        this.min = min;
    }

    public void push(int x) {
        cnt++;
        if (cnt == 1) {
            top = new Node();
            top.e = x;
            min = x;
        } else {
            Node tmp = new Node();
            tmp.e = x;
            tmp.pre = top;
            top.next = tmp;
            top = tmp;
            if (x < min) {
                min = x;
            }
        }
    }

    public void pop() {
        cnt--;
        Node r = top;
        top = top.pre;
        if (cnt > 0) {
            top.next = null;
            if (r.e == min) {
                findMin();
            }
        }
    }

    public int top() {
        return top.e;
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        minStack.top();
        minStack.pop();
        minStack.getMin();
        minStack.pop();
        minStack.getMin();
        minStack.pop();
        minStack.push(2147483647);
        minStack.top();
        minStack.getMin();
        minStack.push(-2147483648);
        minStack.top();
        minStack.getMin();
        minStack.pop();
        minStack.getMin();

        MinStack minStack1 = new MinStack();
        minStack1.push(0);
        minStack1.push(1);
        minStack1.push(0);
        minStack1.pop();
    }
}
