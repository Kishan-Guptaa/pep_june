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
        return helper(nums,0, nums.length-1);
    }
    private TreeNode helper(int[] nums, int i, int j){
        if(i > j){
            return null;
        }

        int max = i;
        for(int k = i; k<=j; k++){
            if(nums[max] < nums[k]){
                max = k;
            }
        }
        TreeNode node = new TreeNode(nums[max]);
        node.left = helper(nums, i, max-1);
        node.right = helper(nums, max+1, j);
        return node;
    }
}