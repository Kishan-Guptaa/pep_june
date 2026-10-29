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
    List<String>list = new ArrayList<>();
    public String smallestFromLeaf(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        Collections.sort(list);
        return list.get(0);
    }
    private void dfs(TreeNode root, StringBuilder sb){
        if(root == null){
            return;
        }
        sb.append((char)('a' + root.val));
        if(root.left == null && root.right == null){
            list.add(sb.reverse().toString());

            sb.reverse();
        }
        dfs(root.left, sb);
        dfs(root.right, sb);
        sb.deleteCharAt(sb.length() - 1);

    } 
}