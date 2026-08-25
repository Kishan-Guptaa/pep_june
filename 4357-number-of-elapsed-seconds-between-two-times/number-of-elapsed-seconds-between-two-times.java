class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {
        int start = convertToSecond(startTime);
        int end = convertToSecond(endTime);
        return (end - start);
    }
    private int convertToSecond(String time){
        int hours = Integer.parseInt(time.substring(0,2));
        int minutes = Integer.parseInt(time.substring(3,5));
        int seconds = Integer.parseInt(time.substring(6,8));
        int totalSeconds = hours * 3600 + minutes * 60 + seconds;
        return totalSeconds;
    }
}