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
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        int leftLength = getLongerSubTree(root.left);
        int rightLength = getLongerSubTree(root.right);
        return Math.max(diameter, leftLength + rightLength);
    }

    private int getLongerSubTree(TreeNode node){
        if(node == null) return 0;
        int leftLength = getLongerSubTree(node.left);
        int rightLength = getLongerSubTree(node.right);
        diameter = Math.max(diameter, leftLength + rightLength);
        return Math.max(leftLength, rightLength) + 1;
    }
}
