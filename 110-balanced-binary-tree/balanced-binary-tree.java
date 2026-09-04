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
    private int balance(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(balance(root.left), balance(root.right)) + 1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int left = balance(root.left);
        int right = balance(root.right);
        if(Math.abs(left - right) > 1)
        {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }
}