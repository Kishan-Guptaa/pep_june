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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode>Q = new LinkedList<>();
        Q.add(root);
        boolean findNull = false;
        while(!Q.isEmpty()){
            TreeNode node = Q.poll();
            if(node == null){
                findNull = true;
            }
            else{
                if(findNull){
                    return false;
                }
                Q.add(node.left);
                Q.add(node.right);
            }
        }
        return true;
    }
}