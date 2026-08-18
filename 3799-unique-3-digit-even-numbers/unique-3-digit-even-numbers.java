class Solution {
    HashSet<Integer>set = new HashSet<>();
    public int totalNumbers(int[] digits) {
        int[] freq = new int[10];
        for(int d : digits){
            freq[d]++;
        }
        backTrack(0,0,freq);
        return set.size();

    }
    private void backTrack(int pos, int num, int[] freq){
        if(pos == 3){
            set.add(num);
            return;
        }
        for(int digit = 0; digit <= 9; digit++){
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