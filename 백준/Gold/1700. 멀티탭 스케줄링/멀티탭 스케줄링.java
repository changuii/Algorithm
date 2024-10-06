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

        int[] A = new int[M];
        Node[] B = new Node[M+1];
        for(int i=1; i<M+1; i++){
            B[i] = new Node(i, 101);
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            A[i] = Integer.parseInt(st.nextToken());
            if(B[A[i]].c == 101){
                B[A[i]].c = i;
            }
        }

        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) ->{
           return o2.c - o1.c; 
        });
        
        boolean[] visit = new boolean[M+1];
        int answer = 0;
        // Optiomal 
        for(int i=0; i<M; i++){
            // 전자제품 사용
            if(visit[A[i]]){
                B[A[i]].c = next(A, A[i], i);
                q.offer(q.poll());
            }
            // 플러그 공간 여유
            else if(q.size() < N){
                Node n = B[A[i]];
                n.c = next(A, A[i], i);
                q.offer(n);
                visit[n.n] = true;
            }
            // 플러그 교체
            else{
                answer++;
                visit[q.poll().n] = false;
                Node n = B[A[i]];
                n.c = next(A, A[i], i);
                q.offer(n);
                visit[n.n] = true;
            }
        }
        

        System.out.println(answer);
        

        
        
    }

    public static int next(int[] A, int index, int now){
        for(int i =now+1; i<A.length; i++){
            if(index == A[i]){
                return i;
            }
        }
        return 101;
    }
    
    public static class Node{
        int n;
        int c;
        public Node(int n, int c){
            this.n=n;
            this.c=c;
        }

        public String toString(){
            return n+"";
        }
        
    }
}