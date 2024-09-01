class Solution {
    public int solution(int n) {
        // n = 1 -> 1
        // n = 2 -> 2
        // n = 3 -> 3
        // n = 4 -> 5
        // n = 5 -> 8
        
        int[] A = new int[n+1];
        A[1] = 1;
        A[2] = 2;
        for(int i=3; i<=n; i++){
            A[i] = (A[i-2] + A[i-1]) % 1_000_000_007;
        }
        return A[n];
    }
}