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
            int N = 9;
            win = 0;
            lose = 0;

            st = new StringTokenizer(br.readLine());
            int[] card = new int[19];
            int[] A = new int[N];
            int[] B = new int[N];

            for(int i=0; i<N; i++){
                A[i] = Integer.parseInt(st.nextToken());
                card[A[i]] = 1;
            }

            int index = 1;
            for(int i=0; i<N; i++){
                while (card[index] != 0) {
                    index++;
                }
                B[i] = index++;
            } 
            DFS(A, B, new boolean[N], 0, 0);
            
            sb.append(String.format("#%d %d %d\n", t, win, lose));
        }
        System.out.println(sb);
    }

    public static void DFS(int[] A, int[] B, boolean[] visit, int depth, int sum){
        if(depth == 9){
            if(sum > 0){
                win++;
            } else if (sum < 0){
                lose++;
            }
            return;
        }

        for(int i=0; i<B.length; i++){
            if(!visit[i]){
                visit[i] = true;
                int score = B[i] + A[depth];
                DFS(A, B, visit, depth + 1, sum + (B[i] < A[depth] ? score : score * -1));
                visit[i] = false;
            }
        }

        
    }
}