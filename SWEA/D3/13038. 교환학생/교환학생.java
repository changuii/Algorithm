import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.Collectors;

// The main method must be in a class named "Main".
class Solution {
    static int win;
    static int lose;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int t=1; t<=T; t++){
            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            
            int[] A = new int[7];
            for(int i=0; i<7; i++){
                A[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=5; i>=0; i--){
                if(A[i+1] >= 1 && A[i] == 0){
                    A[i] = A[i+1] + 1;
                }
            }

            int now = 0;
            for(int i=0; i<7; i++){
                if(now == 0 && A[i] == 1){
                    now = 8;
                }
                else if(A[i] == 0 && now != 0){
                    A[i] = now;
                }
                if(now != 0) now--;
            }

            int min = Integer.MAX_VALUE;
            for(int i=0; i<7; i++){
                if(A[i] == 1) min = Math.min(min, answer(A, N, i));
            }

            sb.append(String.format("#%d %d\n", t, min));
        }
        System.out.println(sb);
    }

    public static int answer(int[] A, int N, int start){
        int answer = 1;
        int now = start;
        while (N > 0) {
            if(A[now] == 1){
                N--;
                if(N == 0) return answer;
                now = (now + 1) % 7;
                answer += 1;
            }
            else{
                answer += A[now] - 1;
                now = (now + A[now] - 1) % 7;
            }
        }
        
        return answer;
    }
}