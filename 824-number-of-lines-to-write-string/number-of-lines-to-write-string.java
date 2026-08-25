class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int lines = 1;
        int sum = 0;
        for(char ch : s.toCharArray()){
            int w = widths[ch - 'a'];
            if(sum + w > 100){
                lines++;
                sum = w;
            }
            else{
                sum += w;
            }
        }
        return new int[]{lines, sum};
    }
}