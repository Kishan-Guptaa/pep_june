class Solution {
    public int minSwaps(int[] nums) {
       
        ArrayList<int[]>ans = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            int val = nums[i];
            int sum = 0;
            while(val > 0){
                int digit = val % 10;
                sum += digit;
                val /= 10;
            }
            ans.add(new int[]{sum, nums[i]});
        }
        Collections.sort(ans, (a, b) -> {
            if(a[0] != b[0]){
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        HashMap<Integer, Integer>map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(ans.get(i)[1], i);
        }

        int count = 0;
        boolean[] vis = new boolean[nums.length];
        for(int i=0; i<nums.length; i++){
            if(vis[i] || map.get(nums[i]) == i){
                continue;
            }
            int j = i;
            int cycle = 0;
            while(!vis[j]){
                vis[j] = true;
                j = map.get(nums[j]);
                cycle++;
            }
            count += cycle - 1;
        }
        return count;

    }
}