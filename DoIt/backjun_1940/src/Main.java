import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        int start = 0;
        int end = N-1;
        int count = 0;
        while(start < end){
            int sum = A[start] + A[end];
            if(sum == M)   {
                count++;
                start++;
                end--;
            }
            else if(sum < M) start++;
            else if(sum > M) end--;
        }
        System.out.println(count);
    }
}