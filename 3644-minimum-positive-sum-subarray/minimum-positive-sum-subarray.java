class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int sum = Integer.MAX_VALUE;

        for(int i = 0 ; i< n ; i++){
            int curr = 0;

            for(int j = i ; j < n && j - i + 1 <=r ; j++){
                curr+= nums.get(j);
                int size = j - i + 1;

                if(size >= l && curr > 0){
                    sum = Math.min(curr,sum);
                }
            }
        }

        return sum == Integer.MAX_VALUE ? -1 : sum;
    }
}