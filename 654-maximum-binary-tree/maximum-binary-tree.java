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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return BuildTree(nums, 0, nums.length - 1);
    }
    private TreeNode BuildTree(int[] nums, int left, int right){
        if(left > right){
            return null;
        }
        int max = left;
        for(int i = left; i <= right; i++){
            if(nums[max] < nums[i]){
                max = i;
            }
        }
        TreeNode root = new TreeNode(nums[max]);
        root.left = BuildTree(nums, left, max- 1);
        root.right = BuildTree(nums, max + 1, right);
        return root;
    }
}