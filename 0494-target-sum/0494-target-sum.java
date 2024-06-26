class Solution {
    
    /*
    public int solve_memo(int ind, int target, int[] arr, int[][] dp){
        if(ind == 0){
            if(target == 0 && arr[0] == 0)
                return 2;
            if(target == 0 || target == arr[0])
                return 1;
            return 0;
    }
        
        if(dp[ind][target] != -1){
            return dp[ind][target];
        }
        
        int nottake = solve_memo(ind-1, target, arr,dp);
        int take = 0;
        
        if(arr[ind] <= target){
            take = solve_memo(ind-1,target - arr[ind], arr,dp);
        }
        
        return dp[ind][target] = (take + nottake);
    }
    
    */
    
    public int solve_tabu(int [] nums, int target){
        int n = nums.length;
        int [][] dp = new int[n][target+1];
        
        if(nums[0] == 0)
            dp[0][0] =2;
        else
            dp[0][0] =1;
        
        if(nums[0] != 0 && nums[0] <= target)
            dp[0][nums[0]] = 1;
        
        for(int ind = 1; ind<n; ind++){
            for(int tar = 0; tar<= target; tar++){
                int notTake = dp[ind-1][tar];
                
                int take =0;
                
                if(nums[ind] <= tar)
                    take = dp[ind-1][tar - nums[ind]];
                dp[ind][tar] = (notTake + take);
            }
        }
        
        return dp[n-1][target];
    }
    
    
    public int findTargetSumWays(int[] nums, int target) {
        
        
        int tot = 0; 
        for(int i =0; i< nums.length; i++){
            tot += nums[i];
        }
        if(tot - target < 0){
            return 0;
        }
        if((tot - target) % 2 == 1){
            return 0;
        }
        
        int n = nums.length;
        int s2 = (tot - target)/2;
        
        /*
        int dp[][] = new int[n][s2+1];
        
        for(int [] row: dp){
            Arrays.fill(row,-1);
        }
        
        return solve_memo(n-1,s2,nums,dp);
        
        */
        
        return solve_tabu(nums,s2);
    }
}