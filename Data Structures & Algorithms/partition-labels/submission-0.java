class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();

        // key: char in s; value: farthest index;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), i);
        }

        int farthest = -1;
        int length = 0;
        for(int j = 0; j < s.length(); j++){
            length++;
            char c = s.charAt(j);
            farthest = Math.max(farthest, map.get(c));
            if(j == farthest){
                ans.add(length);
                length = 0;
            }
        }

        return ans;
    }
}
