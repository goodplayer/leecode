package selection_sort

import "testing"

func TestSelectionSort(t *testing.T) {
	t.Log(SelectionSort([]int{9, 1, 5, 8, 3, 7, 4, 6, 2}))
}
