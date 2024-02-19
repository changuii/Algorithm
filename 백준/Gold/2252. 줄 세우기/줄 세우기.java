import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken())+1;
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] A = new ArrayList[N];
        int[] D = new int[N];
        for(int i=1; i<N; i++){
            A[i] = new ArrayList<>();
            D[i] = 0;
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[a].add(b);
            D[b]++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<N; i++){
            int now = 0;
            for(int j=1; j<N; j++){
                if(D[j] == 0){
                    now = j;
                    D[now] = -1; 
                    break;
                }
            }
            sb.append(now).append(" ");
            for(int x : A[now]){
                D[x]--;
            }
        }

        System.out.println(sb);

    }
}