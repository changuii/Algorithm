class Solution {
    public String solution(String s) {
        String[] value = s.split(" ");
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(String v : value){
            int now = Integer.parseInt(v);
            if(min > now){
                min = now;
            }
            if(max < now){
                max = now;
            }
        }
        
        return min + " " + max;
    }
}