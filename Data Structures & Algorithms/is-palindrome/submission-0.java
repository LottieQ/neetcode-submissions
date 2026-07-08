class Solution {
    public boolean isPalindrome(String s) {
        int right = s.length() - 1;
        int left = 0;

        while (left <= right){
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
