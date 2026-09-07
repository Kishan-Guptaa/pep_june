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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer>set = new HashSet<>();
        List<TreeNode>ans = new ArrayList<>();
        for(int num : to_delete){
            set.add(num);
        }
        dfs(root, true, set, ans);
        return ans;
    }
    private TreeNode dfs(TreeNode root, boolean isRoot, Set<Integer>set, List<TreeNode>ans){
        if(root == null){
            return null;
        }
        boolean deleted = set.contains(root.val);
        if(isRoot && !deleted){
            ans.add(root);
        }
        root.left = dfs(root.left, deleted,set, ans);
        root.right = dfs(root.right, deleted, set, ans);
        if(deleted){
            return null;
        }
        return root;
    }
}