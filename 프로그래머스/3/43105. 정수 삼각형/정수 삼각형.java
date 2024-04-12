import java.math.*;
class Solution {
    public int solution(int[][] triangle) {
        int[][] D = new int[triangle.length][triangle.length];
        
        for(int i=0; i<triangle[triangle.length-1].length;i++){
            D[triangle.length-1][i] = triangle[triangle.length-1][i];
        }
        
        for(int i=triangle.length-2; i>=0; i--){
            for(int j=0; j<triangle[i].length; j++){
                D[i][j] = Math.max(D[i+1][j], D[i+1][j+1]) + triangle[i][j];
            }
        }
        
        // i번째 줄에서 j까지 왔을 때 최댓값
        return D[0][0];
    }
}