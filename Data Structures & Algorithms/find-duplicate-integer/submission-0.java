class Solution {
    public int findDuplicate(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if (m.containsKey(nums[i]))
                return nums[i];
            m.put(nums[i], nums[i]);
        }
        return 0;
    }
}
