import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        long answer = 0 ;
        for(int i=0; i<N; i++){
            answer += binarySearch(A, i+1, N-1, A[i]) - i;
        }
        System.out.println(answer);
    }


    public static int binarySearch(int[] A, int l, int h, int target){

        int mid = 0;
        while (l <= h) {
            mid = (l + h) / 2;

            if(target * 10 < A[mid] * 9){
                h = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        // System.out.println(target + " " + h);
        return h;
        

        
    }
}