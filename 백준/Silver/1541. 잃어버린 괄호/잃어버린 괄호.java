import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    // 가장 큰 값을 빼는 것이 가장 이득
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        int N = st.countTokens();
        String[] A = new String[N];
        for(int i=0; i<N; i++){
            A[i] = st.nextToken();
        }

        for(int i=0; i<N; i++){
            st = new StringTokenizer(A[i], "+");
            int data = 0;
            while (st.hasMoreTokens()){
                data += Integer.parseInt(st.nextToken());
            }
            A[i] = data+"";
        }

        int answer = Integer.parseInt(A[0]);
        for(int i=1; i<N; i++){
            answer -= Integer.parseInt(A[i]);
        }

        System.out.println(answer);


    }





}