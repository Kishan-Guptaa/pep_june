class Solution {
    public int numTimesAllBlue(int[] flips) {
        int count = 0;
        int maxFlip = 0;
        for(int i=0; i<flips.length; i++){
            maxFlip = Math.max(maxFlip, flips[i]);
            if(maxFlip == i+1){
                count++;
            }
        }
        return count;
    }
}