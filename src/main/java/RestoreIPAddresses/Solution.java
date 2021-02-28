package RestoreIPAddresses;

import java.util.ArrayList;
import java.util.List;

/**
 * 2014.11.4
 */
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        if (s == null || s.isEmpty()) {
            return list;
        }

        char[] charArray = s.toCharArray();
        int[] nArr = new int[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            nArr[i] = charArray[i] - '0';
        }

        int[] tmp = new int[4];
        int[] start = new int[4];
        int[] end = new int[4];

        for (int i = 0; i < 3 && i < nArr.length; i++) {
            for (int j = i + 1; j < i + 4 && j < nArr.length; j++) {
                for (int k = j + 1; k < j + 4 && k < nArr.length; k++) {
                    if (nArr.length - k - 1 > 3 || nArr.length - k - 1 <= 0) {
                        continue;
                    }

                    start[0] = 0;
                    start[1] = i + 1;
                    start[2] = j + 1;
                    start[3] = k + 1;

                    end[0] = i;
                    end[1] = j;
                    end[2] = k;
                    end[3] = nArr.length - 1;

                    boolean valid = true;

                    for (int p = 0; p < 4; p++) {
                        tmp[p] = 0;
                        // prepare params
                        if (nArr[start[p]] == 0 && (end[p] - start[p] > 0)) {
                            valid = false;
                            break;
                        }
                        for (int q = start[p]; q <= end[p]; q++) {
                            tmp[p] = tmp[p] * 10 + nArr[q];
                        }
                        if (tmp[p] > 255) {
                            valid = false;
                            break;
                        }
                    }

                    if (valid) {
                        list.add(tmp[0] + "." + tmp[1] + "." + tmp[2] + "." + tmp[3]);
                    }
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.restoreIpAddresses("010010"));
    }
}
