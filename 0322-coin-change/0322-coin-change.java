class Solution {
    /*
    public int solve_memo(int[] arr, int ind, int T, int[][] dp){
        if(ind == 0){
            if(T%arr[0] == 0){
                return T/arr[0];
            }
            else{
                return (int) Math.pow(10,9);
            }
        }
        
        if(dp[ind][T] != -1){
            return dp[ind][T];
        }
        
        int notTake = 0 + solve_memo(arr,ind-1,T,dp);
        int take = (int) Math.pow(10,9);
        
        if(arr[ind] <= T){
            take = 1 + solve_memo(arr,ind, T - arr[ind], dp);
        }
        
        return dp[ind][T] = Math.min(take,notTake);
    }
    
    */
    public int solve_tabu(int[] arr, int t){
        int n = arr.length; 
        int dp[][] = new int[n][t+1];
        
        int inf = (int) Math.pow(10,9);
        
        for(int i =0; i<=t; i++){
            if(i%arr[0] == 0){
                dp[0][i] = i/arr[0];
            }
            else{
                dp[0][i] = inf;
            }
        }
        
        for(int ind = 1; ind <n; ind++){
            for(int tar = 0; tar <= t; tar++){
                
                int notTake = 0 + dp[ind-1][tar];
                int take = inf;
                
                if(arr[ind] <= tar){
                    take = 1 + dp[ind][tar - arr[ind]];
                }
                
                dp[ind][tar] = Math.min(notTake, take);
            }
        }
        
        int ans = dp[n-1][t];
        
        if(ans == inf){
            return -1;
        }
        else{
            return ans;
        }
    }
    public int coinChange(int[] coins, int amount) {
        /*
        int n = coins.length; 
        int [][] dp = new int[n][amount+1];
        
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        
        
        int ans = solve_memo(coins,n-1,amount,dp);
        if(ans == Math.pow(10,9)){
            return -1;
        }
        else{
            return ans;
        }
        
    }
    */
        int [] arr =coins;
        int t = amount;
        return solve_tabu(arr,t);
    }
}