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
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode, TreeNode>map = new HashMap<>();
        TreeNode target = bfs(root, map, start);
        int maxi = findMaxDistance(map, target);
        return maxi;
    }
    private TreeNode bfs(TreeNode root, HashMap<TreeNode, TreeNode>map, int start){
        Queue<TreeNode>q = new LinkedList<>();
        q.add(root);
        TreeNode res = new TreeNode(-1);

        while(!q.isEmpty()){
            TreeNode node = q.remove();
            if(node.val == start){
                res = node;
            }
            if(node.left != null){
                map.put(node.left, node);
                q.add(node.left);
            }
            if(node.right != null){
                map.put(node.right, node);
                q.add(node.right);
            }
        }
        return res;
    }
    private int findMaxDistance(HashMap<TreeNode, TreeNode>map, TreeNode target){
        Queue<TreeNode>q = new LinkedList<>();
        q.add(target);
        HashMap<TreeNode, Integer>visited = new HashMap<>();
        visited.put(target, 1);
        int maxi = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int fl = 0;
            for(int i=0; i<size; i++){
                TreeNode node = q.remove();
                if(node.left != null && visited.get(node.left) == null){
                    fl = 1;
                    visited.put(node.left, 1);
                    q.add(node.left);
                }
                if(node.right != null && visited.get(node.right) == null){
                    fl = 1;
                    visited.put(node.right, 1);
                    q.add(node.right);
                }
                if(map.get(node) != null && visited.get(map.get(node)) == null){
                    fl = 1;
                    visited.put(map.get(node), 1);
                    q.add(map.get(node));
                }
            }
            if(fl == 1){
                maxi++;
            }
        }
        return maxi;
    }
}