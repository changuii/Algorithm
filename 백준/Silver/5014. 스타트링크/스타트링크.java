import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] map = new int[F+1];
        boolean[] visit = new boolean[F+1];
        Arrays.fill(map, -1);

        Queue<Integer> q = new ArrayDeque<>();

        q.offer(S);
        map[S] = 0;
        map[0] = 0;
        while (!q.isEmpty()) {
            int now = q.poll();
            if(now == G) break;
            if(now + U <= F && map[now+U] == -1){
                q.offer(now + U);
                map[now+U] = map[now] + 1;
            }
            if(now - D >= 0 && map[now-D] == -1){
                q.offer(now - D);
                map[now-D] = map[now] + 1;
            }
        }

        System.out.println(map[G] == -1 ? "use the stairs" : map[G]);
        
        
    }
}