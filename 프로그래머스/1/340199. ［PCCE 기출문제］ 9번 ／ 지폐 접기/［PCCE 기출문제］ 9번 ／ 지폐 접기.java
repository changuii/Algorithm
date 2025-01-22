class Solution {
    public int solution(int[] wallet, int[] bill) {
        
        int answer = 0;
        while(!isCorrect(wallet, bill)){
            answer++;
            
            if(bill[0] < bill[1]){
                bill[1] /= 2;
            } else{
                bill[0] /= 2;
            }
        }
        
        return answer;
    }
    
    public boolean isCorrect(int[] wallet, int[] bill){
        return (bill[0] <= wallet[0] && bill[1] <= wallet[1])
            || (bill[1] <= wallet[0] && bill[0] <= wallet[1]);
    }
}