import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Main {
    static int[] A;
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine(), " ");

       int N = Integer.parseInt(st.nextToken())+1;
       int M = Integer.parseInt(st.nextToken());
       A = new int[N];

       for(int i=1; i<N; i++){
           A[i] = i;
       }

       st = new StringTokenizer(br.readLine(), " ");
       int T = Integer.parseInt(st.nextToken());
       int target = Integer.parseInt(T > 0 ? st.nextToken() : "0");
       for(int i=1; i<T; i++){
            union(target, Integer.parseInt(st.nextToken()));
       }

       Queue<Integer> q = new LinkedList<>();
       for(int i=0; i<M; i++){
           st = new StringTokenizer(br.readLine(), " ");
           int C = Integer.parseInt(st.nextToken());
           int first = C > 0 ? Integer.parseInt(st.nextToken()) : 0;
           for(int j=1; j<C; j++){
                union(first, Integer.parseInt(st.nextToken()));
           }
           q.add(first);
       }

       int answer = 0;
       while (!q.isEmpty()){
           if(find(q.poll()) != find(target)) answer++;
       }

       System.out.println(answer);
    }

    static void union(int a, int b){
        int x = find(a);
        int y = find(b);

        A[y] = x;
    }
    static int find(int a){
        if(A[a] == a){
            return a;
        }else{
            A[a] = find(A[a]);
            return A[a];
        }
    }
}