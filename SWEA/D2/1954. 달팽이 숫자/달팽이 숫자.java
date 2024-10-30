import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t=1; t<=T; t++){
            int N = Integer.parseInt(br.readLine());

            int[][] map = new int[N][N];

            int num = 1;
            int x = 0;
            int y = 0;
            int direction = 0;
            while(N * N >= num){
                map[x][y] = num++;

                
                int nextX = x + dx[direction];
                int nextY = y + dy[direction];
                
                if(!(nextX >=0 && nextX < N && nextY >= 0 && nextY < N) || map[nextX][nextY] != 0){
                    direction = (direction + 1) % 4;
                }

                x = x + dx[direction];
                y = y + dy[direction];
            }

            sb.append(String.format("#%d\n", t));
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    sb.append(map[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}