class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        List<List<Integer>>ans = new ArrayList<>();
        Arrays.sort(nums);
        int prev = lower - 1;
        for(int num : nums){
            if(num < lower){
                continue;
            }
            if(num > upper){
                break;
            }

            if(num > prev + 1){
                ans.add(Arrays.asList(prev+1 , num-1));
            }
            prev = num;
        }

        if(prev < upper){
            ans.add(Arrays.asList(prev+1, upper));
        }
        return ans;
    }
}