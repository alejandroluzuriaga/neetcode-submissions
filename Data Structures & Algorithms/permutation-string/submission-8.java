class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> freqs = new TreeMap<>();
        Map<Character, Integer> freqsWindow = new TreeMap<>();
        for(int i = 0; i < s1.length(); i++)
            freqs.put(s1.charAt(i), freqs.get(s1.charAt(i)) != null ? freqs.get(s1.charAt(i))+1 : 1);

        int l = 0;
        int r = 0;
        int valuesToFind = freqs.values().size();
        while(l < s2.length() && r < s2.length()){
            int windowLength = (r-l)+1;
            if (!freqs.containsKey(s2.charAt(r))){
                freqsWindow.clear();
                l++;
                r++;
                continue;
            }else{
                freqsWindow.put(s2.charAt(r), freqsWindow.get(s2.charAt(r)) != null ? freqsWindow.get(s2.charAt(r))+1 : 1);
                if (windowLength == s1.length()){
                    if (freqs.equals(freqsWindow))
                        return true;
                    freqsWindow.clear();
                    l++;
                    r = l;
                }
                else
                    r++;
            }
        }
        return false;
    }
}
