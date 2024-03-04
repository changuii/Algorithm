import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static boolean[] V;
    static ArrayList<Integer>[] A;
    static int[] answer;
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       int N = Integer.parseInt(br.readLine())+1;
       A = new ArrayList[N];
       V = new boolean[N];
       answer = new int[N];
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

       BFS(1);
       StringBuilder sb = new StringBuilder();
       for(int i=2; i<N; i++){
           sb.append(answer[i]).append("\n");
       }

        System.out.println(sb);

    }
    public static void BFS(int a){
        Queue<Integer> q = new LinkedList<>();

        q.add(a);
        V[a] = true;
        while (!q.isEmpty()){
            int now = q.poll();
            for(int x : A[now]){
                if(!V[x]){
                    V[x] = true;
                    q.add(x);
                    answer[x] = now;
                }
            }
        }


    }


}