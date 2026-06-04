class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = 1;
        boolean found = false;
        while(i < nums.length-1 && !found){
            if (nums[i]+nums[j] == target)
                break;

            if (j == nums.length-1){
                i++;
                j = i+1;
            }else{
                j++;
            }
        }

        return new int[]{i, j};
    }
}
