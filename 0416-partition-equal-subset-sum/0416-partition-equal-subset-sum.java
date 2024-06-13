class Solution {
    public static boolean solve_memo(int ind, int target, int [] arr, int[][] dp){
        if(target == 0){
            return true;
        }    
        if(ind == 0){
            return arr[0] == target;
        }
        
        if(dp[ind][target] != -1){
            return dp[ind][target] == 0 ? false:true;
        }
        
        boolean notTaken = solve_memo(ind-1,target,arr,dp);
        boolean taken = false;
        
        if(arr[ind] <= target){
            taken = solve_memo(ind-1,target-arr[ind],arr,dp);
        }
        dp[ind][target] = notTaken || taken ? 1:0;
        
        return notTaken || taken;
    }
    
    
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i =0; i<nums.length; i++){
            sum += nums[i];
        }
        if(sum%2==0){
            
            int [][] dp = new int[nums.length][sum/2 +1];
            for(int row[] :dp){
                Arrays.fill(row,-1);
            }
            
            return solve_memo(nums.length-1,sum/2, nums,dp);
        }
        else{
            return false; 
        }
    }
}