class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer>ans = new ArrayList<>();
        while(label >= 1){
            ans.add(label);
            int level = 0;
            int temp = label;
            while(temp > 1){
                temp /= 2;
                level++;
            }
            int start = 1 << level;
            int end = (1 << (level + 1)) - 1;

            label = (start + end - label) / 2;
        }
        Collections.reverse(ans);
        return ans;
    }
}