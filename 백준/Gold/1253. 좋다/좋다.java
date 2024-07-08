import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] A = new int[N];
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int count = 0;
        for(int x=0; x<N; x++){
            int i = 0;
            int j = N-1;
            while(i < j){
                int sum = A[i] + A[j];
                if(sum > A[x]) j--;
                else if(sum < A[x]) i++;
                else {
                    if(i != x && j != x) {
                        count++;
                        break;
                    }else if(i == x){
                        i++;
                    }else if(j == x){
                        j--;
                    }
                }
            }
        }
        System.out.println(count);

    }
}