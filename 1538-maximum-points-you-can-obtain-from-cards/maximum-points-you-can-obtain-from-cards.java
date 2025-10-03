class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int left=0;
        int maximum=0;
        int n=cardPoints.length;
       for(int i=0;i<k;i++){
          left=left+cardPoints[i];
          maximum=Math.max(maximum,left);
       }
       int right=n-1;
       int rightsum=0;
       for(int i=k-1;i>=0;i--){
          left=left-cardPoints[i];
          rightsum=rightsum+cardPoints[right];
          right--;
          maximum=Math.max(maximum,left+rightsum);
       }
       return maximum;
    }
}