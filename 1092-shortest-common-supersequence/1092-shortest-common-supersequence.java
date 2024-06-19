class Solution {
    public String solve_tabu(String s1, String s2,int n, int m){
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
        int len = dp[n][m];
        int i = n;
        int j = m; 
        
        int index = len-1;
        String str = "";
        while(i>0 && j>0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                str+= s1.charAt(i-1);
                index--;
                i--;
                j--;
            }
            else if(dp[i-1][j] > dp[i][j-1]){
                str += s1.charAt(i-1);
                i--;
            }
            else{
                str+= s2.charAt(j-1);
                j--;
            }
        }
        while(i>0){
          str += s1.charAt(i-1);
          i--;
        }
        while(j>0){
          str += s2.charAt(j-1);
          j--;
        }
    String ans2=new StringBuilder(str).reverse().toString();
    return ans2;
    }
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        return(solve_tabu(str1,str2,n,m));
    }
}