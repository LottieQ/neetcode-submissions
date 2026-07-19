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
    int ans;

    public int goodNodes(TreeNode root) {
        ans = 0;
        if(root == null) return 0;
        dfs(root, root.val);
        return ans;
    }

    private void dfs(TreeNode node, int max){
        if(node == null) return;

        if(node.val >= max){
            ans++;
            max = node.val;
        }
        
        dfs(node.left, max);
        dfs(node.right, max);
        return;
    }
}
