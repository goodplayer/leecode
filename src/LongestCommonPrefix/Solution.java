package LongestCommonPrefix;

/**
 * 2014.11.2
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // can be optimised!!!

        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        for (String str : strs) {
            if (str == null || str.isEmpty()) {
                return "";
            }
        }

        String first = strs[0];
        for (int i = 0; i < first.length(); i++) {
            boolean lengthNotEnough = false;
            char c = first.charAt(i);
            for (int k = 1; k < strs.length; k++) {
                String cur = strs[k];
                if (cur.length() <= i) {
                    lengthNotEnough = true;
                    break;
                }
                if (cur.charAt(i) != c) {
                    lengthNotEnough = true;
                    break;
                }
            }
            if (lengthNotEnough) {
                return first.substring(0, i);
            }
        }
        return first;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.longestCommonPrefix(new String[]{"aa","aaaa","aab","aaa","aab"});
    }
}
