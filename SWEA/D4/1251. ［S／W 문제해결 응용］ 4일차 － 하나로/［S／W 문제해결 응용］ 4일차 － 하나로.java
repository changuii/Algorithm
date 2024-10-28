import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    static int[] set;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t=1; t<=T; t++){
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st;
            
            int[][] G = new int[N][2];
            set = new int[N];

            for(int i=0; i<N; i++){
                set[i] = i;
            }

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                G[i][0] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                G[i][1] = Integer.parseInt(st.nextToken());
            }

            double E = Double.parseDouble(br.readLine());

            PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> {
               return Double.compare(o1.val, o2.val); 
            });
            
            for(int i=0; i<N; i++){
                for(int j=i+1; j<N; j++){
                    double val = Math.sqrt(Math.pow(G[i][0] - G[j][0], 2) + Math.pow(G[i][1] - G[j][1], 2));
                    q.offer(new Node(i, j, (val*val)*E));
                }
            }

            double sum = 0;
            int c = 0;
            while (c < N-1) {
                Node now = q.poll();
                
                if(find(now.x) == find(now.y)) continue;
                c++;
                
                union(now.x, now.y);
                sum += now.val;
            }
            
            sb.append(String.format("#%d %d\n", t, Math.round(sum)));
        }
        System.out.println(sb);
    }
    
    public static class Node{
        int x;
        int y;
        double val;

        public Node(int x, int y, double val){
            this.x=x;
            this.y=y;
            this.val=val;
        }
    }

    public static void union(int a, int b){
        int x = find(a);
        int y = find(b);

        set[y] = x;   
    }

    public static int find(int a){
        if(set[a] == a){
            return a;
        }
        else return set[a] = find(set[a]);
    }
}