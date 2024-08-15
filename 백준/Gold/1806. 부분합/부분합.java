import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        
        int[] A = new int[N];
        int max = 0;
        int sum = 0;
        
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
            sum += A[i];
            max = Math.max(A[i], max);
        }

        if(sum < S) System.out.println(0);
        else if(max >= S) System.out.println(1);
        else{

            int i = 0;
            int j = 1;
            int min = Integer.MAX_VALUE;
            int now = A[i] + A[j];
            while(i < j){
                if(now >= S){
                    min = Math.min(j - i + 1, min);
                    now -= A[i++];
                }else if(j < N-1){
                    now += A[++j];
                }else if(j == N-1){
                    now -= A[i++];
                }
            }
            System.out.println(min);
        }
        
    }
}