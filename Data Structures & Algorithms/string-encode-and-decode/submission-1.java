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
        List<String> ans = new ArrayList<>();
        int i = 0;

        while(i < str.length()){
            int j = str.indexOf('#', i);
            int len = Integer.parseInt(str.substring(i , j));
            i = j + 1 + len;
            ans.add(str.substring(j + 1, i));
        }

        return ans;
    }
}
