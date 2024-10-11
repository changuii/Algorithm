import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {

    static int[] dx = {1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1};
    static boolean runFlag;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int t=1; t<=T; t++){
            int N = Integer.parseInt(br.readLine());

            char[][] map = new char[N][N];
            runFlag = true;

            for(int i=0; i<N; i++){
                map[i] = br.readLine().toCharArray();
            }

            for(int i=0; i<N && runFlag; i++){
                for(int j=0; j<N && runFlag; j++){
                    if(map[i][j] == 'o'){
                        isGameEnd(map, i, j);
                    }
                }
            }
            
            sb.append(String.format("#%d %s\n", t, runFlag ? "NO" : "YES"));
        }
        System.out.println(sb);
    }

    public static void isGameEnd(char[][] map, int a, int b){
        for(int i=0; i<4; i++){
            int c = 1;
            for(int j=1; j<map.length; j++){
                int x = a + dx[i]*j;
                int y = b + dy[i]*j;

                if(!(x >= 0 && x<map.length && y>=0 && y<map.length && map[x][y] != '.')) break;
                
                c++;
                if(c == 5){
                    runFlag = false;
                    return;
                }
            }
        }
        
    }
}