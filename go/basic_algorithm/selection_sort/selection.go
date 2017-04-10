package selection_sort

func SelectionSort(data []int) []int {
	length := len(data)
	for i := 0; i < length; i++ {
		minIdx := i
		for j := i + 1; j < length; j++ {
			if data[minIdx] > data[j] {
				minIdx = j
			}
		}
		if i != minIdx {
			temp := data[i]
			data[i] = data[minIdx]
			data[minIdx] = temp
		}
	}
	return data
}
