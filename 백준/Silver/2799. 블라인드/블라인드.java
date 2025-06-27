import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] c = new int[5];
    static boolean[] visit;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        br.readLine();
        for(int t=0; t<N; t++){

            visit = new boolean[M];

            for(int i=1; i<=5; i++){
                search(br.readLine(), M, i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<5; i++){
            sb.append(c[i]).append(" ");
        }
        System.out.println(sb);
    }

    public static void search(String window, int M, int now){
        if(now == 5){
            for(int i=0; i<M; i++){
                if(!visit[i]){
                    c[4]++;
                }
            }
            return;
        }

        for(int i=0; i<M; i++){
            int idx = i * 5 + 1;
            if(visit[i]) continue;
            if(window.charAt(idx) == '.'){
                c[now-1]++;
                visit[i] = true;
            }
        }
        
    }
}