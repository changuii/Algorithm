class Solution {
    public String solution(int n, int t, int m, int p) {
        
        int size = m * t;
        
        String x = "0";
        for(int i=1; x.length() <= size; i++){
            int now = i;
            String value = "";
            while(now > 0){
                value = ((now % n) >= 10 ? (char)('A'+(now % n) % 10)+"" : now%n) + value;
                now = now / n;
            }
            x += value;
        }
        
        String answer = "";
        for(int i=p-1; answer.length() < t ; i += m){
            answer += x.charAt(i)+"";
        }
        return answer;
    }
}