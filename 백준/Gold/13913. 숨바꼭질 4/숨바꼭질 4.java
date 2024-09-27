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

        int[][] map = new int[200_000][2];

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(N);
        map[N][0] = 1;
        map[N][1] = -1;
        while (!q.isEmpty()) {
            int now = q.poll();

            if(now == M) break;

            if(now-1 >= 0 && map[now-1][0] == 0){
                q.offer(now-1);
                map[now-1][0] = map[now][0] + 1;
                map[now-1][1] = now;
            }
            if(now+1 < map.length && map[now+1][0] == 0){
                q.offer(now+1);
                map[now+1][0] = map[now][0] + 1;
                map[now+1][1] = now;
            }
            if(now * 2 < map.length && map[now * 2][0] == 0){
                q.offer(now * 2);
                map[now * 2][0] = map[now][0] + 1;
                map[now * 2][1] = now;
            }
        }
        StringBuilder sb = new StringBuilder();
        System.out.println(map[M][0] - 1);

        int index = M;
        for(int i=0; i<map[M][0]; i++) {
            sb.insert(0, index + " ");
            index = map[index][1];
        }

        System.out.println(sb);
    }
}