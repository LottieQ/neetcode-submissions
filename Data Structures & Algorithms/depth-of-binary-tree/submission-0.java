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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 0;
        int count = 1;
        queue.offer(root);


        while(!queue.isEmpty()){
            depth++;
            int tempCount = 0;
            for(int i = 0; i < count; i++){
                TreeNode curr = queue.poll();
                if(curr.left != null) {
                    queue.offer(curr.left);
                    tempCount++;
                }
                if(curr.right != null) {
                    queue.offer(curr.right);
                    tempCount++;
                }
            }
            count = tempCount;
        }
        return depth;
    }
}
