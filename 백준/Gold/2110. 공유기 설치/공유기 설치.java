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

        Arrays.sort(A);

        int l = 1;
        int h = A[N-1] - A[0] + 1;
        // 공유기 사이의 거리
        int mid = 0;

        while (l < h) {
            mid = (l + h) / 2;

            int val = isInstall(A, mid);
            if(val >= M){
                l = mid + 1;
            }
            else{
                h = mid;
            }            
        }

        System.out.println(l-1);
    }


    public static int isInstall(int[] A, int distance){

        int c = 1;
        int before = A[0];

        for(int i=1; i<A.length; i++){
            if(A[i] - before >= distance){
                c++;
                before = A[i];
            }
        }
        return c;
    }
}