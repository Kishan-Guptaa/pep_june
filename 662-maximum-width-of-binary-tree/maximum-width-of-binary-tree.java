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
    static class Pair<K,V>{
        private K key;
        private V value;
        public Pair(K key, V value){
            this.key = key;
            this.value = value;
        }
        public K getKey(){
            return key;
        }
        public V getValue(){
            return value;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        int ans = 0;
        Queue<Pair<TreeNode, Integer>>q = new LinkedList<>();
        q.add(new Pair<>(root, 0));
        while(!q.isEmpty()){
            int size = q.size();
            int min = q.peek().getValue();
            int first = 0;
            int last = 0;
            for(int i=0; i<size; i++){
                int currid = q.peek().getValue() - min;
                TreeNode node = q.peek().getKey();
                q.poll();
                if(i == 0){
                    first = currid;
                }
                if(i == size - 1){
                    last = currid;
                }
                if(node.left != null){
                    q.add(new Pair<>(node.left, currid * 2 + 1));
                }
                if(node.right != null){
                    q.add(new Pair<>(node.right, currid * 2 + 2));
                }
            }
            ans = Math.max(ans, last - first + 1);
        }
        return ans;
    }
}