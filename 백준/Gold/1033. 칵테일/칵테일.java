import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static List<Node>[] A;
    static boolean[] V;
    static long[] data;
    static long lcm;
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       int N = Integer.parseInt(br.readLine());
       A = new ArrayList[N];
       data = new long[N];
       V = new boolean[N];
       lcm = 1;
       for(int i=0; i<A.length; i++){
           A[i] = new ArrayList<>();
       }

       StringTokenizer st;
       for(int i=0; i<N-1; i++){
           st = new StringTokenizer(br.readLine(), " ");
           int a = Integer.parseInt(st.nextToken());
           int b = Integer.parseInt(st.nextToken());
           int p = Integer.parseInt(st.nextToken());
           int q = Integer.parseInt(st.nextToken());

           A[a].add(new Node(b, p, q));
           A[b].add(new Node(a, q, p));
           lcm *= (p*q / gcd(p, q));
       }
       data[0] = lcm;
       DFS(0);
       long mgcd = data[0];

       for(int i=1; i<N; i++){
           mgcd = gcd(mgcd, data[i]);
       }


       StringBuilder sb = new StringBuilder();
       for(long x : data){
           sb.append(x / mgcd).append(" ");
       }

        System.out.println(sb);



    }

    private static void DFS(int now){
        V[now] = true;

        for(Node x : A[now]){
            if(!V[x.b]){
                data[x.b] = data[now] * x.q / x.p;
                DFS(x.b);
            }
        }


    }

    private static long gcd(long a, long b){
        if(a % b == 0) return b;
        else return gcd(b, a%b);
    }

    static class Node{
        int b;
        int p;
        int q;

        Node(int b, int p, int q){
            this.b=b;
            this.p=p;
            this.q=q;
        }
    }



}