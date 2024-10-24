import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        while (!input.equals("0")) {
            st = new StringTokenizer(input);

            int N = Integer.parseInt(st.nextToken());
            int[] A = new int[N];

            for(int i=0; i<N; i++){
                A[i] = Integer.parseInt(st.nextToken());
            }

            DFS(sb, "", A, 0, new boolean[N], 0);
            sb.append("\n");
            input = br.readLine();
        }
        System.out.println(sb);

        
    }

    public static void DFS(StringBuilder sb, String temp, int[] A, int now, boolean[] visit, int depth){
        if(depth == 6){
            sb.append(temp).append("\n");
        }
        else{
            for(int i=now; i<A.length; i++){
                if(!visit[i]){
                    visit[i] = true;
                    String next = temp + A[i] + " ";
                    DFS(sb, next, A, i+1, visit, depth + 1);
                    visit[i] = false;
                }
            }
            
        }

        
    }
}