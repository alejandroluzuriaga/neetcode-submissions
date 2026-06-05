class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int r = prices.length-1;
        int left = prices[0];
        int right = prices[prices.length-1];

        int maxProfit = 0;
        for(int l = 0; l < prices.length; l++){
            maxProfit = Math.max(maxProfit, Math.max(0, prices[r]-prices[l]));
            while(l < r){
                r--;
                maxProfit = Math.max(maxProfit, Math.max(0, prices[r]-prices[l]));
            }
            r = prices.length-1;
        }
        return maxProfit;
    }
}
