import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];

        StringTokenizer st;
        for(int i=0; i<N; i++){
            st  = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(map, 1, 0, 0);
        System.out.println(min);
    }


    public static void dfs(int[][] map, int visit, int now, int sum){
        if(visit == ((1 << N) - 1)){
            if(map[now][0] == 0) return;
            min = Math.min(min, sum + map[now][0]);
        }

        for(int i=0; i<N; i++){
            if(((visit & (1 << i)) == 0) && map[now][i] != 0){
                dfs(map, visit | (1 << i), i, sum + map[now][i]);
            }
        }
    }
}