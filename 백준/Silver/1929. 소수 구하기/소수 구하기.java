import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken())+1;

        boolean[] A = new boolean[N];
        for(int i=2; i<Math.sqrt(N); i++){
            int index = 2;
            while (true){
                int now = i*index++;
                if(now < N && !A[now]) A[now] = true;
                else if(now > N) break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i= M > 1 ? M : 2; i<N; i++){
            if(!A[i]) sb.append(i).append("\n");
        }

        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }

        System.out.println(sb);
    }





}