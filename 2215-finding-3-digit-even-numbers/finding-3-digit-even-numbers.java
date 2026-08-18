class Solution {
    ArrayList<Integer>ans = new ArrayList<>();
    public int[] findEvenNumbers(int[] digits) {
        int[] freq = new int[10];
        for(int d : digits){
            freq[d]++;
        }
        backTrack(0,0,freq);
        int[] res = new int[ans.size()];
        for(int i=0; i<ans.size(); i++){
            res[i] = ans.get(i);
        }
        return res;

    }
    private void backTrack(int pos, int num, int[]freq){
        if(pos == 3){
            ans.add(num);
            return;
        }

        for(int digit = 0; digit<=9; digit++){
            if(pos == 0 && digit == 0){
                continue;
            }
            if(pos == 2 && digit % 2 != 0){
                continue;
            }

            if(freq[digit] == 0){
                continue;
            }
            freq[digit]--;
            backTrack(pos + 1, num * 10 + digit, freq);
            freq[digit]++;
        }
    }
}