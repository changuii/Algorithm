class Solution {
    public int[] solution(String s) {
        int count = 0;
        int c =0;
        while(s.length() > 1){
            // 0 제거
            String now = s.replace("0", "");
            count += s.length() - now.length();
            s = now;
            
            int v = s.length();
            String convert = "";
            while( v >= 1){
                convert = (v % 2) + convert;
                v = v / 2;
            }
            s = convert;
            c++;
        }
        
        return new int[]{c, count};
    }
}