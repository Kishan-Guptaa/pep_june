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
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode>result = new ArrayList<>();

        if(n% 2 == 0){
            return result;
        }
        if(n == 1){
             result.add(new TreeNode(0));
            return result;
        }

        for(int leftNode = 1; leftNode < n; leftNode += 2){
            int rightNode = n - 1 - leftNode;
            List<TreeNode>leftSide = allPossibleFBT(leftNode);
            List<TreeNode>rightSide = allPossibleFBT(rightNode);

            for(TreeNode left : leftSide){
                for(TreeNode right : rightSide){
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        return result;
    }
}