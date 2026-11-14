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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) // nothing
            return root;

        if (root.left == null && root.right == null) //leaf
            return root;

        if (root.left != null && root.right != null){
            TreeNode aux = root.left;
            root.left = invertTree(root.right);
            root.right = invertTree(aux);
        } 
        else if (root.right == null){
            root.right = invertTree(root.left);
            root.left = null;
        }
        else{
            root.left = invertTree(root.right);
            root.right = null;
        }

        return root;
    }
}
