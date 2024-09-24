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

        int[] A = new int[100_001];
        boolean[] visit = new boolean[100_001];

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(N);
        while (!q.isEmpty()) {
            int now = q.poll();
            if(now == M) break;
            if(now-1 >= 0 && !visit[now - 1]){
                visit[now - 1] = true;
                A[now-1] = A[now] + 1;
                q.offer(now-1);
            }
            if(now+1 < 100_001 && !visit[now + 1]){
                visit[now+1] = true;
                A[now+1] = A[now] + 1;
                q.offer(now+1);
            }
            if(now*2 < 100_001 && !visit[now * 2]){
                visit[now * 2] = true;
                A[now * 2] = A[now] + 1;
                q.offer(now * 2);
            }
        }
        System.out.println(A[M]);
        
        

        

        
    }
}