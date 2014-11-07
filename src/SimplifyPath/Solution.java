package SimplifyPath;

/**
 * 2014.11.7
 */
public class Solution {
    public String simplifyPath(String path) {
        int strStart = 0;
        int strEnd = 0;

        // 1 s_slash
        //   s_slash + slash = s_slash   s_slash + word = s_word + 'start'
        // 2 s_word
        //   s_word + word = s_word   s_word + slash = s_slash + 'end'

        int state = 1;

        String[] array = new String[1];
        int length = 0;

        for (int i = 0; i < path.length(); i++) {
            char ch = path.charAt(i);
            switch (state) {
                case 1:
                    if (ch != '/') {
                        state = 2;
                        strStart = i;
                    }
                    break;
                case 2:
                    if (ch == '/') {
                        state = 1;
                        strEnd = i - 1;
                        //  word processing
                        if (length >= array.length) {
                            String[] newArray = new String[array.length * 2];
                            System.arraycopy(array, 0, newArray, 0, array.length);
                            array = newArray;
                        }
                        array[length++] = path.substring(strStart, strEnd + 1);
                    }
                    break;
            }
        }

        if (state == 2) {
            strEnd = path.length() - 1;
            // last word
            if (length >= array.length) {
                String[] newArray = new String[array.length * 2];
                System.arraycopy(array, 0, newArray, 0, array.length);
                array = newArray;
            }
            array[length++] = path.substring(strStart, strEnd + 1);
        }

        if (length == 0) {
            return "/";
        }

        String[] resultArray = new String[length];
        int resultLength = 0;
        for (int i = 0; i < length; i++) {
            String s = array[i];
            if ("..".equals(s)) {
                if (resultLength > 0) {
                    resultLength--;
                }
            } else if (".".equals(s)) {
                continue;
            } else {
                resultArray[resultLength++] = s;
            }
        }

        if (resultLength == 0) {
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < resultLength; i++) {
            sb.append("/").append(resultArray[i]);
        }

        return sb.toString();
    }
}
