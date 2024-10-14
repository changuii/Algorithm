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

        int[] map = new int[100_001];
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) ->{
           return o1[1] - o2[1]; 
        });
        q.offer(new int[]{N, 1});
        while (!q.isEmpty()) {
            int[] now = q.poll();

            if(map[now[0]] != 0) continue;
            map[now[0]] = now[1];
            if(now[0] == M) break;

            if(now[0] +1 < map.length && map[now[0] + 1] == 0){
                q.offer(new int[] {now[0] + 1, now[1] + 1});
            }
            if(now[0] -1 >= 0 && map[now[0] - 1] == 0){
                q.offer(new int[] {now[0] - 1, now[1] + 1});
            }
            if(now[0] * 2 < map.length && map[now[0] * 2] == 0){
                q.offer(new int[] {now[0] * 2, now[1]});
            }
            
        }

        System.out.println(map[M] - 1);
        

        
    }
}