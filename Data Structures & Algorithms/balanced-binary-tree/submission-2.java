/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        return (helper(root)[0] == 0);
    }

    private int[] helper(TreeNode node){
        //output[0] : check if balanced (0 balanced, 1 imbalanced)
        //output[1] : height
        int[] output = new int[2];
        if(node == null){
            return new int[]{0, 0};
        }

        int[] left = helper(node.left);
        int[] right = helper(node.right);

        output[1] = Math.max(left[1], right[1]) + 1;
        output[0] = (((left[0] + right[0]) == 0) && (Math.abs(left[1] - right[1]) < 2)) ? 0 : 1;
        return output;
    }
}
