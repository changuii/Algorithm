import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] map = new int[101];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        System.out.println(BFS(map));
        
    }

    public static int BFS(int[] map){
        Queue<int[]> q = new ArrayDeque<>();

        boolean[] visit = new boolean[101];
        q.offer(new int[]{1, 0});
        visit[1] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if(now[0] == 100) return now[1];

            if(map[now[0]] != 0){
                now[0] = map[now[0]];
            }

            for(int i=1; i<=6; i++){
                if(i + now[0] > 100) break;
                if(!visit[now[0] + i]){
                    q.offer(new int[]{now[0] + i, now[1] + 1});
                    visit[now[0] + i] = true;
                }
            }
        }

        return 0;
    }
}