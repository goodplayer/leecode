package ValidNumber;

/**
 * 2014.11.8
 */
public class Solution {
    //TODO not done yet
    public boolean isNumber(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        int idx = 0;
        // pos or neg
        switch (s.charAt(idx)) {
            case '+':
            case '-':
                if (s.length() == 1) {
                    return false;
                }
                char c = s.charAt(1);
                if (c < '0' || c > '9') {
                    return false;
                }
                idx++;
                break;
        }

        // leading zero cnt
        int nZero = 0;
        for (int i = idx; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                nZero++;
            } else {
                break;
            }
        }
        if (nZero > 1) {
            return false;
        }

        idx += nZero;
        int partEndIdx = idx;
        boolean findE = false;

        // science - first part
        int firstStart = 0;
        int firstEnd = 0;
        for (; firstEnd < s.length(); firstEnd++) {
            char c = s.charAt(firstEnd);
            if (c == 'e') {
                findE = true;
                break;
            }
            if (c != '.' && c != '+' && c != '-' && (c < '0' || c > '9')) {
                return false;
            }
        }
        // TODO check first part - decimal

        // science - second part
        if (findE) {
            if (firstEnd + 1 >= s.length()) {
                return false;
            }
            int secondStart = firstEnd + 1;
            int secondEnd = secondStart;
            for (; secondEnd < s.length(); secondEnd++) {
                char c = s.charAt(secondEnd);
                if (c != '+' && c != '-' && (c < '0' || c > '9')) {
                    return false;
                }
            }
            // TODO check second part - number

        } else {
            return true;
        }




        return true;
    }
}
