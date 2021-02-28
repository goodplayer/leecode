package RomanToInteger;

/**
 * 2014.11.2
 */
public class Solution {
    public int romanToInt(String s) {
        // no need to consider: > 3 repeats

        int result = 0;

        int lastValue = 0;
        int toAddValue = 0;
        boolean neg = false;
        for (int i = 0; i < s.length(); i++) {
            toAddValue = lastValue;
            char c = s.charAt(i);
            switch (c) {
                case 'i':
                case 'I':
                    neg = lastValue < 1;
                    lastValue = 1;
                    break;

                case 'v':
                case 'V':
                    neg = lastValue < 5;
                    lastValue = 5;
                    break;

                case 'x':
                case 'X':

                    neg = lastValue < 10;
                    lastValue = 10;
                    break;

                case 'l':
                case 'L':
                    neg = lastValue < 50;
                    lastValue = 50;
                    break;

                case 'c':
                case 'C':
                    neg = lastValue < 100;
                    lastValue = 100;
                    break;

                case 'd':
                case 'D':
                    neg = lastValue < 500;
                    lastValue = 500;
                    break;

                case 'm':
                case 'M':
                    neg = lastValue < 1000;
                    lastValue = 1000;
                    break;
            }
            result += neg ? -toAddValue : toAddValue;
        }
        result += lastValue;
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.romanToInt("MMXIV"));
    }
}
