import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Main {
    static ArrayList<Integer> P;
    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken())+1;
        int M = Integer.parseInt(st.nextToken());
        A = new int[N];
        for(int i=1; i<N; i++){
            A[i] = i;
        }

        st = new StringTokenizer(br.readLine(), " ");
        int p = Integer.parseInt(st.nextToken());
        P = new ArrayList<>();
        for(int i=0; i<p; i++){
            P.add(Integer.parseInt(st.nextToken()));
        }

        int answer = 0;
        Queue<Integer> answerQ = new LinkedList<>();

        int target = P.size() > 0 ? P.get(0) : 0;
        for(int i=1; i<p; i++){
            union(target, P.get(i));
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int count = Integer.parseInt(st.nextToken());

            Queue<Integer> q = new LinkedList();
            for(int j=0; j<count; j++){
                q.add(Integer.parseInt(st.nextToken()));
            }

            int value = q.poll();
            while (!q.isEmpty()){
                union(value, q.poll());
            }
            answerQ.add(value);
        }

        for(int i=0; i<M; i++){
            if(find(target) != find(answerQ.poll())) answer++;
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