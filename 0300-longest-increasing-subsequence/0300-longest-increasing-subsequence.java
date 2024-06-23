class Solution {
    
    /*
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
    
    public int solve_tabu(int[] arr, int n){
        int dp[][] = new int[n+1][n+1];
        for(int ind = n-1; ind >= 0; ind--){
            for(int prev = ind-1; prev >= -1; prev --){
                int notTake = 0 + dp[ind+1][prev+1];
                int take = 0;
                if(prev == -1 || arr[ind] > arr[prev])
                    take = 1 + dp[ind+1][ind+1];
                dp[ind][prev+1] = Math.max(notTake, take);
            }
        }
        return dp[0][0];
    }
    
    */
    
    public int solve_tabu_algo(int [] arr, int n){
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        
        for(int i = 0; i<= n-1; i++){
            for(int prev = 0; prev <= i-1; prev ++){
                if(arr[prev] < arr[i])
                    dp[i] = Math.max(dp[i], 1 + dp[prev]);
            }
        }
        
        int ans = -1;
        for(int i =0; i <= n-1; i++)
            ans = Math.max(ans, dp[i]);
        
        return ans;
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        /*
        int dp[][] = new int[n][n+1];
        for(int row[] :dp)
            Arrays.fill(row,-1);
        
        return solve_memo(nums,n,0,-1,dp);
        return solve_tabu(nums,n);
         */
        return solve_tabu_algo(nums,n);
    }
}