class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())return false;
        int[] ans = new int[26];
        
        for(char c : s.toCharArray()){
            ans[c - 'a']++;
        }
        for(char c : t.toCharArray()){
            ans[c - 'a']--;
        }

        for(int i = 0; i < 26; i++){
            if(ans[i] != 0){
                return false;
            }
        }

        return true;
    }
}
