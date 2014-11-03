package RemoveDuplicatesFromSortedArray;

/**
 * 2014.11.2
 */
public class Solution {
    public int removeDuplicates(int[] A) {
        if (A.length == 0) {
            return 0;
        }

        int currentIdx = 0;
        int start = 0;
        int idx = -1;

        for (; currentIdx < A.length; currentIdx++) {
            if (A[start] != A[currentIdx]) {
                A[++idx] = A[start];
                start = currentIdx;
            }
        }

        A[++idx] = A[start];

        return idx + 1;
    }
}
