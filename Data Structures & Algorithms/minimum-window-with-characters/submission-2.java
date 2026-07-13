class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }
        int[] sCount = new int[128];
        int[] tCount = new int[128];
        Set<Character> check = new HashSet<>();
        String ans = "";
        int max = Integer.MAX_VALUE;
        int matches = 0;

        for(int i = 0; i < t.length(); i++){
            tCount[t.charAt(i) - 'A']++;
            check.add(t.charAt(i));
        }

        int l = 0;
        for(int r = 0; r < s.length(); r++){
            sCount[s.charAt(r) - 'A']++;
            if(sCount[s.charAt(r) - 'A'] == tCount[s.charAt(r) - 'A'] && check.contains(s.charAt(r))){
                matches++;
            }

            if(r - l + 1 > max){
                if(sCount[s.charAt(l) - 'A'] == tCount[s.charAt(l) - 'A'] && check.contains(s.charAt(l))){
                    matches--;
                }
                sCount[s.charAt(l) - 'A']--;
                l++;
            }

            if(matches == check.size()){
                while(sCount[s.charAt(l) - 'A'] != tCount[s.charAt(l) - 'A'] || !check.contains(s.charAt(l))){
                    sCount[s.charAt(l) - 'A']--;
                    l++;
                }
                if(r - l + 1 < max){
                    max = r - l + 1;
                    ans = s.substring(l, r+1);
                }
            }
        }
        return ans;
    }
}
