package bubble_sort

import "testing"

func TestBubbleSort(t *testing.T) {
	t.Log(BubbleSort([]int{9, 1, 5, 8, 3, 7, 4, 6, 2}))
}
