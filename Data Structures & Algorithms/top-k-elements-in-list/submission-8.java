class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //meter en mapa ordenado numero -> apariciones
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            if (!map.containsKey(nums[i]))
                map.put(nums[i], 1);
            else
                map.put(nums[i], map.get(nums[i])+1);
        }
        // 1->1
        // 2->2
        // 3->3
        int maxValues[] = new int[k];
        TreeSet<Map.Entry<Integer, Integer>> set = new TreeSet<>((e1, e2) -> {
            int res = e1.getValue().compareTo(e2.getValue());
            if (res == 0) {
                return e1.getKey().compareTo(e2.getKey());
            }
            return res;
        });
        for (Map.Entry<Integer, Integer> value: map.entrySet()){
            set.add(value);
        }

        for (int i = 0; i < k; i++){
            maxValues[i] = set.pollLast().getKey();
        }

        return maxValues;
    }
}
