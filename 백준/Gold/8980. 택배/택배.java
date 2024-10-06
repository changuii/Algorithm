import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2)->{
           return (o1[1] - o1[0]) - (o2[1] - o2[0]); 
        });
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            q.offer(new int[]{a, b, c});
        }


        // 1 -> 1 ~ 2, 2 -> 2 ~ 3
        int[] size = new int[N];
        int answer = 0;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            // System.out.println(now[0] + " -> " + now[1] + " size : " + now[2]);
            int min = Integer.MAX_VALUE;
            
            for(int i=now[0]; i<now[1]; i++){
                int val = C - (now[2] + size[i]);
                min = Math.min(min, val < 0 ? now[2] + val : now[2]);
            }
            // System.out.println("carry : " + min);
            
            for(int i=now[0]; i<now[1]; i++){
                size[i] += min;
            }
            answer += min;
            
        }
        // System.out.println(Arrays.toString(size));
        System.out.println(answer);
        
        
    }
}