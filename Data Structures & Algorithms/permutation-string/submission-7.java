class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //meter s1 en treeset
        // con ventana
            // si r avanza, mete elemento en otro treeset
            // si length de ventana igual a s1.length, comprobar treesets
                // si no iguales -> treeset.clear y l++ y r=l;
                // si iguales -> devolver true
        List<Character> s1List = new ArrayList<>();
        for(int i = 0; i < s1.length(); i++)
            s1List.add(s1.charAt(i));
        Collections.sort(s1List);
        List<Character> auxList = new ArrayList<>();
        int l = 0;
        int r = 0;
        while(l < s2.length() && r < s2.length()){
            int windowLength = (r-l)+1;
            if (!s1List.contains(s2.charAt(r))){
                auxList.clear();
                l++;
                r++;
                continue;
            }

            auxList.add(s2.charAt(r));

            if (windowLength == s1.length()){
                Collections.sort(auxList);
                if (s1List.equals(auxList))
                    return true;
                else{
                    auxList.clear();
                    l++;
                    r = l-1;
                }
            }
            r++;
        }
        return false;
    }
}
