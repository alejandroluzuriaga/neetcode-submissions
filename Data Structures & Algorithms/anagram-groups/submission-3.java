class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            String current = strs[i];
            char c[] = current.toCharArray();
            
            Arrays.sort(c);

            String aux = new String(c);

            System.out.println("Current: " + current + "-" + aux);
            if (!map.containsKey(aux)){
                map.put(aux, new LinkedList<>());
            }
            
            map.get(aux).add(strs[i]);
        }

        List<List<String>> result = new LinkedList<>();
        for (String elems : map.keySet()){
            result.add(map.get(elems));
        }
        return result;
    }
}
