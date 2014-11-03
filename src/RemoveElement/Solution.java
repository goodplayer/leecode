package RemoveElement;

/**
 * 2014.11.3
 */
public class Solution {
    public int removeElement(int[] A, int elem) {
        if (A.length == 0) {
            return 0;
        }

        int idx = -1;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == elem) {
                continue;
            }
            A[++idx] = A[i];
        }

        return idx + 1;
    }
}
