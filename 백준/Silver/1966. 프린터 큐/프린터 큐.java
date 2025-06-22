import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            int[] count = new int[10];
            Deque<int[]> q = new ArrayDeque<>();
            for(int j=0; j<n; j++){
                int v = Integer.parseInt(st.nextToken());
                count[v]++;
                q.addLast(new int[]{v, j});
            }

            int c = 0;
            while(!q.isEmpty()){
                int[] v = q.pollFirst();
                boolean flag = false;

                for(int j=v[0]+1; j<10; j++){
                    if(count[j] != 0){
                        flag = true;
                        break;
                    }
                }

                if(!flag){
                    c++;
                    count[v[0]]--;
                    if(v[1] == m){
                        sb.append(c).append("\n");
                        break;
                    }
                } else{
                    q.addLast(v);
                }
            }
        }

        System.out.println(sb);
    }
}