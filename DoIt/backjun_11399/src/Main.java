import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] A = new int[N];

        for(int i=0; i<N; i++){
            int target = Integer.parseInt(st.nextToken());
            int index = i;
            for(int j=i-1; j>=0; j--){
                if(target < A[j]){
                    A[j+1] = A[j];
                    index = j;
                }else {
                    index = j + 1;
                    break;
                }
            }
            A[index] = target;
        }

        int answer = A[0];
        for(int i=1; i<N; i++){
            A[i] += A[i-1];
            answer += A[i];
        }

        System.out.println(answer);
    }
}