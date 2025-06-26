import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] value;
    static int[] rank;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        value = new int[N+1];
        rank = new int[N+1];

        for(int i=1; i<=N; i++){
            value[i] = i;
        }

        StringTokenizer st;

        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> { 
            return o1[2] - o2[2];
        });
        
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            q.add(new int[]{a, b, c});
        }

        int sum = 0;
        int c = 0;
        while(c < N-1){
            int[] now = q.poll();

            if(find(now[0]) != find(now[1])){
                union(now[0], now[1]);
                sum += now[2];
                c++;
            }
        }
        
        System.out.println(sum);
    }

    public static void union(int a, int b){
        int x = find(a);
        int y = find(b);

        if(rank[x] > rank[y]){
            value[y] = x;
        } else if(rank[x] < rank[y]) {
            value[x] = y;
        } else {
            value[y] = x;
            rank[x]++;
        }
    }

    public static int find(int a){
        if(value[a] == a){
            return a;
        }
        return value[a] = find(value[a]);
    }

    
}