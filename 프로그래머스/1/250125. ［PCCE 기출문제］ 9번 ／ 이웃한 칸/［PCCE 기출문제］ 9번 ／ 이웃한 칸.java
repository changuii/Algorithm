class Solution {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        for(int i=0; i<4; i++){
            int x = dx[i] + h;
            int y = dy[i] + w;
            
            if(!(x >=0 && x<board.length && y>=0 && y<board[0].length)) continue;
            
            answer += board[h][w].equals(board[x][y]) ? 1 : 0;
        }
        return answer;
    }
}