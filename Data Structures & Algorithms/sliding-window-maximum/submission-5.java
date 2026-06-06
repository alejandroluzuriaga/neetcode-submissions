class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k > nums.length) return new int[0];
        int res[] = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        int l = 0, windowPosition = 0;
        for(int r = 0; r < nums.length; r++){
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[r])
                deque.removeLast();
            
            deque.addLast(r);

            if (l > deque.getFirst())
                deque.removeFirst();

            if ((r + 1) >= k){
                res[windowPosition] = nums[deque.getFirst()];
                l++;
                windowPosition++;
            }
        }
        return res;
    }
}
