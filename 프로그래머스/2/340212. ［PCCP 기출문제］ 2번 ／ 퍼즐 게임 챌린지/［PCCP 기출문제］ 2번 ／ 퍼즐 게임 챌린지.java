class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int max = 0;
        for(int i=0; i<diffs.length; i++){
            max = Math.max(diffs[i], max);
        }
        
        int l = 1;
        int h = max;
        int mid = 0;
        while(l <= h){
            mid = (l + h) / 2;
            
            if(check(mid, diffs, times, limit)){
                h = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        
        return h + 1;
    }
    
    public static boolean check(int level, int[] diffs, int[] times, long limit){
        long time = 0;
        long preTime = 0;
        long now = 0;
        for(int i=0; i<diffs.length; i++){
            if(diffs[i] <= level) now = 0;
            else now = diffs[i] - level;
            
            time += now * (preTime + times[i]) + times[i];
            preTime = times[i];
        }
        return time <= limit;
    }
}