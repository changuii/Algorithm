import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Node>> A = new ArrayList<>();
        for(int i=0; i<=N; i++){
            A.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            A.get(b).add(new Node(a, w));
        }
        
        st = new StringTokenizer(br.readLine());
        int[] B = new int[K];
        for(int i=0; i<K; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }
        
        long[] distance = new long[N+1];
        Arrays.fill(distance, Long.MAX_VALUE);
        makeDistance(distance, A, B);
        
        int ix = 1;
        for(int i=1; i<=N; i++){
            if(distance[ix] < distance[i]){
                ix = i;
            }
        }
        
        System.out.println(ix);
        System.out.println(distance[ix]);
        
        
    }

    public static void makeDistance(long[] distance, ArrayList<ArrayList<Node>> A, int[] starts){
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) ->{
            return Long.compare(o1.dis, o2.dis);
        });

        for(int start : starts){
            q.offer(new Node(start, 0));
            distance[start] = 0;
        }
        while(!q.isEmpty()){
            Node now = q.poll();
            if(now.dis > distance[now.index]) continue;

            for(Node next : A.get(now.index)){
                if(now.dis + next.dis < distance[next.index]){
                    distance[next.index] = now.dis + next.dis;
                    q.offer(new Node(next.index, distance[next.index]));
                }
            }
        }
    }

    static class Node{
        int index;
        long dis;
        public Node(int index, long dis){
            this.index=index;
            this.dis=dis;
        }
    }
}