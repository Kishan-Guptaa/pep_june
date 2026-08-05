class Solution {
    public int maxRepOpt1(String text) {
        int ans = 0;
        for(char target = 'a'; target <= 'z'; target++){
            int total = 0;
            for(char ch : text.toCharArray()){
                if(ch == target){
                    total++;
                }
            }

            int left = 0;
            int count = 0;
            int different = 0;
            for(int right = 0; right < text.length(); right++){
                if(text.charAt(right) == target){
                    count++;
                }
                else{
                    different++;
                }

                while(different > 1){
                    if(text.charAt(left) == target){
                        count--;
                    }
                    else{
                        different--;
                    }
                    left++;
                }

                int windowLength = right - left + 1;
                ans = Math.max(ans, Math.min(windowLength, total));
            }
        }
        return ans;
    }
}