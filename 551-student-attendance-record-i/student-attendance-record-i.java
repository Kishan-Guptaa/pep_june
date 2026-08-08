class Solution {
    public boolean checkRecord(String s) {
        int late = 0;
        int absent = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == 'L'){
                late++;
            }
            else if(s.charAt(i) == 'A'){
                absent++;
                late = 0;
            }
            else{
                late = 0;
            }

            if(late >=3 || absent >=2){
                return false;
            }
        }
        
        return true;
    }
}