import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int t = 0; t<T; t++){
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] A = new int[N];
            int[] B = new int[M];
            
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                A[i] = Integer.parseInt(st.nextToken());
            }
            
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++){
                B[i] = Integer.parseInt(st.nextToken());
            }

            long answer = 0;
            Arrays.sort(B);

            for(int i=0; i<N; i++){
                answer += binarySearch(B, A[i]);
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);        
    }

    public static int binarySearch(int[] B, int target){
        int l = 0;
        int h = B.length-1;
        int mid = 0;

        while (l <= h) {
            mid = (l + h) / 2;

            if(B[mid] < target){
                l = mid + 1;
            }
            else{
                h = mid - 1;
            }
        }

        return l;
    }
}