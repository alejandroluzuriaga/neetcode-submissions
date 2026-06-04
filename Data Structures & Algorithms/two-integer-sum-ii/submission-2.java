class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for(int left = 0; left < numbers.length; left++){
            for(int right = left+1; right < numbers.length; right++){
                if (numbers[left]+numbers[right] == target){
                    return new int[]{left+1, right+1};
                }
            }
        }
        return new int[1];
    }
}
