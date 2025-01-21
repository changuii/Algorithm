class Solution {
    public int[] solution(int brown, int yellow) {
        
        int y = 1;
        while(true){
            if(yellow % y == 0 && (yellow / y) + y + 2 == brown / 2){
                return new int[]{(yellow / y) + 2, y + 2};
            }   
            y++;
        }
    }
}