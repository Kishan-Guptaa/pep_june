class Solution {
    public int reverse(int x) {
        boolean neg = x < 0;
        StringBuilder sb = new StringBuilder();
        sb.append(Math.abs((long) x));
        sb.reverse();
        long ans = Long.parseLong(sb.toString());
        if(neg){
            ans = -ans;
        }
        if (ans < Integer.MIN_VALUE || ans > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) ans;
    }
}