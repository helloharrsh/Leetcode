class Solution {
    
    /*
    public int solve_memo(String s1, String s2, int ind1, int ind2, int[][] dp){
        if(ind1<0 || ind2<0)
            return 0;
        if(dp[ind1][ind2] != -1)
            return dp[ind1][ind2];
        if(s1.charAt(ind1) == s2.charAt(ind2))
            return dp[ind1][ind2] = 1 + solve_memo(s1,s2,ind1-1,ind2-1,dp);
        
        else
            return dp[ind1][ind2] = Math.max(solve_memo(s1,s2,ind1,ind2-1,dp), solve_memo(s1,s2,ind1-1,ind2,dp));
    }
    
    */
    public int solve_tabu(String s1, String s2){
            int n  = s1.length(); 
            int m = s2.length(); 

            int dp[][] = new int[n+1][m+1]; 
            for(int rows[] : dp) {
                Arrays.fill(rows, -1);
            }

            for(int i = 0; i<= n; i++) {
                dp[i][0] = 0; 

            }
            for(int i = 0; i<=m; i++) {
                dp[0][i] = 0; 
            }

            for(int ind1 =1; ind1 <= n; ind1++) {
                for(int ind2 = 1; ind2 <=m; ind2++) {
                    if(s1.charAt(ind1-1) == s2.charAt(ind2-1)) {
                        dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
                    }

                    else {
                        dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2-1]); 
                    }
                }
            }
            return dp[n][m]; 
    }
    
    
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        
        /*
        int dp[][] = new int[n][m];
        
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        return solve_memo(text1,text2,n-1,m-1,dp);
        */ 
        return solve_tabu(text1,text2);
        
    }
}