import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static ArrayList<Integer>[] A;
    static boolean[] V;
    static int D;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

        int N =Integer.parseInt(br.readLine());

        V = new boolean[N];
        A = new ArrayList[N];
        for(int i=0; i<N; i++){
            A[i] = new ArrayList<>();
        }

        int root = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            int a = Integer.parseInt(st.nextToken());

            if(a != -1){
                A[i].add(a);
                A[a].add(i);
            }else{
                root = i;
            }
        }

        D = Integer.parseInt(br.readLine());
        BFS(root);
        System.out.println(answer);
    }


    public static void BFS(int a){
        if (a == D) return;
        Queue<Integer> q = new LinkedList<>();

        q.add(a);
        V[a] = true;
        while (!q.isEmpty()){
            int now = q.poll();
            int count = 0;
            for (int x : A[now]){
                if(!V[x] && x != D){
                    V[x] = true;
                    q.add(x);
                    count++;
                }
            }
            if(count == 0) {
                answer++;}
        }


    }


}