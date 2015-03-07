package CompareVersionNumbers;

/**
 * Created by sunsun on 15/3/7.
 */
public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] vs1 = version1.split("\\.");
        String[] vs2 = version2.split("\\.");

        int[] v1 = new int[vs1.length];
        for (int i = 0; i < v1.length; i++) {
            v1[i] = Integer.parseInt(vs1[i]);
        }
        int[] v2 = new int[vs2.length];
        for (int i = 0; i < v2.length; i++) {
            v2[i] = Integer.parseInt(vs2[i]);
        }

        int min = Math.min(v1.length, v2.length);
        for (int i = 0; i < min; i++) {
            if (v1[i] < v2[i]) {
                return -1;
            } else if (v1[i] > v2[i]) {
                return 1;
            }
        }

        if (v1.length == min) {
            for (int i = min; i < v2.length; i++) {
                if (v2[i] > 0) {
                    return -1;
                }
            }
        } else if (v2.length == min) {
            for (int i = min; i < v1.length; i++) {
                if (v1[i] > 0) {
                    return 1;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.compareVersion("1", "0");
    }
}
