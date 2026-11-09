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

        if (root == null) return 0;

        Stack<TreeNode> st = new Stack<>();
        Stack<Integer> depth = new Stack<>();

        st.push(root);
        depth.push(1);

        int max = 0;

        while (!st.isEmpty()) {

            TreeNode curr = st.pop();
            int d = depth.pop();

            max = Math.max(max, d);

            if (curr.right != null) {
                st.push(curr.right);
                depth.push(d + 1);
            }
            if (curr.left != null) {
                st.push(curr.left);
                depth.push(d + 1);
            }
        }

        return max;
    }
}
