class Solution {
    public int[] solution(int brown, int yellow) {
        
        int i= 3;
        int map = brown + yellow;
        while(true){
            if(map % i == 0 && i >= map / i && (i-2) * (map / i - 2) == yellow){
                break;
            }else i++;
        }
        
        int[] answer = {i, map / i};
        return answer;
    }
}