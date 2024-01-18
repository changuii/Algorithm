import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        int[] A = new int[N];
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int count = 0;
        for(int i=0; i<N; i++) {
            long target = A[i];
            int start = 0;
            int end = N-1;
            while (start < end) {
                long sum = A[start] + A[end];
                if (sum == target) {
                    if(start != i && end != i) {
                        count++;
                        break;
                    }else if (i == start){
                        start++;
                    }else if(i == end){
                        end--;
                    }
                }else if(sum < target) start++;
                else end--;
            }
        }
        System.out.println(count);


    }
}