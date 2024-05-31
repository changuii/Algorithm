class Solution {
    public int solution(int[][] board) {
        
        int[] dx = {0, 0, -1, 1, -1, -1, 1, 1};
        int[] dy = {1, -1, 0, 0, -1, 1, -1, 1};
        
        int count = 0;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                if(board[i][j] == 1) continue;
                boolean flag = true;
                for(int x=0; x<8; x++){
                    if(i + dx[x] >= 0 && j + dy[x] >= 0 &&
                       i + dx[x] < board.length && j + dy[x] < board.length ){
                        if(board[i+dx[x]][j+dy[x]] == 1){
                            flag = false;
                            break;
                        }
                    }
                }
                if(flag) count++;   
            }
        }
        return count;
    }
}