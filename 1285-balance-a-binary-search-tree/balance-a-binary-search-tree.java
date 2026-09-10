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
    private void inorder(TreeNode root, List<Integer>list){
        if(root == null){
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
    private TreeNode TreeBuild(List<Integer>list, int left, int right){
        if(left > right){
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = TreeBuild(list, left, mid - 1);
        root.right = TreeBuild(list, mid + 1, right);
        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer>list = new ArrayList<>();
        inorder(root, list);

        return TreeBuild(list, 0, list.size() - 1);
    }
}