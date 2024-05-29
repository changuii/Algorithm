class Solution {
    public int solution(int n) {
        
        int[] x = new int[n+1];
        x[0] = 0;
        x[1] = 1;
        for(int i=2; i<=n; i++){
            x[i] = (x[i-1] + x[i-2]) % 1234567;
        }
        return x[n];
    }
}