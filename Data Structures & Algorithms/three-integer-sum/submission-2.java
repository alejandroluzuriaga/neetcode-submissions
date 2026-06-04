class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int count = 0;
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                for(int k = j+1; k < nums.length; k++){
                    if (nums[i]+nums[j]+nums[k] == 0)
                        if (i != j && i != k && j != k){
                            if (i < j && j < k){
                                List<Integer> triplet = new ArrayList<>();
                                triplet.add(nums[i]);
                                triplet.add(nums[j]);
                                triplet.add(nums[k]);
                                res.add(triplet);
                            }
                        }
                }
            }
        }
        return new ArrayList<>(res);
    }
}
