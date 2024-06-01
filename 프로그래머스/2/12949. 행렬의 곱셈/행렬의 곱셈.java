class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        // arr1의 행수 x arr2의 열수
        // 1 4  3 3 3    15 15 15
        // 3 2  3 3 3 -> 15 15 15
        // 4 1           15 15 15
        // 1행 x 1열 , 1행 2열 -> 3 x 2 (x) 2 x 2 -> 3 x 2
        // (1, 1 ) = (1, 1) x (1, 1) + (1, 2) x (2, 1)
        // (1, 2) = (1, 1) x (1, 2) + (1, 2) x (2, 2)
        
        int[][] answer = new int[arr1.length][arr2[0].length];
        // 행
        for(int i=0; i<arr1.length; i++){
            for(int x=0; x<arr2[0].length; x++){
                // System.out.println(i + " " + x);
                int sum = 0;
                for(int j=0; j<arr2.length; j++){
                    sum += arr1[i][j] * arr2[j][x]; 
                }
                answer[i][x] = sum;
            }
        }
        
        // 2 3 2 | 5 4 3 | 22 22 11
        // 4 2 4 | 2 4 1 | 36 28 18
        // 3 1 4 | 3 1 1 | 29 20 14
        
        // (1, 1) * (1, 1)
        // 1행 x 2열 -> 1, 2
        // 1행 x 3열 -> 1, 3
        // 2행 x 1열 -> 2, 1
        
        return answer;
    }
}