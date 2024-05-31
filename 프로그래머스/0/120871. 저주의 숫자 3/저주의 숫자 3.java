class Solution {
    public int solution(int n) {
        int x = 0;
        int i = 0;
        for(i=1; x<n; i++){
            if(i % 3 != 0 && (i + "").equals( (i+"").replace("3", ""))) x++;
        }
        return i-1;
    }
}