class Solution {
    public int solution(int n) {
        int i=0;
        int j=0;
        int sum = 0;
        int c = 0;
        while(j<=n){
            if(n > sum) sum += ++j;
            else if(n < sum) sum -= ++i;
            else{
                sum += ++j;
                c++;
            }
        }
        return c;
    }
}