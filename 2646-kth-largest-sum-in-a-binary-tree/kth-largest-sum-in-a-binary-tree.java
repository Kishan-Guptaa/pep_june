class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {

        List<Long> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {

            int size = q.size();
            long sum = 0;

            for (int i = 0; i < size; i++) {

                TreeNode node = q.poll();
                sum += node.val;

                if (node.left != null) {
                    q.add(node.left);
                }

                if (node.right != null) {
                    q.add(node.right);
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