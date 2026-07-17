class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {

        List<Long> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while (!q.isEmpty()) {

            int size = q.size();
            long sum = 0;

            for (int i = 0; i < size; i++) {

                TreeNode node = q.poll();
                sum += node.val;

                if (node.left != null) {
                    q.offer(node.left);
                }

                if (node.right != null) {
                    q.offer(node.right);
                }
            }

            ans.add(sum);
        }

        if (ans.size() < k) {
            return -1;
        }

        Collections.sort(ans); 

        return ans.get(ans.size() - k);
    }
}