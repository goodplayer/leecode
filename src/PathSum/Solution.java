package PathSum;

/**
 * 2014.11.7
 */
public class Solution {
    //TODO not done yet
    public boolean hasPathSum(TreeNode root, int sum) {
        TreeNode tmp = null;

        TreeNode[] array = new TreeNode[1];
        int length = 0;

        if (root == null) {
            return false;
        }

        // stack simulation
        if (length >= array.length) {
            TreeNode[] newArray = new TreeNode[array.length << 1];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        array[length++] = root;

        //TODO
        return false;
    }
}

/**
 * Definition for binary tree
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
