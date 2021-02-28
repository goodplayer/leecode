package PlusOne;

/**
 * 2014.11.3
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        boolean inc = true;
        for (int i = digits.length - 1; i >= 0; i--) {
            int d = digits[i];
            if (inc) {
                d++;
                inc = false;
            } else {
                break;
            }
            if (d > 9) {
                inc = true;
                digits[i] = d - 10;
            } else {
                digits[i] = d;
            }
        }

        if (inc) {
            int[] newDigits = new int[digits.length + 1];
            System.arraycopy(digits, 0, newDigits, 1, digits.length);
            newDigits[0] = 1;
            digits = newDigits;
        }

        return digits;
    }
}
