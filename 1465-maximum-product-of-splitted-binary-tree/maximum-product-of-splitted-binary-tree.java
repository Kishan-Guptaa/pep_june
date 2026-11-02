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
    long TotalSum = 0;
    long maxProduct = 0;
    private long findSum(TreeNode root){
        if(root == null){
            return 0;
        }
        long left = findSum(root.left);
        long right = findSum(root.right);
        return root.val + left + right;
    }
    private long dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        long left = dfs(root.left);
        long right = dfs(root.right);
        long sum = left + right + root.val;
        long maxSum = TotalSum - sum;
        long product = maxSum * sum;
        maxProduct = Math.max(maxProduct, product);
        return sum;
    }

    public int maxProduct(TreeNode root) {
        TotalSum = findSum(root);
        dfs(root);
        return (int)(maxProduct % 1000000007);
    }
}