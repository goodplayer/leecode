package PascalsTriangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sunsun on 15/3/7.
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> r = new ArrayList<>();
        if (numRows == 0) {
            return r;
        }

        List<Integer> pre = Arrays.asList(1);
        r.add(pre);

        if (numRows == 1) {
            return r;
        } else {
            for (int i = 1; i < numRows; i++) {
                List<Integer> cur = new ArrayList<>();
                for (int k = -1; k < pre.size(); k++) {
                    int left = k < 0 ? 0 : pre.get(k);
                    int right = k + 1 >= pre.size() ? 0 : pre.get(k + 1);
                    cur.add(left + right);
                }
                r.add(cur);
                pre = cur;
            }
        }

        return r;

    }
}
