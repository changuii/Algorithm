import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N+2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 2번째 공장의 라면 수가 3번째 공장 수보다 작다면, 7원이 아닌 5원으로 구매해야 함
        int answer = 0;
        for(int i=0; i<N; i++){
            if(A[i] == 0) continue;

            int temp = A[i];
            answer += A[i] * 3;
            temp = Math.min(A[i], A[i+1]);
            answer += temp * 2;
            A[i+1] -= temp;
            temp = Math.min(temp, A[i+2] - Math.min(A[i+1], A[i+2]));
            answer += temp * 2;
            A[i+2] -= temp;
            
        }

        System.out.println(answer);
        
    }
}