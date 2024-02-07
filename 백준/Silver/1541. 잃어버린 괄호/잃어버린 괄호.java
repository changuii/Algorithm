import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");


        String[] A = new String[st.countTokens()];

        for(int i=0; i<A.length; i++){
            A[i] = st.nextToken();
        }


        for(int i=0; i<A.length; i++){
            st = new StringTokenizer(A[i], "+");
            int sum = 0;
            while (st.hasMoreTokens()){
                sum += Integer.parseInt(st.nextToken());
            }
            A[i] = sum+"";
        }

        int answer = Integer.parseInt(A[0]);
        for(int i=1; i<A.length; i++){
            answer -= Integer.parseInt(A[i]);
        }

        System.out.println(answer);

    }
}