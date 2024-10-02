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

        char[][] A = new char[N][M];
        for(int i=0; i<N; i++){
            A[i] = br.readLine().toCharArray();
        }

        int l = 0;
        int h = A.length-1;
        int mid = 0;
        
        while (l<=h) {
            mid = (l + h) / 2;

            // System.out.println(mid + " ");
            if(check(A, mid)){
                l = mid + 1;
                // System.out.println(true);
            }
            else{
                h = mid - 1;
                // System.out.println(false);
            }
        }
        System.out.println(l-1);
        
        
        
    }

    public static boolean check(char[][] A, int distance){


        Set<String> set = new HashSet<>();
        for(int j=0; j<A[0].length; j++){
            String v = "";
            for(int i=A.length-1; i>=distance; i--){
                v += A[i][j];
            }    
            if(set.contains(v)) return false;
            set.add(v);
        }
        return true;
    }
    
}