class Solution {
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        long sum = 0;
        long next = 1;
        for(int num : nums){
            if(num < next){
                continue;
            }
            if(num > next){
                long count = Math.min((long) k, num - next);
                sum += count * (2 * next + count - 1) / 2;
                k -= count;

                if(k == 0){
                    return sum;
                }
            }
            next = (long)num + 1;
        }
        sum += k * ( 2 * next + k - 1) / 2;
        return sum;
    }
}