class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(int i = 0 ; i < strs.length; i++){
            String str = strs[i];
            int[] count = new int[26];
            for(char c : str.toCharArray()){
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            map.computeIfAbsent(key, (k -> new ArrayList<>())).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
