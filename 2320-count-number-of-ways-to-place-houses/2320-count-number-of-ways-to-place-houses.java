class Solution {
    public int countHousePlacements(int n) {
        
        final int MOD = 1_000_000_007;

        if (n == 0) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 2;
        
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }

        // The result is the square of dp[n]
        long result = (long) dp[n] * dp[n] % MOD;
        return (int) result;
        
    }
}