class Solution {
    public boolean solution(int x) {
        return x % sum(x) == 0;
    }
    
    public int sum(int x){
        int sum = 0;
        while(x > 0){
            sum += x%10;
            x /= 10;
        }
        return sum;
    }
}