class Solution {
    public long solution(int n) {
        
        // 1 -> 1 -> 1
        // 2 -> 1 1, 2 -> 2
        // 3 -> 1 1 1, 1 2, 2 1 -> 3
        // 4 -> 1 1 1 1, 1 1 2, 1 2 1, 2 1 1, 2 2 -> 5
        // 5 -> 11111, 1112, 1121, 1211, 2111, 122, 212, 221 -> 8
        long[] dp = new long[2001];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=n; i++){
            dp[i] = (dp[i-2] + dp[i-1]) % 1234567;
        }
        return dp[n];
    }
}