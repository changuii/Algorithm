import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine())+1;
        int[] D = new int[N];
        ArrayList<Integer>[] A = new ArrayList[N];
        for(int i=1; i<N; i++){
            D[i] = 0;
            A[i] = new ArrayList<>();
        }

        int[] time = new int[N];
        for(int i=1; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            time[i] = Integer.parseInt(st.nextToken());
            while (true){
                int now = Integer.parseInt(st.nextToken());
                if(now == -1) break;
                A[now].add(i);
                D[i]++;
            }
        }

        StringBuilder sb = new StringBuilder();
        int[] answer = new int[N];
        for(int i=1; i<N; i++){
            int now = 1;
            for(int j=1; j<N; j++){
                if(D[j] == 0){
                    now = j;
                    D[j] = -1;
                    break;
                }
            }
            for(int x : A[now]){
                D[x]--;
                answer[x] = Math.max(answer[x], answer[now] + time[now]);
            }
        }

        for(int i=1; i<N; i++){
            sb.append(answer[i] + time[i]).append("\n");
        }
        System.out.println(sb);

    }
}