public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++; // first k length window
        }

        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] == s2Count[i]) { // count matches from start
                matches++;
            }
        }

        int l = 0;
        for (int r = s1.length(); r < s2.length(); r++) { // fixed window size (s1 length)
            if (matches == 26) {
                return true;
            }

            int index = s2.charAt(r) - 'a'; // right side of window
            s2Count[index]++; //expand window from right
            if (s1Count[index] == s2Count[index]) { // same number of char
                matches++;
            } else if (s1Count[index] + 1 == s2Count[index]) { // 1 extra in s2
                matches--;
            }

            index = s2.charAt(l) - 'a'; // left side of window
            s2Count[index]--; // shrink window from left
            if (s1Count[index] == s2Count[index]) {  // same number of char
                matches++;
            } else if (s1Count[index] - 1 == s2Count[index]) { // 1 left in s2
                matches--;
            }
            l++;
        }
        return matches == 26;
    }
}