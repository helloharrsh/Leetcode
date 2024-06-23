class Solution {
    public int solve_memo(int [] arr, int n, int ind, int prev, int[][] dp){
        if(ind == n)
            return 0;
        if(dp[ind][prev+1] != -1)
            return dp[ind][prev+1];
        
        int notTake = 0 + solve_memo(arr,n,ind+1,prev,dp);
        int take = 0;
        if(prev == -1 || arr[ind] > arr[prev])
            take = 1 + solve_memo(arr,n,ind+1,ind,dp);
        
        dp[ind][prev+1] = Math.max(notTake, take);
        return dp[ind][prev+1];
    }
    
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n+1];
        for(int row[] :dp)
            Arrays.fill(row,-1);
        
        return solve_memo(nums,n,0,-1,dp);
    }
}