class Solution {
    public String largestTimeFromDigits(int[] arr) {
        String ans = "";
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                for(int k=0; k<4; k++){
                    for(int l=0; l<4; l++){
                        if(i == j || i == k || i == l || j == k || j == l || k == l){
                            continue;
                        }
                        int hours = arr[i] * 10 + arr[j];
                        int minutes = arr[k] * 10 + arr[l];
                        if(hours < 24 && minutes < 60){
                            String time = String.format("%02d:%02d", hours, minutes);
                            if(time.compareTo(ans) > 0){
                                ans = time;
                            }
                        }
                        
                    }
                }
            }
        }
        return ans == "" ? "" : ans;
    }
}