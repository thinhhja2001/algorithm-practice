package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func (l *ListNode) insert(n int) {
	newNode := &ListNode{}
	newNode.Val = n
	for l.Next != nil {
		l = l.Next
	}
	l.Next = newNode
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	result := &ListNode{}
	remember := 0
	for l1 != nil && l2 != nil {
		sum := (l1.Val+l2.Val)%10 + remember
		remember = (l1.Val + l2.Val) / 10
		result.insert(sum)
		l1 = l1.Next
		l2 = l2.Next
	}
	for l1 != nil {
		sum := l1.Val + remember
		remember = l1.Val / 10
		l1 = l1.Next
		result.insert(sum)
	}
	for l2 != nil {
		sum := l2.Val + remember
		remember = l2.Val / 10
		result.insert(sum)
		l2 = l2.Next
	}
	return result
}
func printListNode(l *ListNode) {
	current := l
	for current != nil {
		print(current.Val)
		current = current.Next
	}
}
func main() {
	l1 := &ListNode{}
	l1.insert(2)
	l1.insert(4)
	l1.insert(3)

	l2 := &ListNode{}
	l2.insert(5)
	l2.insert(6)
	l2.insert(4)

	l3 := addTwoNumbers(l1, l2)
	printListNode(l3)

}
