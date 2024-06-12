class Solution {
    /*
    public int using_memo(int i, int j, int [][] dp){
        if(i==0 && j==0){
            return 1;
        }    
        if(i<0 || j<0){
            return 0;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j]; 
        }
        
        int up = using_memo(i-1,j,dp);
        int left = using_memo(i,j-1,dp); 
        
        return dp[i][j] = up+left; 
    }
    
    */ 
    
    public int using_tabu(int m, int n, int[][] dp){
        for(int i=0; i< m; i++){
            for(int j=0; j< n; j++){
                if(i==0 && j==0){
                    dp[i][j] = 1; 
                    continue;
                }
                
                int up = 0; 
                int left = 0;
                
                if(i>0){
                    up = dp[i-1][j];
                }
                if(j>0){
                    left = dp[i][j-1];
                }
                dp[i][j] = up+left;
            }
        }
        
        return dp[m-1][n-1]; 
    }
    
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n]; 
        
        for(int[] row: dp){
            Arrays.fill(row,-1); 
        }
        
        return using_tabu(m,n,dp); 
        //return using_memo(m-1,n-1,dp);
    }
}