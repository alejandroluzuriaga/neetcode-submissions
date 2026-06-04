class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        //meter en set ordenado
        //recorrer set contando elementos seguidos
        TreeSet<Integer> set = new TreeSet<>();
        for(Integer e : nums)
            set.add(e);

        List<Integer> array = new ArrayList<>(set);
        int max = 1;
        int maxLocal = 1;
        int before = array.get(0);

        for(int i = 1; i < array.size(); i++){
            int current = array.get(i);
            if (current == before+1){
                maxLocal++;
            }else{
                maxLocal = 1;
            }
            if( maxLocal > max)
                max = maxLocal;
            before = current;
        }
        return max;
    }
}
