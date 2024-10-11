import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 10;
        
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());

            ArrayList<ArrayList<Integer>> A = new ArrayList<>();
            for(int i=0; i<=100; i++){
                A.add(new ArrayList<>());
            }
            
            int N = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N/2; i++){
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                A.get(a).add(b);
            }

            
            sb.append(String.format("#%d %d\n", t, BFS(A, start)));
        }
        System.out.println(sb);
    }

    public static int BFS(ArrayList<ArrayList<Integer>> A, int start){
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visit = new boolean[101];
        
        q.offer(new int[]{start, 0});
        visit[start] = true;
        int[] max = {start, 0};
        while (!q.isEmpty()) {
            int[] now = q.poll();

            if(now[1] > max[1] || (now[1] == max[1] && now[0] > max[0])){
                max[0] = now[0];
                max[1] = now[1];
            }

            for(int next : A.get(now[0])){
                if(!visit[next]){
                    visit[next] = true;
                    q.offer(new int[]{next, now[1] + 1});
                }
            }
        }
        return max[0]; 
    }
}