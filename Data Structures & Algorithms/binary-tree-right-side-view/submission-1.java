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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;   

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        TreeNode curr = null;

        while(!queue.isEmpty()){
            int level = queue.size();
            for(int i = 0; i < level; i++){
                curr = queue.poll();
                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }
            list.add(curr.val);
        }
        return list;
    }
}
