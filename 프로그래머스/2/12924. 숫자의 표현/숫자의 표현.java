class Solution {
    public int solution(int n) {
        int count = 0;
        
        // sum > n -> 1제거 2제거
        
        
        for(int i=1; i<n / 2 + 1; i++){
            int sum = i;
            for(int j=i+1; j<=n; j++){
                sum+=j;
                if(sum == n) count++;
                else if(sum > n) break;
            }
        }
        
        
        return count+1;
    }
}