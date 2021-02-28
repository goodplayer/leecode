package PascalsTriangleII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by sunsun on 15/3/7.
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        rowIndex++;
        if (rowIndex == 0) {
            return Collections.emptyList();
        } else if (rowIndex == 1) {
            List result = new ArrayList<>();
            result.add(1);
            return result;
        }

        int[] r = new int[rowIndex];
        int preCnt = 1;

        r[0] = 1;

        int tmp = 0;
        for (int i = 1; i < rowIndex; i++, preCnt++) {
            for (int k = -1; k < preCnt; k++) {
                int left = k < 0 ? 0 : r[k];
                int right = k + 1 >= preCnt ? 0 : r[k + 1];
                if (k >= 0) {
                    r[k] = tmp;
                }
                tmp = left + right;
            }
            r[preCnt] = tmp;
        }

        List<Integer> result = new ArrayList<>(rowIndex);
        for (int d : r) {
            result.add(d);
        }

        return result;
    }
}
