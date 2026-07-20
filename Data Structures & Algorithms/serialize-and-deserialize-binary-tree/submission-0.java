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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size = 0;

        while(!queue.isEmpty()){
            size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll();
                if(curr != null){
                    queue.offer(curr.left);
                    queue.offer(curr.right);
                    sb.append(Integer.toString(curr.val));
                    sb.append('#');
                }else{
                    sb.append("null#");
                }
            }
        }
        
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }

        String[] values = data.split("#");

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        int index = 1;

        while (!queue.isEmpty() && index < values.length) {
            TreeNode parent = queue.poll();

            // Build left child
            if (!values[index].equals("null")) {
                TreeNode leftNode =
                    new TreeNode(Integer.parseInt(values[index]));

                parent.left = leftNode;
                queue.offer(leftNode);
            }
            index++;

            // Build right child
            if (index < values.length && !values[index].equals("null")) {
                TreeNode rightNode =
                    new TreeNode(Integer.parseInt(values[index]));

                parent.right = rightNode;
                queue.offer(rightNode);
            }
            index++;
        }

        return root;
    }
}
