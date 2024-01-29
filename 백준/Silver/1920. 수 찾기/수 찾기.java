import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static int[] A;
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st;

       int N = Integer.parseInt(br.readLine());
       A = new int[N];

       st = new StringTokenizer(br.readLine(), " ");
       for(int i=0; i<N; i++){
           A[i] = Integer.parseInt(st.nextToken());
       }
       Arrays.sort(A);

       int M = Integer.parseInt(br.readLine());
       st = new StringTokenizer(br.readLine(), " ");
       StringBuilder sb = new StringBuilder();
       for(int i=0; i<M; i++){
           sb.append(binarySearch(Integer.parseInt(st.nextToken()), 0, N-1)).append("\n");
       }

        System.out.println(sb);
     }

     private static int binarySearch(int t, int start, int end){
         int mid = start + (end - start) /2;

        if(end - start <1 && A[mid] != t) return 0;

        if(A[mid] == t) return 1;
        else if (A[mid] < t) return binarySearch(t, mid+1, end);
        else return binarySearch(t, start, mid);
     }

}