import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());


        st =new StringTokenizer(br.readLine());
        int[] A = new int[N];
        int max = 0;
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, A[i]);
        }

        int min = 0;
        int mid = 0;
        max++;

        while (min <= max) {
            mid = (max + min) / 2;
            // System.out.println(min + " " + max + " " + mid);
            if(mid == 0){
                System.out.println(0);
                return;
            }
            

            int c = 0;
            for(int i=0; i<N; i++){
                c += (A[i] / mid);
            }
            
            if(c >= M){
                min = mid + 1;
            }
            else{
                max = mid - 1;
            }
        }
        System.out.println(min - 1);

        
    }
}