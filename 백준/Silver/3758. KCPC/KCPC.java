import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int t=0; t<T; t++){
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int I = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] score = new int[N+1][K+1];
            int[] teamLast = new int[N+1];
            int[] teamCount = new int[N+1];
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                score[a][b] = Math.max(score[a][b], c);
                teamLast[a] = i;
                teamCount[a]++;
            }

            int[] teamScore = new int[N+1];
            for(int i=1; i<=N; i++){
                int sum = 0;
                for(int j=1; j<=K; j++){
                    sum += score[i][j];
                }
                teamScore[i] = sum;
            }

            int we = teamScore[I];
            int th = 0;
            for(int i=1; i<=N; i++){
                if(i == I) continue;

                if(teamScore[i] > we){
                    th++;
                }
                else if(teamScore[i] == we){
                    if(teamCount[i] < teamCount[I]) th++;
                    else if(teamCount[i] == teamCount[I])
                        if(teamLast[i] < teamLast[I]) th++;
                }
            }
            // System.out.println(Arrays.toString(teamScore));
            sb.append(th+1).append("\n");
        }
        System.out.println(sb);
    }
}