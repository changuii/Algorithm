import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken())+1;
        int K = Integer.parseInt(st.nextToken());


        int[] A = new int[N];
        long count = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<N; i++){
            A[i] = A[i-1] + Integer.parseInt(st.nextToken());
            if(A[i] == K) count++;
        }

        Map<Integer, Integer> value = new HashMap<>();
        for(int i=1; i<N; i++){
            if(value.containsKey(A[i]-K)){
                count += value.get(A[i]-K);
            }

            if(value.containsKey(A[i])) value.put(A[i], value.get(A[i]) + 1);
            else{
                value.put(A[i], 1);
            }
        }

        System.out.println(count);
    }
}