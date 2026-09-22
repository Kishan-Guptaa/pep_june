class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] newArr = new int[n*2];
        for(int i=0; i<2*n; i++){
            newArr[i] = code[i%n];
        }
        int start;
        int end;
        if(k > 0){
            start = 1;
            end = k;
        }
        else{
            k = -k;
            start = n - k;
            end = n - 1;

        }
        int windowSum = 0;
        for(int i=start; i<=end; i++){
            windowSum += newArr[i];
        }
        int[] res=  new int[n];
        for(int i=0; i<n; i++){
            res[i] = windowSum;
            windowSum -= newArr[start];
            start++;
            end++;
            windowSum += newArr[end];
        }
        return res;
    }
}