package Combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * 2014.11.5
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();

        if (n < k) {
            return list;
        }

        int[] idxes = new int[k];
        for (int i = 0; i < k; i++) {
            idxes[i] = i;
        }

        do {
            if (idxes[k - 1] < n) {
                List<Integer> l = new ArrayList<>();
                for (int i = 0; i < k; i++) {
                    l.add(idxes[i] + 1);
                }
                list.add(l);
            }
            for (int i = k - 1; i >= 0; i--) {
                idxes[i] = idxes[i] + 1;
                if (idxes[i] >= n) {
                    continue;
                } else {
                    for (int x = i + 1, inc = 1; x < k; x++, inc++) {
                        idxes[x] = idxes[i] + inc;
                    }
                    break;
                }
            }
        } while (idxes[0] < n);

        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combine(4, 3));
    }
}
