class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        for(int left = 0; left <= n-k; left++){
            HashMap<Integer, Integer>map = new HashMap<>();
            for(int i=left; i<left+k; i++){
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
            List<int[]>ls= new ArrayList<>();
            for(Map.Entry<Integer, Integer>entry : map.entrySet()){
                int value = entry.getKey();
                int freq = entry.getValue();
                ls.add(new int[]{value, freq});
            }
            ls.sort((a,b) ->{
                if(a[1] != b[1]){
                    return Integer.compare(b[1], a[1]);
                }
                return Integer.compare(b[0],a[0]);
            });

            int sum = 0;
            for(int i=0; i<Math.min(x, ls.size()); i++){
                int value = ls.get(i)[0];
                int freq = ls.get(i)[1];

                sum += value * freq;
            }
            ans[left] = sum;
        }
        return ans;
    }
}