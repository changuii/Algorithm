import java.util.*;
class Solution {
    int[] dx = {0, 1, 1};
    int[] dy = {1, 0, 1};
    int count = 0;
    public int solution(int m, int n, String[] board) {
        char[][] map = new char[m][n];
        for(int i=0; i<m; i++){
            map[i] = board[i].toCharArray();
        }
        
        return deleteBlock(map);
    }
    
    public int deleteBlock(char[][] board){
        int count = 0;
        int round = 0;
        while(true){
            // System.out.println("round : " + ++round);
            // System.out.println(Arrays.deepToString(board));
            ArrayList<int[]> deleteList = new ArrayList<>();
            for(int i=0; i<board.length-1; i++){
                for(int j=0; j<board[i].length-1; j++){
                    if(board[i][j] == '.') continue;
                    char now = board[i][j];
                    boolean flag = true;
                    for(int x = 0; x<dx.length; x++){
                        if(now != board[i+dx[x]][j+dy[x]]){
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        deleteList.add(new int[]{i, j});
                        deleteList.add(new int[]{i + dx[0], j + dy[0]});
                        deleteList.add(new int[]{i + dx[1], j + dy[1]});
                        deleteList.add(new int[]{i + dx[2], j + dy[2]});
                    }
                }
            }
            if(deleteList.size() == 0) break;
            for(int[] now : deleteList){
                if(board[now[0]][now[1]] == '.') continue;
                // System.out.println(now[0] + " " +  now[1]);
                board[now[0]][now[1]] = '.';
                count++;
            }

            for(int i=board.length-1; i>0; i--){
                for(int j=0; j<board[i].length; j++){
                    if(board[i][j] == '.'){
                        for(int x = i-1; x>=0; x--){
                            if(board[x][j] != '.'){
                                board[i][j] = board[x][j];
                                board[x][j] = '.';
                                break;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}