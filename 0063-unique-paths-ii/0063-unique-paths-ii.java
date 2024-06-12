class Solution {
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
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length; 
        
        int dp[][] = new int[n][m]; 
        
        for(int row[] :dp){
            Arrays.fill(row,-1); 
        }
        
        return solve_memo(n-1,m-1,obstacleGrid,dp); 
        
    }
}