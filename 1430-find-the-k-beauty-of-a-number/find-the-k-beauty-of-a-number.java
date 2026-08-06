class Solution {
    public int divisorSubstrings(int num, int k) {
        
        String str = String.valueOf(num); 
        int left = 0;
        int right = 0;
        int count = 0;
        while(right < str.length()){
            if(right - left + 1 < k){
                right++;
            }
            else if(right - left + 1 == k){
                String s = str.substring(left,right+1);
                int n = Integer.parseInt(s);
                if(n != 0 && num % n == 0){
                    count++;
                }
                left++;
                right++;
            }
        }
        return count;
    }
}