class Solution {
    public int countVowelSubstrings(String word) {
        int count = 0;
        int n = word.length();
        for(int i=0; i<n; i++){
            int distinct = 0;
            int[] freq = new int[5];
            for(int j=i; j<n; j++){
                char ch = word.charAt(j);
                int idx;
                if(ch == 'a'){
                    idx = 0;
                }
                else if(ch == 'e'){
                    idx = 1;
                }
                else if(ch == 'i'){
                    idx = 2;
                }
                else if(ch == 'o'){
                    idx = 3;
                }
                else if(ch == 'u'){
                    idx = 4;
                }
                else{
                    break;
                }

                if(freq[idx] == 0){
                    distinct++;
                }
                freq[idx]++;
                if(distinct == 5){
                    count++;
                }
            }
        }
        return count;
    }
}