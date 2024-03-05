import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static ArrayList<Integer>[] A;
    static int[] answer;
    static boolean[] V;
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine())+1;

        A = new ArrayList[N];
        answer = new int[N];
        V = new boolean[N];

        for(int i=1; i<N; i++){
            A[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for(int i=1; i<N-1; i++){
            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[a].add(b);
            A[b].add(a);
        }

        DFS(1);
        StringBuilder sb  = new StringBuilder();
        for(int i=2; i<N; i++){
            sb.append(answer[i]).append("\n");
        }

        System.out.println(sb);
    }

    static public void DFS(int a){

        V[a] = true;
        for(int x : A[a]){
            if(!V[x]){
                answer[x] = a;
                DFS(x);
            }
        }
    }

}