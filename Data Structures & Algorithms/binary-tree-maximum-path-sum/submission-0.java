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
    private int max;
    
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        findMax(root);

        return max;
    }

    private int findMax(TreeNode node){
        if(node == null) return 0;

        int leftMax = findMax(node.left);
        int rightMax = findMax(node.right);

        max = Math.max(max, leftMax + rightMax + node.val);
        return Math.max(Math.max((leftMax + node.val), (rightMax + node.val)), 0);
    }
}
