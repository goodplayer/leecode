package ValidParentheses;

/**
 * 2014.11.2
 */
public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        if (s.length() == 1) {
            return false;
        }

        char[] chars = new char[1];
        int len = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '{':
                case '[':
                case '(':
                    // ensure char array
                    if (len >= chars.length) {
                        char[] t = new char[chars.length * 2];
                        System.arraycopy(chars, 0, t, 0, chars.length);
                        chars = t;
                    }
                    chars[len++] = c;
                    break;
                case ')':
                case '}':
                case ']':
                    if (len == 0) {
                        return false;
                    }
                    char stackCh = chars[--len];
                    switch (c - stackCh) {
                        case 1:
                        case 2:
                            // paired (esp in ascii)
                            break;
                        default:
                            // not paired
                            return false;
                    }
                    break;
            }
        }

        return len == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isValid("((");
    }
}
