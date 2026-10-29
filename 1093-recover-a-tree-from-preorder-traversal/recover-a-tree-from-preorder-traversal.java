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
    public TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode>st = new Stack<>();
        int n = traversal.length();
        int i = 0;
        while(i < n){
            int depth = 0;
            while(i < n && traversal.charAt(i) == '-'){
                depth++;
                i++;
            }
            int num = 0;
            while(i < n && Character.isDigit(traversal.charAt(i))){
                num = num * 10 + (traversal.charAt(i) - '0');
                i++;
            }

            TreeNode node = new TreeNode(num);

            while(st.size() > depth){
                st.pop();
            }
            if(!st.isEmpty()){
                TreeNode parent = st.peek();
                if(parent.left == null){
                    parent.left = node;
                }
                else{
                    parent.right = node;
                }
            }
            st.push(node);
        }
        while(st.size() > 1){
            st.pop();
        }
        return st.peek();
    }
}