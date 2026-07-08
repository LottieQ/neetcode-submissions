class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(int j = 0; j < t.length(); j++){
            char c = t.charAt(j);
            if(!map.containsKey(c)) return false;
            if(map.get(c) == 1){
                map.remove(c);
            }else{
                map.put(c, map.get(c) - 1);
            }
        }
        return true;
    }
}
