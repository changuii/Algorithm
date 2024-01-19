import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }
        for(int i=0; i<A.length; i++){
            for(int j=0; j<N-1; j++){
                int temp = 0;
                if(A[j] > A[j+1]){
                    temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                }
            }
            N--;
        }

        for(int i=0; i<A.length; i++){
            System.out.println(A[i]);
        }
    }
}