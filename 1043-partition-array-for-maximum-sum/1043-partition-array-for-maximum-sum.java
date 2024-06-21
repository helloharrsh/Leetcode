class Solution {
    public int solve_memo(int ind, int[] nums, int k, int[]dp,int n){
        if(ind ==n) return 0;
        if(dp[ind] != -1) return dp[ind];
        int len = 0;
        int maxi = Integer.MIN_VALUE;
        int maxAns = Integer.MIN_VALUE;
        
        for(int j = ind; j< Math.min(ind+k, n); j++){
            len ++; 
            maxi = Math.max(maxi,nums[j]);
            int sum = len * maxi + solve_memo(j+1,nums,k,dp,n);
            maxAns = Math.max(sum,maxAns);
        }
        return dp[ind] = maxAns;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int [] dp = new int[n];
        Arrays.fill(dp,-1);
        return solve_memo(0,arr,k,dp,n);
    }
}