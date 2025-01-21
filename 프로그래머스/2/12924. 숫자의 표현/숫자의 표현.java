class Solution {
    public int solution(int n) {
        int i = 1;
        int j = 1;
        int v = 0;
        int answer = 0;
        while(i <= n/2){
            if(v == n){
                v -= i++;
                answer++;
            }
            else if(v < n){
                v += j++;
            } else{
                v -= i++;
            }
        }
        return answer+1;
    }
        
}