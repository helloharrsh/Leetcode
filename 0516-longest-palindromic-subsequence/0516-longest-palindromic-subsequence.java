class Solution {
    public int solve_tabu(String s,String rev){
        int n = s.length();
        int m = rev.length();
        
        int dp[][] = new int[n+1][m+1];
        
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        
        for(int i =0; i<= n; i++){
            dp[i][0] = 0;
        }
        for(int j = 0; j<=m; j++){
            dp[0][j] = 0;  
        }
        
        for(int ind1 =1; ind1<= n; ind1++){
            for(int ind2= 1; ind2<=m ;ind2++){
                if(s.charAt(ind1-1) == rev.charAt(ind2-1))
                    dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
                else
                    dp[ind1][ind2] = Math.max(dp[ind1-1][ind2], dp[ind1][ind2-1]);
            }
        }
        return dp[n][m];
    }
    
    
    
    public int longestPalindromeSubseq(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        return solve_tabu(s,rev);
    }
}