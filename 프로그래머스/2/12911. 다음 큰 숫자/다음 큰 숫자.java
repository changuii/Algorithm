class Solution {
    public int solution(int n) {
        
        int i = n+1;
        while(Integer.bitCount(n) != Integer.bitCount(i)){
            i++;
        }
        return i;
    }
}