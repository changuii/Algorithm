class Solution {
    public int solution(int n) {
        int answer = n+1;
        int nCount = calculateConditionCount(n);
        while(true){
            if(satisfyedNextBigNum(nCount, answer)) break;
            answer++;
        }
        
        return answer;
    }
    
    public boolean satisfyedNextBigNum(int nCount, int nextBigNum){
        return nCount == calculateConditionCount(nextBigNum);
    }
    
    public int calculateConditionCount(int n){
        int c = 0;
        while(n > 0){
            c += n % 2;
            n /= 2;
        }
        return c;
    }
}