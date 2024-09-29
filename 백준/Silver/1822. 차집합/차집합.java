import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());



        int[] A = new int[N];
        int[] B = new int[M];

        st =new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        st =new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B);

        int c = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            if(!binarySearch(B, A[i])){
                sb.append(A[i]).append(" ");
                c++;
            }
        }
        System.out.println(c);
        System.out.println(sb);
        
        
    }

    public static boolean binarySearch(int[] B, int target){
        int l = 0;
        int h = B.length-1;
        int mid = 0;
        
        while (l <= h) {
            mid = (l + h) / 2;

            if(B[mid] == target){
                return true;
            }
            else if(B[mid] < target){
                l = mid + 1;
            }
            else{
                h = mid -1;
            }
        }
        return false;
        
    }
}