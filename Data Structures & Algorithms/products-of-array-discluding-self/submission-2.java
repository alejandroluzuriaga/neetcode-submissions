class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zeros = 0;
        for(int i = 0; i < nums.length; i++){
            if (nums[i] != 0)
                product *= nums[i];
            else
                zeros++;
        }
        int result[] = new int[nums.length];

        if (zeros > 1)
            return result;

        for(int i = 0; i < nums.length; i++){
            if (zeros > 0)
                result[i] = (nums[i] == 0) ? product : 0;
            else
                result[i] = product/nums[i];
        }
        return result;
    }
}  
