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
    List<Integer>ans = new ArrayList<>();
    int i = 0;
    private boolean dfs(TreeNode root, int[] voyage){
        if(root == null){
            return true;
        }
        if(i > voyage.length || root.val != voyage[i]){
            return false;
        }
        i++;
        if(root.left != null && i < voyage.length && root.left.val != voyage[i]){
            ans.add(root.val);
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }

        return dfs(root.left, voyage) && dfs(root.right, voyage);
    }
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        if(!dfs(root, voyage)){
            return Arrays.asList(-1);
        }
        return ans;
    }
}