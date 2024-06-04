import java.util.*;
class Solution {
    // L, U, D, R
    int[] dx = {0, -1, 1, 0};
    int[] dy = {-1, 0, 0, 1};
    public int solution(String dirs) {
        char[] s = dirs.toCharArray();
        // 3번째 배열은 방향
        boolean[][][] visit = new boolean[11][11][4];
        
        int x = 5;
        int y = 5;
        int answer = 0;
        for(int i=0; i<s.length; i++){
            String now = Character.toString(s[i]);
            System.out.println(now + " " + x + " " + y);
            if(now.equals("L")){
                int xValue = x + dx[0];
                int yValue = y + dy[0];
                if(xValue >= 0 && yValue >= 0 && xValue < 11 && yValue < 11){
                    if(!visit[xValue][yValue][0] && !visit[x][y][3]){
                        answer++;
                        visit[x][y][3] = true;
                        visit[xValue][yValue][0] = true;
                    }
                    x = xValue;
                    y = yValue;
                }
            }else if(now.equals("U")){
                int xValue = x + dx[1];
                int yValue = y + dy[1];
                if(xValue >= 0 && yValue >= 0 && xValue < 11 && yValue < 11){
                    if(!visit[xValue][yValue][1] && !visit[x][y][2] ){
                        answer++;
                        visit[x][y][2] = true;
                        visit[xValue][yValue][1] = true;
                    }
                    x = xValue;
                    y = yValue;
                }
            }else if(now.equals("D")){
                int xValue = x + dx[2];
                int yValue = y + dy[2];
                if(xValue >= 0 && yValue >= 0 && xValue < 11 && yValue < 11){
                    if(!visit[xValue][yValue][2] && !visit[x][y][1]){
                        answer++;
                        visit[x][y][1] = true;
                        visit[xValue][yValue][2] = true;
                    }
                    x = xValue;
                    y = yValue;
                }
            }else{
                int xValue = x + dx[3];
                int yValue = y + dy[3];
                if(xValue >= 0 && yValue >= 0 && xValue < 11 && yValue < 11){
                    if(!visit[xValue][yValue][3] && !visit[x][y][0]){
                        answer++;
                        visit[x][y][0] = true;
                        visit[xValue][yValue][3] = true;
                    }
                    x = xValue;
                    y = yValue;
                }
            }
        }
        return answer;
    }
}