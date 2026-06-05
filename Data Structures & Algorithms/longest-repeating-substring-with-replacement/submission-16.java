class Solution {
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0)
            return 0;
        //most frequent
        // length of window - most frequent in window <= k
        int l = 0;
        int r = 0;
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (r < s.length()){
            map.put(s.charAt(r), map.get(s.charAt(r)) != null ? map.get(s.charAt(r))+1 : 1); //update frequencies;
            int windowLength = (r-l)+1;

            int maxFrequency = Collections.max(map.values());
            if (windowLength - maxFrequency <= k){ // valid window
                System.out.println("Window length: " + windowLength + " - left: " + l + " - right: " + r + " - A: "+ map.get('A')+ " - B: "+map.get('B'));
                res = Math.max(res, windowLength);
                r++;
            }else{
                map.put(s.charAt(l), map.get(s.charAt(l)) != null ? map.get(s.charAt(l))-1 : 1);
                System.out.println("Window length: " + windowLength + " - left: " + l + " - right: " + r + " - A: "+ map.get('A')+ " - B: "+map.get('B'));
                l++;
                r++;
            }
        }
        return res;
    }
}
