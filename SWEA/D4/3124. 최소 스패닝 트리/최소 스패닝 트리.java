import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    static int[] A;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for(int t=1;t<=T; t++){
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            A = new int[N+1];
            for(int i=1; i<=N; i++){
                A[i] = i;
            }

            PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> {
               return o1.w - o2.w; 
            });
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                q.offer(new Node(a, b, w));
            }

            long answer = 0;
            int c = 0;
            while (c < N-1) {
                Node now = q.poll();
                if(find(now.a) == find(now.b)) continue;

                union(now.a, now.b);
                answer += now.w;
                c++;
            }
            sb.append(String.format("#%d %d\n", t, answer));
        }
        System.out.println(sb);
    }

    public static void union(int a, int b){
        int x = find(a);
        int y = find(b);

        A[y] = x;
    }

    public static int find(int a){
        if(a == A[a]) return a;
        else return A[a] = find(A[a]);
    }

    public static class Node{
        int a;
        int b;
        int w;
        public Node(int a, int b,int w){
            this.a=a;
            this.b=b;
            this.w=w;
        }
    }
}