class Solution {
    public int solve_memo(int [] arr, int ind, int t, int[][] dp){
        if(ind == 0){
            if(t % arr[0] == 0)
                return 1;
            else
                return 0;
        }
        if(dp[ind][t] != -1)
            return dp[ind][t];
        
        int notTake = solve_memo(arr,ind -1, t,dp);
        
        int take = 0;
        if(arr[ind] <= t)
            take = solve_memo(arr,ind , t-arr[ind],dp);
        
        return dp[ind][t] = notTake + take;
    }
    
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        return solve_memo(coins,n-1,amount,dp);
    }
}