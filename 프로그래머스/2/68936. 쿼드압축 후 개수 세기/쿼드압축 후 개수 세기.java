class Solution {
    public int[] solution(int[][] arr) {
        int N = arr.length;
        return DFS(N, 0, 0, arr);
    }
    
    public static int[] DFS(int N, int x, int y, int[][] arr){
        int now = arr[x][y];
        boolean flag = false;
        for(int i=x; i<x+N && !flag; i++){
            for(int j=y; j<y+N; j++){
                if(now != arr[i][j]){
                    flag = true;
                    break;
                }
            }
            
        }
        
        // 4 x 4
        // [0, 0 ], [2, 0], [0, 2], [2, 2] 
        
        
        if(flag){
            int[] val1 = DFS(N / 2, x,y, arr);
            int[] val2 = DFS(N / 2, x + N/2,y, arr);
            int[] val3 = DFS(N / 2, x,y + N/2, arr);
            int[] val4 = DFS(N / 2, x + N/2 ,y + N/2, arr);
            
            return new int[]{val1[0] + val2[0] + val3[0] + val4[0]
                , val1[1] + val2[1] + val3[1] + val4[1] };
        }
        else{
            return now == 1 ? new int[]{0, 1} : new int[]{1, 0};
        }
        
        
    }
}