class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            int len = str.length();
            sb.append(len);
            sb.append('#');
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int left = 0;
        while(left < str.length() - 1){
            int right = str.indexOf('#', left);
            int len = Integer.parseInt(str.substring(left, right));
            res.add(str.substring(right + 1, right + 1 + len));
            left = right + len + 1;
        }
        return res;
    }
}
