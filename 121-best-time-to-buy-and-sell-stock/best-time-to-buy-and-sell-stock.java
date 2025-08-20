class Solution {
    public int maxProfit(int[] prices) {
       int maxpro=Integer.MIN_VALUE;
       int min=Integer.MAX_VALUE;
       int n=prices.length;
       for(int i=0;i<n;i++){
           min=Math.min(prices[i],min);
           maxpro=Math.max(maxpro,prices[i]-min);
       }
     return maxpro;
    } 
}