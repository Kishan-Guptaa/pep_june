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
    public int rangeSumBST(TreeNode root, int low, int high) {
        List<Integer>nums = new ArrayList<>();
        inorder(root, nums);
        int sum = 0;
        for(int i=0; i<nums.size(); i++){
            if(nums.get(i) >= low && nums.get(i) <= high){
                sum += nums.get(i);
            }
        }
        return sum;

    }
    private void inorder(TreeNode root, List<Integer>nums){
        if(root == null){
            return;
        }
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }
}