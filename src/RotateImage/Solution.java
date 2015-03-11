package RotateImage;

/**
 * Created by sunsun on 15/3/11.
 */
public class Solution {
    public void rotate(int[][] matrix) {
        int N = matrix.length;

        if (N == 0 || N == 1) {
            return;
        }

        int n = N / 2;

        for (int p = 0; p < n; p++) {
            int start = p;
            int end = N - p - 1;

            for (int x = start, b = 0; x < end; x++, b++) {
                int startFix = start + b;
                int endFix = end - b;
                int t = matrix[start][startFix];
                matrix[start][startFix] = matrix[endFix][start];
                matrix[endFix][start] = matrix[end][endFix];
                matrix[end][endFix] = matrix[startFix][end];
                matrix[startFix][end] = t;
            }
        }

    }
}

