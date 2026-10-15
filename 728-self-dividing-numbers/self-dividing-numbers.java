class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer>ans = new ArrayList<>();
        for(int n = left; n <= right; n++){
            int temp = n;
            boolean selfDividing = true;
            while(temp > 0){
                int digit = temp % 10;
                if(digit == 0 || n % digit != 0){
                    selfDividing = false;
                    break;
                }
                temp /= 10;
            }
            if(selfDividing){
                ans.add(n);
            }
        }
        return ans;
    }
}