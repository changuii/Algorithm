class Solution {
    public int[] solution(int brown, int yellow) {
        
        // 10 , 2 -> 4 3
        //  8 , 1 -> 3 3
        // 24, 24 -> 8 6
        // brown + yellow = width * height
        int size = brown + yellow;
        int width = 3;
        while(size % width != 0 || size / width > width 
              || yellow != (width-2) * (size / width-2)){
            width++;
        }
        return new int[]{width, size / width};
        
    }
}