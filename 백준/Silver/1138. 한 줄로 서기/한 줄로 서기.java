import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];
        for(int i=1; i<=N; i++){
            int now = Integer.parseInt(st.nextToken());
            arr[i] = now;
        }

        // i를 선택한 후, i보다 작은 값들 -1;
        boolean[] visit = new boolean[N+1];
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            int x = 0;
            for(int j=1; j<=N; j++){
                if(arr[j] <= 0 && !visit[j]){
                    x = j;
                    visit[j] = true;
                    break;
                }
            }
            for(int j=1; j<x; j++){
                arr[j]--;
            }
            sb.append(x).append(" ");
        }
        System.out.println(sb);
        
    }
}