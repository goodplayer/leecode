package AddBinary;

/**
 * 2014.11.5
 */
public class Solution {
    public String addBinary(String a, String b) {
        char[] maxArr = a.toCharArray();
        char[] minArr = b.toCharArray();

        if (maxArr.length < minArr.length) {
            char[] t = minArr;
            minArr = maxArr;
            maxArr = t;
        }

        if (maxArr.length == minArr.length && maxArr.length == 0) {
            return "0";
        }

        int maxLength = maxArr.length - 1;
        int minLength = minArr.length - 1;

        char[] result = new char[maxLength + 1 + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = '0';
        }

        int idx = result.length - 1;

        for (; minLength >= 0; minLength--, maxLength--, idx--) {
            char ch1 = minArr[minLength];
            char ch2 = maxArr[maxLength];
            if (ch1 == ch2 && ch2 == '1') {
                result[idx - 1] = '1';
            } else if (ch1 == ch2 && ch2 == '0') {
                // omit
            } else {
                if (result[idx] == '1') {
                    result[idx] = '0';
                    result[idx - 1] = '1';
                } else {
                    result[idx] = '1';
                }
            }
        }
        for (; maxLength >= 0; maxLength--, idx--) {
            char ch1 = maxArr[maxLength];
            char ch2 = result[idx];
            if (ch1 == ch2 && ch2 == '1') {
                result[idx] = '0';
                result[idx - 1] = '1';
            } else if (ch1 == ch2 && ch2 == '0') {
            } else {
                result[idx] = '1';
            }
        }

        if (result[0] == '0') {
            return new String(result, 1, result.length - 1);
        } else {
            return new String(result);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.addBinary("100", "110010");
    }
}
