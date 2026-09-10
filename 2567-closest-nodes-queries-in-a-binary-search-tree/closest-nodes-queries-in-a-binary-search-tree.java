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
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer>list = new ArrayList<>();
        inorder(root,list);
        List<List<Integer>>ans = new ArrayList<>();
        for(int query : queries){
            int floor = -1;
            int ceil = -1;

            int left = 0;
            int right = list.size() - 1;

            while(left <= right){
                int mid = (left + right) / 2;
                if(list.get(mid) == query){
                    floor = list.get(mid);
                    ceil = list.get(mid);
                    break;
                }
                else if(list.get(mid) < query){
                    floor = list.get(mid);
                    left = mid + 1;
                }
                else{
                    ceil = list.get(mid);
                    right = mid - 1;
                }
            }
            ans.add(Arrays.asList(floor, ceil));
        }
        return ans;
    }
}