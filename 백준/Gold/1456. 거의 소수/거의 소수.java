import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        long[] A = new long[10000001];
        for(int i= 2; i< A.length; i++){
            A[i] = i;
        }
        
        for(int i=2; i<Math.sqrt(A.length); i++){
            if(A[i] == 0) continue;
            for(int j = i + i; j < A.length ; j += i){
                A[j] = 0;
            }
        }

        int answer = 0;
        for(int i= 2; i< A.length; i++){
            if(A[i] != 0){
                long temp = A[i];
                while ((double)A[i] <= (double) M / (double) temp){
                    if((double)A[i] >= (double) N/ (double) temp){
                        answer++;
                    }
                    temp *= A[i];
                }
            }
        }
        System.out.println(answer);


    }





}