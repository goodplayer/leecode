package ExcelSheetColumnNumber;

/**
 * Created by sunsun on 15/3/13.
 */
public class Solution {
    public int titleToNumber(String s) {
        int sum = 0;
        int factor = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            sum += (s.charAt(i) - 'A' + 1) * factor;
            factor *= 26;
        }
        return sum;
    }
}
