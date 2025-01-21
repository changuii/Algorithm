class Solution {
    public int[] solution(int 갈색, int 노랑색) {
        
        int 세로 = 1;
        while(true){
            if(노랑색 % 세로 == 0 && (노랑색 / 세로) + 세로 + 2 == 갈색 / 2){
                return new int[]{(노랑색 / 세로) + 2, 세로 + 2};
            }   
            세로++;
        }
    }
}