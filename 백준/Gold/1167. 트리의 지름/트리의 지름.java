import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static ArrayList<Node>[] A;
    static boolean[] V;
    static int[] distance;

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st;

       int N = Integer.parseInt(br.readLine())+1;
       A = new ArrayList[N];
       V = new boolean[N];
       distance = new int[N];
       for(int i=0; i<N; i++){
           A[i] = new ArrayList<>();
       }

       for(int i=1; i<N; i++){
           st = new StringTokenizer( br.readLine(), " ");
           int index = Integer.parseInt(st.nextToken());
           while(true){
               int v = Integer.parseInt(st.nextToken());
               if(v == -1) break;
               int distance = Integer.parseInt(st.nextToken());
               A[index].add(new Node(distance, v));
           }
       }

       BFS(1);

       int max = 1;
       for(int i = 2; i<N; i++){
           if(distance[max] < distance[i]) max = i;
       }
       distance = new int[N];
       V = new boolean[N];
       BFS(max);

       Arrays.sort(distance);
       System.out.println(distance[N-1]);
    }
    public static void BFS(int value){
        Queue<Integer> q = new LinkedList<>();
        q.add(value);
        V[value] = true;
        while (!q.isEmpty()){
            int x = q.poll();
            for(Node node : A[x]){
                if(!V[node.v]){
                    distance[node.v] = node.distance + distance[x];
                    V[node.v] = true;
                    q.add(node.v);
                }
            }
        }
    }


    public static class Node{
        int distance;
        int v;

        public Node(int distance, int v){
            this.v = v;
            this.distance = distance;
        }
    }
}