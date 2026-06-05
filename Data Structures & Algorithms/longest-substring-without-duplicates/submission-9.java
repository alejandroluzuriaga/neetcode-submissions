class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0, l = 0, r = 1;
        List<Character> word = new LinkedList<>();
        if (s == null || s.length() == 0)
            return 0;
        if (s.length() == 1)
            return 1;

        word.add(s.charAt(0));
        while(l<r && l < s.length() && r < s.length()){
            if (r < s.length()){
                System.out.println(max + " - " + word.size()+ " - "+ word + "-"+s.charAt(r)+ " - "+l+" - "+r);  
                max = Math.max(max, word.size());
                if (s.charAt(l) == s.charAt(r)){
                    l++;
                    r++;
                    continue;
                }
                if (!word.contains(s.charAt(r))){
                    word.add(s.charAt(r));
                    r++;
                }
                else{
                    l++;
                    word.clear();
                    word.add(s.charAt(l));
                    r++;
                }
                max = Math.max(max, word.size());
            }
        }
        return max;
    }
}
