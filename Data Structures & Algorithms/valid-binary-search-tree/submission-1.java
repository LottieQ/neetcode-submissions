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
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;

        return isValidCheck(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidCheck(TreeNode node, int min, int max){
        if(node == null){
            return true;
        }

        return (node.val > min && node.val < max) && isValidCheck(node.left, min, node.val) && isValidCheck(node.right, node.val, max);
    }
}
