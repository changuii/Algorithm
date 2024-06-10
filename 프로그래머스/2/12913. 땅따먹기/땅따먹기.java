class Solution {
    int solution(int[][] land) {
        int answer = 0;

        for(int i=1; i<land.length; i++){
            for(int j=0; j<land[i].length; j++){
                int max = 0;
                for(int x=0; x<land[i].length; x++){
                    if(max < land[i-1][x] && x != j) max = land[i-1][x];
                }
                land[i][j] += max; 
            }
        }
        
        int max = 0;
        for(int i=0; i<4; i++){
            if(max < land[land.length-1][i])
                max = land[land.length-1][i];
        }

        return max;
    }
}