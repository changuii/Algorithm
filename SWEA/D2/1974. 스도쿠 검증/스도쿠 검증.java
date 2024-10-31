import java.util.*;
import java.util.stream.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int t=1; t<=T; t++){
            int N = 9;
            int[][] map = new int[N][N];
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int result = 0;
            result += validateRow(map, N);
            result += validateCol(map, N);
            result += validateRectangle(map, N);
            

            sb.append(String.format("#%d %d\n", t, result == 0 ? 1 : 0));
        }
        System.out.println(sb);
    }

    public static int validateRectangle(int[][] map, int N){
        for(int i=0; i<N; i += 3){
            for(int j=0; j<N; j += 3){

                int[] c = new int[N+1];
                for(int k=0; k<3; k++){
                    for(int l=0; l<3; l++){
                        c[map[i+k][j+l]]++;
                    }
                }

                for(int k=1; k<=N; k++){
                    if(c[k] != 1){
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    public static int validateRow(int[][] map, int N){
        for(int i=0; i<N; i++){
            int[] result = Arrays.stream(map[i]).distinct().toArray();
            if(map[i].length != result.length){
                return 1;
            }
        }
        return 0;
    }

    public static int validateCol(int[][] map, int N){
        for(int i=0; i<N; i++){
            int[] c = new int[N+1];

            for(int j=0; j<N; j++){
                c[map[j][i]]++;
            }

            for(int j=1; j<=N; j++){
                if(c[j] != 1){
                    return 1;
                }
            }
        }
        return 0;
    }
}