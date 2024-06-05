class Solution {
    public int solution(int n) {
        int temp = n+1;
        while(Integer.bitCount(temp) != Integer.bitCount(n)){
            temp++;
        }
        return temp;
    }
}