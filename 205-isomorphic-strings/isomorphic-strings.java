class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character, Character>smap = new HashMap<>();
        HashMap<Character, Character>tmap = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char sch = s.charAt(i);
            char tch = t.charAt(i);
            if(smap.containsKey(sch)){
                if(smap.get(sch) != tch){
                    return false;
                }
            }
            else{
                smap.put(sch, tch);
            }

            if(tmap.containsKey(tch)){
                if(tmap.get(tch) != sch){
                    return false;
                }
            }
            else{
                tmap.put(tch, sch);
            }
        }
        return true;
    }
}