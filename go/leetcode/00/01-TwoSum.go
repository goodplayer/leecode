package _0

func twoSum(nums []int, target int) []int {
	idxArr := make([]int, len(nums))
	for i := 0; i < len(nums); i++ {
		idxArr[i] = i
	}
	//sort
	for i := 0; i < len(nums); i++ {
		for j := len(nums) - 1; j > i; j-- {
			if nums[j] > nums[j-1] {
				tmp := nums[j]
				nums[j] = nums[j-1]
				nums[j-1] = tmp
				tmp = idxArr[j]
				idxArr[j] = idxArr[j-1]
				idxArr[j-1] = tmp
			}
		}
	}

	//find
	maxIdx := len(nums)
	for i := 0; i < maxIdx; i++ {
	LOOP:
		for j := len(nums) - 1; j > i; j-- {
			rest := target - nums[i] - nums[j]
			if rest == 0 {
				return []int{idxArr[i], idxArr[j]}
			} else if rest < 0 {
				break LOOP
			} else {
				maxIdx = j
			}
		}
	}
	return []int{-1, -1}
}
