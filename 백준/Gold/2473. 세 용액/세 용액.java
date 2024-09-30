import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] A = new int[N];
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        long answer = Long.MAX_VALUE;
        long[] value = new long[3];
        for(int i=0; i<N-2; i++){
            long now = A[i];

            int l =i+1;
            int h = N-1;
            while (l < h) {
                long val = A[l] + A[h] + now;

                if(answer > Math.abs(val)){
                    answer = Math.abs(val);
                    value = new long[]{A[i], A[l], A[h]};
                }

                if(val < 0){
                    l++;
                }
                else{
                    h--;
                }
            }
        }
        // Arrays.sort(value);
        System.out.println(value[0] + " " + value[1] + " " + value[2]);
        
    }
}