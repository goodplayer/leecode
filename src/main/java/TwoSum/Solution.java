package TwoSum;

/**
 * 2014.11.6
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int idx1 = 0;
        int idx2 = 1;
        for (int gap = 1; gap < numbers.length; gap++, idx1 = 0, idx2 = idx1 + gap) {
            for (; idx2 < numbers.length; idx1++, idx2++) {
                if (numbers[idx1] + numbers[idx2] == target) {
                    return new int[]{idx1 + 1, idx2 + 1};
                }
            }
        }
        return new int[]{idx1 + 1, idx2 + 1};
    }
}
