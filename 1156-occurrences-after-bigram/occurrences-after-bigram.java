class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        String[] str = text.split(" ");
        ArrayList<String>list = new ArrayList<>();
        for(int i=0; i + 2<str.length; i++){
            if(str[i].equals(first) && str[i+1].equals(second)){
                list.add(str[i+2]);
            }
        }
        String[] array = list.toArray(new String[0]);
        return array;
    }
}