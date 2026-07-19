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

    List<List<Integer>> output;
    public List<List<Integer>> levelOrder(TreeNode root) {
        output = new ArrayList<>();
        int level = 0;
        updateList(root, level);
        return output;
    }

    private void updateList(TreeNode node, int level){
        if(node == null){
            return;
        }

        if(level >= output.size()){
            output.add(new ArrayList<>());
        }

        output.get(level).add(node.val);
        level++;
        updateList(node.left, level);
        updateList(node.right, level);
    }
}
