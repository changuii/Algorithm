import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        int max = -1001;
        int[] left = new int[N];
        max = Math.max(max, left[0] = A[0]);
        for(int i=1; i<N; i++){
            left[i] = Math.max(left[i-1]+A[i], A[i]);
            max = Math.max(left[i], max);
        }

        int[] right = new int[N];
        right[N-1] = A[N-1];
        for(int i=N-2; i>=0; i--){
            right[i] = Math.max(right[i+1]+A[i], A[i]);
        }


        for(int i=1; i<N-1; i++){
            int value = Math.max(max, left[i-1] + right[i+1]);
            max = Math.max(value, max);
        }
        System.out.println(Math.max(max, right[N-1]));

    }

}