class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int[] ans = new int[nums.length - k + 1];
        for(int left = 0; left <= nums.length - k; left++){
            Map<Integer, Integer>map = new HashMap<>();
            for(int i=left; i<left+k; i++){
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
            ArrayList<Integer>list = new ArrayList<>(map.keySet());

            list.sort((a,b) -> {
                int fa = map.get(a);
                int fb = map.get(b);
                if(fa != fb){
                    return Integer.compare(fb, fa);
                }
                return Integer.compare(b, a);
            });
            int sum = 0;
            for(int j=0; j<Math.min(x, list.size()); j++){
                int num = list.get(j);
                sum += map.get(num) * num;
            }
            ans[left] = sum;

        }
        return ans;
    }
}