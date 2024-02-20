import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       int N = Integer.parseInt(br.readLine())+1;
       int M = Integer.parseInt(br.readLine());

       boolean[] V = new boolean[N];
       int[] distance = new int[N];
       ArrayList<Node>[] A = new ArrayList[N];
       for(int i=1; i<N; i++){
           A[i] = new ArrayList<>();
           distance[i] = INF;
       }

       StringTokenizer st;
       for(int i=0; i<M; i++){
           st = new StringTokenizer(br.readLine(), " ");
           int a = Integer.parseInt(st.nextToken());
           int b = Integer.parseInt(st.nextToken());
           int w = Integer.parseInt(st.nextToken());
           A[a].add(new Node(b, w));
       }
       st = new StringTokenizer(br.readLine(), " ");
       int S = Integer.parseInt(st.nextToken());
       int D = Integer.parseInt(st.nextToken());

       PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> {
           return o1.W - o2.W;
       });
       distance[S] = 0;
       q.add(new Node(S, 0));
       while (!q.isEmpty()){
           Node current = q.poll();
           if(V[current.D]) continue;
           V[current.D] = true;
           for(Node x : A[current.D]){
               if(!V[x.D]){
                   if(distance[x.D] > distance[current.D] + x.W){
                       distance[x.D] = distance[current.D] + x.W;
                       q.add(new Node(x.D, distance[x.D]));
                   }
               }
           }
       }
       System.out.println(distance[D]);



    }


    static class Node{
        int D;
        int W;
        Node(int D, int W){
            this.D=D;
            this.W=W;
        }


    }
}