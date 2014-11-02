package ReverseInteger;

/**
 * 2014.11.1
 */
public class Solution {
    // note as the page said: 1. end with 0, e.g. 10, 100  2. overflow
    public int reverse(int x) {
        int orig = x;
        // Integer.MIN_VALUE is overflow!
        if (x == Integer.MIN_VALUE) {
            throw new RuntimeException("overflow: " + Integer.MIN_VALUE);
        }

        // 0 is 0!
        if (x == 0) {
            return 0;
        }

        int neg = x < 0 ? 1 : 0;

        if (neg == 1) {
            x = -x;
        }

        int nPlaces = 0;
        int[] places = new int[10];

        while (x != 0) {
            places[nPlaces++] = x % 10;
            x /= 10;
        }

        // <= 9 places
        if (nPlaces <= 9) {
            int result = 0;
            for (int i = 0; i < nPlaces; i++) {
                result = result * 10 + places[i];
            }
            if (neg == 1) {
                return -result;
            } else {
                return result;
            }
        } else { // 10 places
            // 10 places num check: ending should less than 3
            if (places[0] > 2) {
                throw new RuntimeException("overflow: " + orig);
            } else {
                int r = 0;
                for (int i = 0; i < 9; i++) {
                    r = r * 10 + places[i];
                }
                int o = (Integer.MAX_VALUE / 10);
                if (r > o) {
                    throw new RuntimeException("overflow: " + orig);
                } else if (r == o) {
                    if (neg == 1) {
                        //neg
                        if (places[9] > 8) {
                            throw new RuntimeException("overflow: " + orig);
                        }
                        r = -r;
                        r = r * 10 - places[9];
                        return r;
                    } else {
                        if (places[9] > 7) {
                            throw new RuntimeException("overflow: " + orig);
                        }
                        r = r * 10 + places[9];
                        return r;
                    }
                } else {
                    r += places[9];
                    return r;
                }
            }
        }
    }
}
