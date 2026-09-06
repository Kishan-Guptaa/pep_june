/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode>map = new HashMap<>();
        Queue<TreeNode>q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.left != null){
                q.add(node.left);
                map.put(node.left, node);
            }
            if(node.right != null){
                q.add(node.right);
                map.put(node.right, node);
            }
        }
        List<Integer>result = new ArrayList<>();
        Set<TreeNode>set = new HashSet<>();
        set.add(target);
        q.add(target);
        int cd = 0;
        while(!q.isEmpty()){
            if(cd == k){
                while(!q.isEmpty()){
                    result.add(q.poll().val);
                }
            }
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                if(node.left != null  && !set.contains(node.left)){
                    q.add(node.left);
                    set.add(node.left);
                }
                if(node.right != null &&  !set.contains(node.right)){
                    q.add(node.right);
                    set.add(node.right);
                }

                if(map.containsKey(node) && !set.contains(map.get(node))){
                    q.add(map.get(node));
                    set.add(map.get(node));
                }
            }
            cd++;
        }
        return result;
    }
}