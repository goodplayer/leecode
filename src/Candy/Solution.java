package Candy;

/**
 * Created by sunsun on 15/3/15.
 */
public class Solution {
    //TODO not done yet
    public int candy(int[] ratings) {
        int[] arr = new int[ratings.length];

        int pre = Integer.MIN_VALUE;
        for (int i = 0; i < ratings.length; i++) {
            int t = ratings[i];
            if (t > pre) {
                arr[i] = 1;
            } else if (t < pre) {
                arr[i] = -1;
            } else {
                arr[i] = 0;
            }
            pre = t;
        }
    }
}
