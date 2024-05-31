class Solution {
    public int[] solution(int brown, int yellow) {
        
        // brown + yellow = sum
        // brown + yellow = 가로 x 세로
        // i => 가로
        
        // i를 높이면서, (sum % i == 0), i >= (sum / i)
        // ?
        // 가로-2 * 세로-2 == yellow
        
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