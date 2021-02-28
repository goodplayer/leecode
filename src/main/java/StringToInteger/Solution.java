package StringToInteger;

/**
 * 2014.11.1
 */
public class Solution {
    public int atoi(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        int idx = 0;
        boolean start = false;

        // omit whitespace characters
        for (; idx < str.length(); idx++) {
            if (!Character.isWhitespace(str.charAt(idx))) {
                break;
            }
        }

        char[] chArr = new char[10];
        int nChar = 0;
        boolean overflow = false;
        boolean neg = false;

        char first = str.charAt(idx);
        switch (first) {
            case '-':
                neg = true;
                break;
            case '+':
                break;
            default:
                if (first >= '0' && first <= '9') {
                    chArr[nChar++] = first;
                    break;
                } else {
                    return 0;
                }
        }

        for (idx++; idx < str.length(); idx++) {
            char tCh = str.charAt(idx);
            if (tCh >= '0' && tCh <= '9') {
                if (nChar == 10) {
                    overflow = true;
                    break;
                } else {
                    chArr[nChar++] = tCh;
                    continue;
                }
            } else {
                break;
            }
        }

        // basically overflow
        if (nChar == 0) {
            return 0;
        }
        if (overflow) {
            if (neg) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }

        if (nChar < 10) {
            // <=9 places
            int r = 0;
            for (int i = 0; i < nChar; i++) {
                r = r * 10 + (chArr[i] - '0');
            }
            if (neg) {
                r = -r;
            }
            return r;
        } else {
            // 10 places
            int last = chArr[9] - '0';
            int r = 0;
            for (int i = 0; i < 9; i++) {
                r = r * 10 + (chArr[i] - '0');
            }
            if (r > Integer.MAX_VALUE / 10) {
                // overflow
                if (neg) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            } else if (r == Integer.MAX_VALUE / 10) {
                if (neg && last <= 8) {
                    // accept
                    r = -r;
                    r = r * 10 - (last);
                } else if ((!neg) && last <= 7) {
                    // accept
                    r = r * 10 + (last);
                } else {
                    // overflow
                    if (neg) {
                        return Integer.MIN_VALUE;
                    } else {
                        return Integer.MAX_VALUE;
                    }
                }
            } else {
                if (neg) {
                    r = -r;
                    r = r * 10 - (last);
                } else {
                    r = r * 10 + (last);
                }
            }
            return r;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.atoi("-1010023630o4");
    }
}
