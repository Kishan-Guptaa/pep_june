class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
      List<Integer>res = new ArrayList<>();
      int i = num.length - 1;
      int carry = k;
      while(i >= 0 || carry > 0){
        if(i >= 0){
            carry += num[i];
            i--;
        }
        res.add(carry % 10);
        carry /= 10;
      }
    Collections.reverse(res);
    return res;
    }
}