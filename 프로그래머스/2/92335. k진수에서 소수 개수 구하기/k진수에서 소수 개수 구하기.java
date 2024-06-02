import java.util.*;
class Solution {
    public int solution(int n, int k) {
        String K = "";
        while(n > 0){
            K = (n % k) + K;
            n = n / k;
        }
    
        StringTokenizer st = new StringTokenizer(K, "0");
        int c = 0;
        while(st.hasMoreTokens()){
            if(isPrime(Long.parseLong(st.nextToken()))) c++;
        }
        return c;
    }
    
    public boolean isPrime(long target){
        if(target == 0 || target == 1) return false;
        for(long i=2; i<=Math.sqrt(target); i++){
            if(target % i == 0) return false;
        }
        return true;
    }
}