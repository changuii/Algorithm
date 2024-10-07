import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        StringBuilder sb = new StringBuilder();
        for(int t=1; ; t++){
            String num = br.readLine();
            if(num == null) break;
            int x = 0;
            int y = 0;
            int N = 100;
            int[][] A = new int[N][N];
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    A[i][j] = Integer.parseInt(st.nextToken());
                    if(A[i][j] == 2){
                        x = i;
                        y = j;
                    }
                }
            }
            
            

            sb.append("#").append(t).append(" ")
                .append(DFS(A, x, y)).append("\n");
        }
        System.out.println(sb);
    }

    public static int DFS(int[][] map,  int x, int y){
        if(x == 0){
            return y;
        }
        
        if(y + 1 < map.length && map[x][y + 1] == 1){
            map[x][y] = 0;
            return DFS(map, x, y + 1);
        }
        else if(y - 1 >= 0 && map[x][y-1] == 1 ){
            map[x][y] = 0;
            return DFS(map, x, y-1);
        }
        map[x][y] = 0;
        return DFS(map, x-1, y);
        
        
        
    }
}