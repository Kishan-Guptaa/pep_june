class Solution {
    public char kthCharacter(int k) {
       if( k == 1){
        return 'a';
       } 
       int len = 1;
       while(len * 2 < k){
        len *= 2;
       }

       if(k <= len){
        return kthCharacter(k);
       }
       char ch = kthCharacter(k - len);

       return (char)(ch + 1);
    }
}