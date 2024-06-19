class Solution {
    public int solve_memo(String s1,String s2, int ind1, int ind2, int[][]dp){
        if(ind2<0)
            return 1;
        if(ind1<0)
            return 0;
        
        if(dp[ind1][ind2] != -1)
            return dp[ind1][ind2];
        
        if(s1.charAt(ind1) == s2.charAt(ind2)){
            int stay = solve_memo(s1,s2,ind1-1,ind2,dp);
            int leave = solve_memo(s1,s2,ind1-1,ind2-1,dp);
            return dp[ind1][ind2] = stay + leave;
        }
        else
            return dp[ind1][ind2] = solve_memo(s1,s2,ind1-1,ind2,dp);
    }
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int dp[][] = new int[n][m];
        for(int row[]:dp)
            Arrays.fill(row,-1);
        return solve_memo(s,t,n-1,m-1,dp);
    }
}