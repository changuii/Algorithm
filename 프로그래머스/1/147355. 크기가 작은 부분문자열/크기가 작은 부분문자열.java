class Solution {
    public int solution(String t, String p) {
        
        int idx = t.length() - p.length() + 1;
        int plength = p.length();
        int answer = 0;
        long val = Long.parseLong(p);
        for(int i=0; i<idx; i++) {
            
            long now = Long.parseLong(t.substring(i, i + plength));
            
            answer += now <= val ? 1 : 0;
        }
        
        return answer;
    }
}