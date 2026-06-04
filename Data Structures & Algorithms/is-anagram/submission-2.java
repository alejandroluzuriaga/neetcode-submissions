class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        TreeMap<Character, Integer> orderedSet1 = new TreeMap<>(); 
        TreeMap<Character, Integer> orderedSet2 = new TreeMap<>();
        for(int i = 0; i < s.length(); i++){
            Character a = s.charAt(i);
            Character b = t.charAt(i);

            if (orderedSet1.containsKey(a))
                orderedSet1.put(a, orderedSet1.get(a)+1);
            else
                orderedSet1.put(a, 1);

            if (orderedSet2.containsKey(b))
                orderedSet2.put(b, orderedSet2.get(b)+1);
            else
                orderedSet2.put(b, 1);
        }
        System.out.println(orderedSet1.values() + " - " + orderedSet2.values());
        return orderedSet1.equals(orderedSet2);

    }
}
