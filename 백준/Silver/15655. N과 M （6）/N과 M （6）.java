import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N;
    static int M;
    static int[] num;
    static int[] select;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N];
        select = new int[M];
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);
        dfs(0, 0);

        System.out.println(sb);
    }

    public static void dfs(int depth, int now) {
        if(N - now < M - depth) return;
        
        if(depth == M){
            for(int i=0; i<select.length; i++) {
                sb.append(select[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=now; i<N; i++) {
            select[depth] = num[i];
            dfs(depth + 1, i + 1);
        }
    }
}