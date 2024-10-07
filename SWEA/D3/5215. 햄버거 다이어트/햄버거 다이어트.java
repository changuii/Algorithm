import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    static int max;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t=1; t<=T; t++){

            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Node[] A = new Node[N];
            for(int i=0; i<N; i++){
                st=new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                A[i] = new Node(a, b);
            }
            max = 0;
            DFS(A, 0, 0, 0, M);

            sb.append("#").append(t).append(" ")
                .append(max).append("\n");
        }
        System.out.println(sb);
    }

    public static void DFS(Node[] A, int now, int t, int k, int M){
        if(k > M) return;
        else{
            max = Math.max(max, t);

            for(int i=now; i<A.length; i++){
                DFS(A, i+1, t + A[i].a, k+A[i].b, M);
            }
        }
        
    }

    

    public static class Node{
        int a;
        int b;
        public Node(int a, int b){
            this.a=a;
            this.b=b;
        }
    }
}