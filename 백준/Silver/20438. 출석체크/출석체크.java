import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static int[] A;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken())+3;
        int K = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        A = new int[N];
        for(int i=3; i<N; i++){
            A[i] = 0;
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<K; i++){
            A[Integer.parseInt(st.nextToken())] = -1;
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<Q; i++){
            check(Integer.parseInt(st.nextToken()));
        }

        int[] value = new int[N];
        for(int i=3; i<N; i++){
            value[i] = value[i-1] + (A[i] != 1 ? 1 : 0);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(value[end] - value[start-1]).append("\n");
        }
        System.out.println(sb);

    }

    public static void check(int a){
        if(A[a] == -1 ) return;

        int count = 2;
        for(int i=a; i<N; i = a * count++){
            if(A[i] == 0) {
                A[i] = 1;
                check(i);
            }
        }
    }



}