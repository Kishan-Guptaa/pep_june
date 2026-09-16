class Solution {
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length-1;
        int i = 0;
        Set<Integer>st = new HashSet<>();
        while(i < n){
            int avg = nums[i] + nums[n];
            System.out.print(avg);
            st.add(avg);
            i++;
            n--;
        }
        return st.size();
    }
}