class Solution {
    public int captureForts(int[] forts) {
        int ans  = 0;
        int prev = 0;
        int count = 0;
        for(int i=0; i<forts.length; i++){
            if(forts[i] == 0){
                count++;
            }
            else{
                if(prev != 0 && prev != forts[i]){
                    ans = Math.max(ans,count);
                }
                 prev = forts[i];
                count = 0;
            }
           
        }
        return ans;
    }
}