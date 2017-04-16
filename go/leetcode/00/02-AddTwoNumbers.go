package _0

type ListNode struct {
	Val  int
	Next *ListNode
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	var cur *ListNode = new(ListNode)
	var head *ListNode = cur
	for l1 != nil && l2 != nil {
		sum := l1.Val + l2.Val
		if cur.Val >= 10 {
			cur.Val = cur.Val - 10
			sum = sum + 1
		}
		node := new(ListNode)
		node.Val = sum
		cur.Next = node
		cur = node

		l1 = l1.Next
		l2 = l2.Next
	}
	var rest *ListNode
	if l1 != nil {
		rest = l1
	} else if l2 != nil {
		rest = l2
	}
	for ; rest != nil; rest = rest.Next {
		sum := rest.Val
		if cur.Val >= 10 {
			cur.Val = cur.Val - 10
			sum = sum + 1
		}
		node := new(ListNode)
		node.Val = sum
		cur.Next = node
		cur = node
	}
	if cur.Val >= 10 {
		cur.Val = cur.Val - 10
		node := new(ListNode)
		node.Val = 1
		cur.Next = node
		cur = node
	}
	return head.Next
}
