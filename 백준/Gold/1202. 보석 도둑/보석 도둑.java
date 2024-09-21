import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> A = new PriorityQueue<>((o1, o2) ->{
            return o1.v - o2.v;
        });
        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            A.add(new Node(a, b));
        }

        PriorityQueue<Integer> B = new PriorityQueue<>();
        
        for(int i=0; i<M; i++){
            int now = Integer.parseInt(br.readLine());

            B.add(now);
        }

        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) ->{
            return o2.p - o1.p;
        });

        int index = 0;
        long answer = 0;
        while(!B.isEmpty()){
            int now = B.poll();

            while(!A.isEmpty() && now >= A.peek().v){
                q.add(A.poll());
            }

            if(!q.isEmpty())
                answer += q.poll().p;
        }
        
        System.out.println(answer);   
        
    }


    static class Node{
        int v;
        int p;

        public Node(int v, int p){
            this.v=v;
            this.p=p;
        }
    }
}