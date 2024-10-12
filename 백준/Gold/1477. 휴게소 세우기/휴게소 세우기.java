import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static Map<String, Integer> map = new HashMap<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] A = new int[N+2];
        A[0] = 0;
        A[N+1] = L;
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<N+1; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        int l = 1;
        int h = L;
        int mid = 0;

        while (l <= h) {
            mid = (l + h) / 2;

            if(isValid(A, mid, M)){
                h = mid - 1;
            }else{
                l = mid + 1;
            }   
        }   
        System.out.println(h + 1);
    }

    public static boolean isValid(int[] A, int distance, int M){
        int c = 0;
        for(int i=1; i<A.length; i++){
            c += (A[i] - A[i-1]) / distance;
            if((A[i] - A[i-1]) % distance == 0) c--;
            if(c > M) return false;
        }
        return true;
    }
}