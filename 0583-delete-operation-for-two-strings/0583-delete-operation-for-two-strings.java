class Solution {
    public int solve_tabu(String s1, String s2,int n, int m){

        int dp[][] = new int[n+1][m+1];
        for(int row[] :dp)
            Arrays.fill(row,-1);
        for(int i =1; i<=n;i++)
            dp[i][0] = 0;
        for(int i= 0; i<=m;i++)
            dp[0][i] = 0;
        
        for(int ind1 =1; ind1<= n; ind1++){
            for(int ind2=1; ind2<=m; ind2++){
                if(s1.charAt(ind1-1) == s2.charAt(ind2-1))
                    dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
                else
                    dp[ind1][ind2] = Math.max(dp[ind1-1][ind2], dp[ind1][ind2-1]);
            }
        }
        return dp[n][m];
    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int ans = solve_tabu(word1,word2,n,m);
        
        return((n-ans) + (m-ans));
        
    }
}