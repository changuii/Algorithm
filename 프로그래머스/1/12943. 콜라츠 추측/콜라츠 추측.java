class Solution {
    public int solution(int num) {
        int i;
        long x = num;
        for(i=0; i<500 && x != 1; i++){
            x = x % 2 == 0 ? x / 2 : x * 3 + 1;
        }
        return i == 500 ? -1 : i;
    }
}