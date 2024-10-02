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
        for(int t=0; t<T; t++){

            int N = Integer.parseInt(br.readLine());
            int[] A = new int[N];
            
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                A[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(A);

            int c = 0;
            for(int i=0; i<N; i++){
                for(int j=i+1; j<N; j++){
                    if(binarySearch(A, A[j] - A[i], j)){
                        c++;
                        // System.out.println(A[i] + ", " + A[j]);
                    }
                        
                }
            }   
            sb.append(c).append("\n");
        }
        System.out.println(sb);
        
    }

    public static boolean binarySearch(int[] A, int target, int j){
        int l = j;
        int h = A.length-1;
        int mid = 0;
        
        while (l <= h) {
            mid = (l + h) / 2;

            if(A[mid] - A[j] == target) {
                // System.out.print("A[mid] : " + A[mid] + " ");
                return true;
            }
            else if(A[mid] - A[j] > target){
                h = mid - 1;
            } 
            else{
                l = mid + 1;
            }
        }

        return false;

        
    }
}