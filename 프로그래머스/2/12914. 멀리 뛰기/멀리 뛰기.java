class Solution {
    public long solution(int n) {
        // 1 -> 1
        // 2 -> 1 1, 2
        // 3 -> 1 1 1, 2 1, 1 2
        // 4 -> 1 1 1 1, 2 1 1, 1 2 1, 1 1 2, 2 2
        // 5 -> 1112 212 122
        //   -> 1111 2111 1211 1121 221
        
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i=2; i<dp.length; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        }        
        
        return dp[n];
    }
}