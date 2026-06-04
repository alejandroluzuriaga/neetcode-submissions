class Solution {
    public boolean isPalindrome(String s) {
        String a = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        for(int left = 0; left < (a.length()/2)+1; left++){
            if (a.length() % 2 == 0 && left == (a.length()/2))
                break;
            int right = ((a.length() - 1) - left);
            if (a.charAt(left) != a.charAt(right)){
                return false;
            }
        }
        return true;
    }
}
