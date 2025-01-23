class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int l = 1;
        int h = 100_000;
        int m = 0;
        
        while(l <= h){
            m = (l + h) / 2;
            
            if(check(m, limit, diffs, times)){
                h = m - 1;
            }
            else{
                l = m + 1;
            }
        }
        
        return h + 1;
    }
    
    public boolean check(long m, long limit, int[] diffs, int[] times){
        long time = 0;
        for(int i=0; i<diffs.length; i++){
            if(diffs[i] <= m){
                time += times[i];
            } else{
                long v = i == 0 ? 0 : times[i-1] + times[i];
                time += (diffs[i] - m) * v + times[i];
            }
            if(time > limit){
                return false;
            }
        }
        
        return true;
    }
}