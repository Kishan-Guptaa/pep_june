class Solution {
    public int magicalString(int n) {

        if (n <= 0) {
            return 0;
        }

        if (n <= 3) {
            return 1;
        }

        StringBuilder s = new StringBuilder("122");

        int count1 = 1;   
        int idx = 2;      
        char num = '1';   

        while (s.length() < n) {
            int times = s.charAt(idx) - '0';
             for (int i = 0; i < times && s.length() < n; i++) {
                s.append(num);

                if (num == '1') {
                    count1++;
                }
            }
            num = (num == '1') ? '2' : '1';

            idx++;
        }

        return count1;
    }
}
