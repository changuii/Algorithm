class Solution {
    boolean[] isPrime;
    boolean[] visitNum;
    boolean[] visit;
    int count;
    public int solution(String numbers) {
        char[] num = numbers.toCharArray();
        visitNum = new boolean[10_000_000];
        isPrime = new boolean[10_000_000];
        visit = new boolean[num.length];
        isPrime[0] = true;
        isPrime[1] = true;
        
        
        makePrimeArr(10_000_000);
        DFS(num, "0", 0);
        return count;
    }
    
    public void makePrimeArr(int num){
        for(int i=2; i<Math.sqrt(num); i++){
            for(int j=2; j*i < num; j++){
                isPrime[i * j] = true;
            }
        }
    }
    
    public void DFS(char[] val, String num, int now){
        if(!isPrime[Integer.parseInt(num)] && !visitNum[Integer.parseInt(num)]){
            count++;
            visitNum[Integer.parseInt(num)] = true;
        }
        
        for(int i=0; i<val.length; i++){
            if(!visit[i]){
                visit[i] = true;
                DFS(val, num + val[i], now+1);
                visit[i] = false;
            }
        }
        
    }
    
    
}