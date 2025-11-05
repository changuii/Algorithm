import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        List<List<Integer>> map = new ArrayList<>();
        for(int i=0; i<=N; i++){
            map.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map.get(a).add(b);
            map.get(b).add(a);
        }

        for(int i=1; i<=N; i++) {
            Collections.sort(map.get(i));
        }

        StringBuilder result = new StringBuilder();
        dfs(map, new boolean[N+1], V, result);
        result.append("\n");
        bfs(map, V, result);

        System.out.println(result);
    }

    public static void dfs(List<List<Integer>> map, boolean[] visit, int now, StringBuilder result) {
        visit[now] = true;
        result.append(now).append(" ");
        
        for(int next : map.get(now)) {
            if(!visit[next]) {
                dfs(map, visit, next, result);
            }
        }
    }

    public static void bfs(List<List<Integer>> map, int first, StringBuilder result) {
        Deque<Integer> q = new ArrayDeque<>();

        boolean[] visit = new boolean[map.size()];
        q.addLast(first);
        visit[first] = true;

        while (!q.isEmpty()) {
            int now = q.pollFirst();
            result.append(now).append(" ");

            for(int next: map.get(now)) {
                if(!visit[next]) {
                    visit[next] = true;
                    q.addLast(next);
                }
            }
            
        }
    }
}