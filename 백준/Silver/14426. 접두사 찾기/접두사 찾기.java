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

        String[] A = new String[N];
        String[] B = new String[M];

        for(int i=0; i<N; i++){
            A[i] = br.readLine();
        }

        for(int i=0; i<M; i++){
            B[i] = br.readLine();
        }

        Arrays.sort(A);

        int c= 0;
        for(int i=0; i<M; i++){
            if(binarySearch(A, B[i])){    
                c++;
                // System.out.println(B[i]);
            }
        }
        System.out.println(c);

        

    }

    public static boolean binarySearch(String[] A, String target){
        int l = 0;
        int h = A.length - 1;
        int mid = 0;

        while (l <= h) {
            mid = (l + h) / 2;

            if(A[mid].startsWith(target)) return true;
            int val = A[mid].compareTo(target);
            // System.out.println(val + " " + A[mid] + " " + target);
            if(val > 0){
                h = mid-1;
            }
            else{
                l = mid + 1;
            }
        
        }

        return false;
    }
    
}