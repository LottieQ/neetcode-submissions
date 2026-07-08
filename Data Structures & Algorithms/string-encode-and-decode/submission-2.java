class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            sb.append(str.length());
            sb.append('#');
            sb.append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        int ptr = 0;
        List<String> ans = new ArrayList<>();

        while(ptr < str.length()){
            int idx = str.indexOf('#', ptr);
            int len = Integer.parseInt(str.substring(ptr, idx));
            ans.add(str.substring(idx + 1, idx + 1 + len));
            ptr = idx + 1 + len;
        }

        return ans;
    }
}
