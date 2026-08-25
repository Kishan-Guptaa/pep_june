class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        for(int i=releaseTimes.length - 1; i>=1; i--){
            releaseTimes[i] = releaseTimes[i] - releaseTimes[i-1];
        }
        int maxTime = releaseTimes[0];
        char ch = keysPressed.charAt(0);
        for(int i=1; i < releaseTimes.length; i++){
            if(releaseTimes[i] > maxTime){
                maxTime = releaseTimes[i];
                ch = keysPressed.charAt(i);
            }
            else if(releaseTimes[i] == maxTime && keysPressed.charAt(i) > ch){
                maxTime = releaseTimes[i];
                ch = keysPressed.charAt(i);
            }
        }
        return ch;
    }
}