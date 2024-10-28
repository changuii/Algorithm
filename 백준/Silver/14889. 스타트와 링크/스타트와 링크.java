import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int min = Integer.MAX_VALUE;
    static int sum;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] A = new int[N][N];

        StringTokenizer st;
        sum = 0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
                sum += A[i][j];
            }
        }
        DFS(A, 0, N, new boolean[N], 0);

        System.out.println(min);

        
    }

    public static void DFS(int[][] A, int now, int N, boolean[] team, int depth){
        if(depth == N/2){
            int start = 0;
            for(int i=0; i<N; i++){
                if(!team[i]) continue;
                
                for(int j=i+1; j<N; j++){
                    if(!team[j]) continue;

                    start += A[i][j] + A[j][i];
                }
            }

            int link = 0;
            for(int i=0; i<N; i++){
                if(team[i]) continue;
                
                for(int j=i+1; j<N; j++){
                    if(team[j]) continue;

                    link += A[i][j] + A[j][i];
                }
            }
            min = Math.min(min, Math.abs(start-link));
            return;
        }

        for(int i=now; i<N; i++){
            if(!team[i]){
                team[i] = true;
                DFS(A, i+1, N, team, depth + 1);
                team[i] = false;
            }
        }
        
    }
}