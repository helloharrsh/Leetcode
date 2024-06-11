class Solution {
    
    /*
    public int helper(int idx, int[] dp, int[] arr){
        if(idx < 0){
            return 0;
        }
        if(idx == 0){
            return arr[idx];
        }
        if(dp[idx] != -1){
            return dp[idx];
        }
        int pick = arr[idx] + helper(idx-2,dp,arr);
        int not_pick = 0 + helper(idx-1,dp,arr);
        
        return dp[idx] = Math.max(pick,not_pick);
    }
    
    public int solve_memo(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1); 
        
        return helper(n-1,dp,nums);
        
    }
    */ 
    
    public int helper(int n, int [] dp, int[] nums){
        dp[0] = nums[0];
        
        for(int i=1;i<n;i++){
            int pick = nums[i];
            if(i>1){
                pick+=dp[i-2];
            }
            int not_pick = dp[i-1];
            
            dp[i] = Math.max(pick, not_pick);
        }
        return dp[n-1];

    }
    
    
    public int solve_tabu(int [] nums){
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1); 
        
        return helper(n,dp,nums);
    }
    public int rob(int[] nums) {
        //return(solve_memo(nums));
        return(solve_tabu(nums)); 
    }
}