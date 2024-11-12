import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            int N = Integer.parseInt(br.readLine());
            int[] map = new int[N * (N+1) / 2];
            DFS(map, 0, 1, N);

            int depth = 1;
            int c = 0;
            StringBuilder answer = new StringBuilder();
            for(int i=0; i<map.length; i++){
                c++;
                answer.append(map[i]).append(" ");
                if(c == depth){
                    c = 0;
                    depth++;
                    answer.append("\n");
                }
            }
            sb.append(String.format("#%d\n%s", t, answer.toString()));
        }
        System.out.println(sb);
    }

    public static void DFS(int[] map, int now, int depth, int N){
        if(depth > N) return;
        map[now]++;

        DFS(map, now + depth, depth+1, N);
        DFS(map, now + depth + 1, depth+1, N);
        
        
    }
}