import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            int a = W * P;
            int b = Q;
            W -= R;
            b += W * S < 0 ? 0 : W * S;
            
            
            
            sb.append(String.format("#%d %d\n", t, a < b ? a : b));
        }
        System.out.println(sb);
    }

    public static int checkRow(int[][] map, int row, int M){
        int c = 0;
        for(int i=0; i<map[row].length; i++){
            if(map[row][i] == 0) continue;
            int size = 1;
            for(int j=i+1; j<map[row].length; j++){
                if(map[row][j] == 0) break;
                size++;
            }

            if(size > 1){
                i += size-1;
                if(size == M) c++;
            }
            
        }
        return c;
    }

    public static int checkCol(int[][] map, int col, int M){
        int c = 0;
        for(int i=0; i<map.length; i++){
            if(map[i][col] == 0) continue;
            int size = 1;
            for(int j=i+1; j<map.length; j++){
                if(map[j][col] == 0) break;
                size++;
            }

            if(size > 1){
                i += size-1;
                if(size == M) c++;
            }
            
        }
        return c;
    }
    
}