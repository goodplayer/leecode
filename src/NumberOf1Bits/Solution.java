package NumberOf1Bits;

/**
 * Created by sunsun on 15/3/12.
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int cnt = 0;
        long a = n & 0x00000000ffffffffl;
        while (a != 0) {
            cnt++;
            a = a / ((a ^ (a - 1)) + 1);
        }
        return cnt;
    }
}
