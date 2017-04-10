package bubble_sort

func BubbleSort(data []int) []int {
	length := len(data)
	for i := 0; i < length; i++ {
		for j := length - 1; j > i; j-- {
			if data[j - 1] > data[j] {
				temp := data[j]
				data[j] = data[j - 1]
				data[j - 1] = temp
			}
		}
	}
	return data
}
