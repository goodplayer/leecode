package PalindromeNumber;

/**
 * 2014.11.2
 */
public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        if (x % 10 == 0) {
            return false;
        }

        int a = x;
        int newN = 0;

        do {
            newN = newN * 10 + a % 10;
            a /= 10;
        } while (a > newN);

        if (a == 0) {
            return newN == x;
        }

        if (newN / a >= 10) {
            newN /= 10;
        }
        return newN == a;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(12));
    }
}
