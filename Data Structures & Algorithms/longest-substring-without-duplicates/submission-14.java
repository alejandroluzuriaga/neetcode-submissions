class Solution {
    public int lengthOfLongestSubstring(String s) {
        // añadir letra
        // mirar si ya existe
            // sumar 1 y avanzar derecha
            // restar uno y avanzar izquierda
        int stringLength = s.length();
        if (stringLength == 0 || stringLength == 1)
            return stringLength;

        Map<Character, Integer> window = new HashMap<>();
        int max = 0;
        int l = 0;
        int r = 0;
        while (r < stringLength){
            while(window.containsKey(s.charAt(r))){
                window.remove(s.charAt(l));
                l++;
            }
            window.put(s.charAt(r), 1);
            max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
    }
}
