package ZigZagConversion;

/**
 * 2014.11.1
 */
public class Solution {
    public String convert(String s, int nRows) {
        if (nRows == 1) {
            return s;
        } else {
            // calculate some params
            int matrixCnt = 2 * nRows - 2;
            int nMatrix = s.length() / matrixCnt + (s.length() % matrixCnt == 0 ? 0 : 1);
            // initialize result arrays
            StringBuilder[] arrays = new StringBuilder[nRows];
            for (int i = 0; i < arrays.length; i++) {
                arrays[i] = new StringBuilder();
            }
            // initialize iteration array
            StringBuilder[] iterArr = new StringBuilder[matrixCnt];
            for (int i = 0; i < arrays.length; i++) {
                iterArr[i] = arrays[i];
            }
            for (int i = arrays.length - 2, idx = arrays.length; i > 0; i--, idx++) {
                iterArr[idx] = arrays[i];
            }

            // iter s
            for (int i = 0, idx = 0; i < s.length(); i++) {
                iterArr[idx++].append(s.charAt(i));
                if (idx == iterArr.length) {
                    idx = 0;
                }
            }

            // result
            StringBuilder result = new StringBuilder();
            for (StringBuilder e : arrays) {
                result.append(e.toString());
            }
            return result.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convert("PAYPALISHIRING", 3).equals("PAHNAPLSIIGYIR"));
    }
}
