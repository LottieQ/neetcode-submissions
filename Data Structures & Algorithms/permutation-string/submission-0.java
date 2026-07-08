class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        
        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for(int i = 0; i < s1.length(); i++){
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }
        
        int match = 0;
        for(int i = 0; i < 26; i++){
            if(count1[i] == count2[i]){
                match++;
            }
        }

        int l = 0;
        for(int r = s1.length(); r < s2.length(); r++){
            if(match == 26){
                return true;
            }

            int idx = s2.charAt(r) - 'a';
            if(count2[idx] == count1[idx]){
                match--;
            }
            count2[idx]++;
            if(count2[idx] == count1[idx]){
                match++;
            }

            idx = s2.charAt(l) - 'a';
            if(count2[idx] == count1[idx]){
                match--;
            }
            count2[idx]--;
            if(count2[idx] == count1[idx]){
                match++;
            }
            l++;
        }
        return match == 26;


    }
}
