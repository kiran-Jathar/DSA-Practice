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
    public boolean isSameTree(TreeNode p, TreeNode q) {

        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();

        st1.push(p);
        st2.push(q);

        while (!st1.isEmpty() && !st2.isEmpty()) {

            TreeNode a = st1.pop();
            TreeNode b = st2.pop();

            // Both nodes are null
            if (a == null && b == null) {
                continue;
            }

            // Only one node is null
            if (a == null || b == null) {
                return false;
            }

            // Values are different
            if (a.val != b.val) {
                return false;
            }

            // Push left children
            st1.push(a.left);
            st2.push(b.left);

            // Push right children
            st1.push(a.right);
            st2.push(b.right);
        }

        return st1.isEmpty() && st2.isEmpty();
    }
}
