import java.math.BigInteger;
class Solution {
    public String addBinary(String a, String b) {
        BigInteger num1 = new BigInteger(a, 2);
        BigInteger num2 = new BigInteger(b, 2);
        BigInteger sum = num1.add(num2);
        return sum.toString(2);
    }
}
// class Solution {
//     public String addBinary(String a, String b) {
//         StringBuilder sb = new StringBuilder();
//         int i = a.length() - 1;
//         int j = b.length() - 1;
//         int carry = 0;
//         while(i >= 0 || j >= 0 || carry > 0){
//             int sum = carry;
//             if( i >= 0){
//                 sum += a.charAt(i) - '0';
//                 i--;
//             }
//             if( j >= 0 ){
//                 sum += b.charAt(j) - '0';
//                 j--;
//             }
//             sb.append(sum % 2);
//             carry = sum / 2;
//         }
//         return sb.reverse().toString();
//     }
// }