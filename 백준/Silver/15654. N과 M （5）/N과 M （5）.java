import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] num;
    static int[] select;
    static boolean[] visit;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        sb = new StringBuilder();
        visit = new boolean[N];
        select = new int[M];
        num = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);
        dfs(0);

        System.out.println(sb);
    }

    public static void dfs(int depth) {
        if(depth == select.length) {

            for(int i=0; i<select.length; i++) {
                sb.append(select[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<num.length; i++) {
            if(!visit[i]) {
                visit[i] = true;
                select[depth] = num[i];
                dfs(depth + 1);
                visit[i] = false;
            }
        }

        
    }
}