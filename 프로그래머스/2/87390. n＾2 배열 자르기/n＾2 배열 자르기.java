class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left + 1)];
        
        int x=(int)(left / n);
        int y=(int)(left % n);
        for(int i=0; i<answer.length; i++){
            x = (int)(left / n);
            y = (int)(left++ % n);
            answer[i] = Math.max(x+1, y+1);
        }
        return answer;
    }
}