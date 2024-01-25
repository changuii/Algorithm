import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static ArrayList<Integer>[] A;
    static boolean[] V;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken())+1;
        int M = Integer.parseInt(st.nextToken());

        A = new ArrayList[N];
        V = new boolean[N];
        for(int i=0; i<N; i++){
            A[i] = new ArrayList<>();
        }

        for(int i=1; i<M+1; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }

        int answer= 0;
        for(int i = 1; i<N; i++){
            if(!V[i]){
                answer++;
                DFS(i);
            }
        }
        System.out.println(answer);
    }
    public static void DFS(int x){
        if(V[x]) return;

        V[x] = true;
        for(int z : A[x]){
            if(!V[z])
                DFS(z);
        }
    }
}