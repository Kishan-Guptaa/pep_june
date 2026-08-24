class Solution {
    public String reverseByType(String s) {
        List<Character>list1 = new ArrayList<>();
        List<Character>list2 = new ArrayList<>();

        for(char ch : s.toCharArray()){
            if(ch >= 'a' && ch <= 'z'){
                list1.add(ch);
            }
            else{
                list2.add(ch);
            }
        }
        StringBuilder sb =  new StringBuilder();
        int size1 = list1.size() - 1;
        int size2 = list2.size() - 1;
        for(char ch : s.toCharArray()){
            if(ch >= 'a' && ch <= 'z'){
                sb.append(list1.get(size1--));
            }
            else{
                sb.append(list2.get(size2--));
            }
        }
        return sb.toString();

    }
}