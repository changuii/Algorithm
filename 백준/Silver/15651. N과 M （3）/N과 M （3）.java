import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringBuilder answer = new StringBuilder();

        for(int i=1; i<=N; i++){
            dfs(N,M, i, 1, i+"", answer);
        }

        System.out.println(answer);
    }

    public static void dfs(int N, int M, int now, int depth, String before, StringBuilder answer) {
        if(depth == M) {
            answer.append(before).append("\n");
            return;
        }

        for(int i=1; i<=N; i++) {
            dfs(N,M,i,depth+1,before + " " + i, answer);
        }
        
    }
}