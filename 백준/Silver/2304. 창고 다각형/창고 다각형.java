import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Node[] A = new Node[N];

        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            A[i] = new Node(
              Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(A, (o1, o2) ->{
           return o1.x-o2.x; 
        });

        int max = 0;
        for(int i=0; i<N; i++){
            if(A[max].w < A[i].w){
                max = i;
            }
        }

        long answer = 0;
        int val = 0;
        for(int i=0; i<=max; i++){
            if(A[i].w >= A[val].w){
                answer += (A[i].x - A[val].x) * A[val].w;
                // System.out.println(A[i].w + " " + A[val].w + " " + val + " " + i);
                val = i;
            }       
        }

        val = N-1;
        for(int i=N-1; i>=max; i--){
            if(A[i].w >= A[val].w){
                answer += (A[val].x - A[i].x) * A[val].w;
                // System.out.println(A[i].w + " " + A[val].w + " " + val + " " + i);
                val = i;
            }
        }
        System.out.println(answer + A[val].w);

        
        
    }
    public static class Node{
        int x;
        long w;
        public Node(int x, long w){
            this.x=x;
            this.w=w;
        }
    }
}