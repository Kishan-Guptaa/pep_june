class Solution {
    public String modifyString(String s) {
        char[] arr = s.toCharArray();
        for(int i=0; i<arr.length; i++){
            if(arr[i] == '?'){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    if(i > 0 && arr[i-1] == ch){
                        continue;
                    }

                    if(i < arr.length-1 && arr[i+1] == ch){
                        continue;
                    }

                    arr[i] = ch;
                    break;
                }
            }
        }
        return new String(arr);
    }
}