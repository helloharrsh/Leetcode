class Solution {
    /*
    public int solve_memo(int i, int j, int [][] maze, int[][] dp){
        if(i>=0 && j>=0 && maze[i][j] == 1){
            return 0;
        }    
        
        if(i ==0 && j ==0){
            return 1;
        }
        
        if(i<0 || j<0){
            return 0;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int up = solve_memo(i-1, j, maze,dp);
        int left = solve_memo(i,j-1,maze,dp);
        
        return dp[i][j] = up + left; 
    }
    
    */
    
    public int solve_tabu(int n, int m ,int[][] maze, int [][] dp){
        for(int i =0; i<n; i++){
            for(int j =0; j <m; j++){
                if(maze[i][j] == 1){
                    dp[i][j] = 0;
                    continue;
                }
                
                if(i ==0 && j ==0){
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
                dp[i][j] = up + left;
            }
        }
        
        return dp[n-1][m-1]; 
    }
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length; 
        
        int dp[][] = new int[n][m]; 
        
        for(int row[] :dp){
            Arrays.fill(row,-1); 
        }
        return solve_tabu(n,m,obstacleGrid,dp);
        //return solve_memo(n-1,m-1,obstacleGrid,dp); 
        
    }
}