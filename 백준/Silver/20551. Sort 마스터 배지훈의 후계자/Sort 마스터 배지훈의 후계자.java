import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }

        int[] B = new int[M];
        for(int i=0; i<M; i++){
            B[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(A);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            sb.append(binarySearch(A, B[i])).append("\n");
        }
        System.out.println(sb);
        
        
    }

    public static int binarySearch(int[] A, int target){
        int l = 0;
        int h = A.length-1;
        int mid = 0;
        
        while (l <= h) {
            mid = (l + h) / 2;

            if(A[mid] >= target){
                h = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }

        if(h+1 >= A.length) return -1;

        if(A[h+1] == target) return h+1;
        else return -1;
    }
}